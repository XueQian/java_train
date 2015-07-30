'use strict';

angular.module('gymSystem').controller('scheduleController', function($scope, ScheduleService, CourseService, EmployeeService, CustomerService) {

    getSchedules();

    $scope.showAddSchedule = function() {

        $scope.addFlag = false;

        loadData();

        $scope.employee = null;
        $scope.course = null;
        $scope.time = null;
    };

    $scope.addSchedule = function(employeeId, courseId, time) {

        ScheduleService.addSchedule(employeeId, courseId, time, function() {

            getSchedules();
        });
    };

    $scope.hideAddSchedule = function() {

        $scope.addFlag = true;
    };

    $scope.showAddPrivateCoach = function() {

        $scope.addPrivateFlag = false;

        loadData();
    };

    $scope.hideAddPrivateCoach = function() {

        $scope.addPrivateFlag = true;
    };

    $scope.addPrivateCoach = function(customerId, employeeId, time) {

        ScheduleService.addPrivateCoach(customerId, employeeId, time, function() {

            getSchedules();
        });
    };

    $scope.deleteSchedule = function(id) {

        ScheduleService.deleteSchedule(id, function() {

            getSchedules();
        })
    };

    function getSchedules() {

        $scope.addFlag = true;
        $scope.addPrivateFlag = true;

        ScheduleService.getSchedules(function(data) {

            $scope.schedules = data;
        });
    }

    function loadData() {

        CourseService.getCourses(function(data) {

            $scope.courses = data;
        });

        EmployeeService.getEmployees(function(data) {

            $scope.employees = data;
        });

        CustomerService.getCustomers(function(data) {

            $scope.customers = data;
        })
    }
});