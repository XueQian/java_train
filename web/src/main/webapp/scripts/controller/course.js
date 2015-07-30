'use strict';

angular.module('gymSystem').controller('courseController', function($scope, CourseService) {

    getCourses();

    $scope.addCourse = function() {

        $scope.addFlag = false;

        CourseService.addCourse($scope.course, function() {
            getCourses();
        });
    };

    $scope.deleteCourse = function(id) {

        CourseService.deleteCourse(id, function() {
            getCourses();
        });
    };

    $scope.showAddCourse = function() {

        $scope.addFlag = false;
        $scope.course.name = null;
        $scope.course.description = null;
    };

    $scope.hideAddCourse = function() {

        $scope.addFlag = true;
    };

    $scope.hideModifyCourse = function() {

        $scope.modifyFlag = true;
    };

    $scope.getModifyCourse = function(id) {

        $scope.modifyFlag = false;

        CourseService.getCourse(id, function(data) {
            $scope.courseToBeModified = data;
        });
    };

    $scope.modifyCourse = function(courseToBeModified) {

        CourseService.modifyCourse(courseToBeModified, function() {

            getCourses();
        })
    };

    function getCourses() {

        $scope.addFlag = true;
        $scope.modifyFlag = true;

        CourseService.getCourses(function(data) {

            $scope.courses = data;
        });
    }
});





