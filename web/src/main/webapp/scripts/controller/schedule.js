'use strict';

angular.module('gymSystem').controller('scheduleController', function($scope, ScheduleService, CourseService, EmployeeService, CustomerService, $filter) {

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

    $scope.getModifySchedule = function(id) {

        $scope.modifyFlag = false;

        $scope.scheduleToBeModified = getSchedule(id);
        $scope.scheduleToBeModified = {
            id: getSchedule(id).id,
            course: {name: getSchedule(id).course.name},
            employee: {name: getSchedule(id).employee.name},
            time: new Date($filter('date')(getSchedule(id).time, 'MM/dd/yyyy'))
        };
    };

    $scope.modifySchedule = function(schedule) {

        ScheduleService.modifySchedule(schedule, function() {

            getSchedules();
        })
    };

    function getSchedules() {

        $scope.addFlag = true;
        $scope.addPrivateFlag = true;
        $scope.modifyFlag = true;

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

    function getSchedule(id) {

        return _.find($scope.schedules, function(schedule) {
            return schedule.id === id;
        });
    }
});