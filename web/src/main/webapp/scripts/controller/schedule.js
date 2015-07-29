'use strict';

angular.module('gymSystem').controller('scheduleController', function($scope, ScheduleService) {

    getSchedules();

    function getSchedules() {

        ScheduleService.getSchedules(function(data) {

            $scope.schedules = data;
        });
    }
});