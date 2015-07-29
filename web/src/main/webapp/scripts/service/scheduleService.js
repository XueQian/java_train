'use strict';

angular.module('gymSystem').service('ScheduleService', function($http) {

    this.getSchedules = function(callback) {

        $http.get('api/schedules').
            success(function(data) {

                callback(data);
            });
    };
});
