'use strict';

angular.module('gymSystem').service('ScheduleService', function($http) {

    this.getSchedules = function(callback) {

        $http.get('api/schedules').
            success(function(data) {

                callback(data);
            });
    };

    this.addSchedule = function(employeeId, courseId, time, callback) {

        $http({
            method: 'POST',
            url: 'api/schedules/creation',
            params: {
                employeeId: employeeId,
                courseId: courseId,
                time: time.toISOString().substring(0, 10)
            }
        }).success(function() {

            callback();
        });

        //$http.post('api/schedules', {
        //    employeeId: employeeId,
        //    courseId: courseId,
        //    time: time
        //}).success(function(data) {
        //
        //    callback();
        //});

        //isCoachFree(employeeId, time, function(flag) {
        //
        //    if(!flag) {
        //
        //        alert("该教练时间冲突，请重新操作！");
        //    } else {
        //
        //        $http({
        //            method: 'POST',
        //            url: 'api/schedules',
        //            params: {
        //                employeeId: employeeId,
        //                courseId: courseId,
        //                time: time
        //            }
        //        }).success(function() {
        //
        //            callback();
        //        })
        //    }
        //})
    };

    var self = this;

    function getSchedulesByTime(time, callback) {

        self.getSchedules(function(schedules) {

            callback(_.filter(schedules, function(schedule) {

                return schedule.time === time;
            }));
        })
    }

    function getEmployeeList(time, callback) {

        getSchedulesByTime(time, function(schedulesData) {
            var employeeList;

            _(schedulesData).forEach(function(schedule) {

                employeeList.add(schedulesData.indexOf(schedule), schedule.employees.id);

                if(schedulesData.indexOf(schedule) === schedulesData.length - 1) {
                    callback(employeeList);
                }
            }).value();
        });
    }

    function isCoachFree(employeeId, time, callback) {

        var flag = true;

        getEmployeeList(time, function(employeeList) {

            if(employeeList.contains(employeeId)) {
                flag = false;
            }

            callback(flag);
        });
    }
});


