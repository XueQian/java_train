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
            .otherwise({
                redirectTo: '/1111111'
            });

    });