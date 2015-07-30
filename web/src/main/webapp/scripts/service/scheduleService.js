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
            url: 'api/schedules',
            data: {
                employee: {id: employeeId},
                course: {id: courseId},
                time: time.toISOString().substring(0, 10)
            }
        }).success(function() {

            callback();
        }).error(function() {

            alert("该教练时间冲突，请重新操作！");
        });
    };
});


