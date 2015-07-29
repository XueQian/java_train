'use strict';

angular.module('gymSystem').controller('scheduleController', function($scope, ScheduleService,CourseService,EmployeeService) {

    getSchedules();

    $scope.showAddSchedule = function() {

        $scope.addFlag = false;

        CourseService.getCourses(function(data) {

            $scope.courses = data;
        });

        EmployeeService.getEmployees(function(data){

            $scope.employees = data;
        })
    };

    $scope.addSchedule = function(){

       ScheduleService.addSchedule($scope.employeeId,$scope.courseId,$scope.time,function(){

           getSchedules();
       });
    };

    $scope.hideAddSchedule = function() {

        $scope.addFlag = true;
    };

    function getSchedules() {

        $scope.addFlag = true;

        ScheduleService.getSchedules(function(data) {

            $scope.schedules = data;
        });
    }
});