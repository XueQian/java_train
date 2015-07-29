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
            .otherwise({
                redirectTo: '/1111111'
            });

    });