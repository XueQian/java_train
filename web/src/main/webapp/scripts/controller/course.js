'use strict';

var module = angular.module('gymSystem').controller('courseController', function($scope, CourserService) {

    CourserService.getCourses(function(data) {

        $scope.courses = data;
    });
});

module.factory('CourserService', function($http) {

    return {
        getCourses: function(callback) {

            $http.get('api/courses').
                success(function(data) {

                    callback(data);
                });
        }
    }
});