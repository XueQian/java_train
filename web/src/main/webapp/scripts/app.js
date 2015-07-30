'use strict';

angular
    .module('gymSystem', [
        'ngRoute'
    ])
    .config(function($routeProvider) {

        $routeProvider
            .when('/courses', {
                templateUrl: 'views/course.html',
                controller: 'courseController'
            })
            .when('/schedules', {
                templateUrl: 'views/schedule.html',
                controller: 'scheduleController'
            })
            .when('/customers', {
                templateUrl: 'views/customer.html',
                controller: 'customerController'
            })
            .when('/users', {
                templateUrl: 'views/user.html',
                controller: 'userController'
            })
            .when('/employees', {
                templateUrl: 'views/employee.html',
                controller: 'employeeController'
            })
            .otherwise({
                redirectTo: '/1111111'
            });
    });