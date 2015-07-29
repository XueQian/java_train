'use strict';

var module = angular.module('gymSystem').controller('courseController', function($scope, CourserService) {

    function getCourses() {

        CourserService.getCourses(function(data) {

            $scope.courses = data;
        });
    }

    getCourses();

    $scope.addCourse = function() {

        CourserService.addCourse($scope.course, function() {
            getCourses();
        });
    }
});

module.factory('CourserService', function($http) {

    return {
        getCourses: function(callback) {

            $http.get('api/courses').
                success(function(data) {

                    callback(data);
                });
        },
        addCourse: function(course, callback) {

            this.getCourses(function(data) {

                if(hasExistCourse(course, data)) {

                    alert("该课程已存在，请重新操作！");
                } else {

                    $http({
                        method: 'POST',
                        url: 'api/courses/creation',
                        params: {
                            name: course.name,
                            description: course.description
                        }
                    }).success(function() {

                        callback();
                    })
                }
            });
        }
    };

    function hasExistCourse(course, courseList) {

        return _.any(courseList, function(aCourse) {
            return course.name === aCourse.name;
        });
    }
});

