'use strict';

angular.module('gymSystem').service('ScheduleService', function($http, $filter) {

    this.getSchedules = function(callback) {

        $http.get('api/schedules').
            success(function(data) {

                callback(data);
            });
    };

    this.addSchedule = function(employeeId, courseId, time, callback) {

        $scope.date = Date.now();

        console.log(time);

        //function pad(n) {return n < 10 ? "0"+n : n;}
        //var result = time.getFullYear()+'-'+pad(time.getMonth()+1)+"-"+pad(time.getDate());

        $http({
            method: 'POST',
            url: 'api/schedules',
            data: {
                employee: {id: employeeId},
                course: {id: courseId},
                time: $filter('date')(time, 'yyyy-MM-dd')
            }
        }).success(function() {

            callback();
        }).error(function() {

            alert("该教练时间冲突，请重新操作！");
        });
    };

    this.addPrivateCoach = function(customerId, employeeId, time, callback) {

        $http({
            method: 'POST',
            url: 'api/schedules/private',
            params: {
                customerId: customerId,
                employeeId: employeeId,
                time: $filter('date')(time, 'yyyy-MM-dd')
            }
        }).success(function() {

            callback();
        }).error(function(data, status) {

            if(status === 409) {

                alert("该教练时间冲突，请重新操作");
            } else if(status === 417) {

                alert('该顾客已存在私教，请重新操作');
            }
        });
    };

    this.deleteSchedule = function(id, callback) {

        $http.delete('api/schedules/' + id).success(function() {
            callback();
        });
    };

    this.modifySchedule = function(scheduleToBeModified, callback) {

        $http.put('api/schedules/' + scheduleToBeModified.id, {

            id: scheduleToBeModified.id,
            employee: {name: scheduleToBeModified.employee.name},
            course: {name: scheduleToBeModified.course.name},
            time: $filter('date')(scheduleToBeModified.time, 'yyyy-MM-dd')
        }).success(function() {

            callback();
        }).error(function() {

            alert("该教练时间冲突，请重新操作！");
        });
    };
});


