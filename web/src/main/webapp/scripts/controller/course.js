'use strict';

angular.module('gymSystem').controller('courseController', function($scope, CourserService) {

    getCourses();

    $scope.addCourse = function() {

        $scope.addFlag = false;

        CourserService.addCourse($scope.course, function() {
            getCourses();
        });
    };

    $scope.deleteCourse = function(id) {

        CourserService.deleteCourse(id, function() {
            getCourses();
        });
    };

    $scope.showAddCourse = function() {

        $scope.addFlag = false;
    };

    $scope.hideAddCourse = function() {

        $scope.addFlag = true;
    };

    //function modifyCourse() {
    //
    //    //CategoryService.getCategory($routeParams.id, function (data) {
    //    //    $scope.category = data;
    //    //});
    //    //
    //    //$scope.modifyCategory = function (category) {
    //    //    CategoryService.modifyCategory(category, function (data) {
    //    //        $scope.categories = data;
    //    //    });
    //    //};
    //    //
    //}
    //
    //$scope.modifyCourse = function(modifyCourse) {
    //
    //};

    function getCourses() {

        $scope.addFlag = true;

        CourserService.getCourses(function(data) {

            $scope.courses = data;
        });
    }
});





