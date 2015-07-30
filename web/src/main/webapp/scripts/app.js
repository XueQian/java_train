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
            .otherwise({
                redirectTo: '/1111111'
            });
    });