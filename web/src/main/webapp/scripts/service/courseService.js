'use strict';

angular.module('gymSystem').service('CourserService', function($http) {

    this.getCourses = function(callback) {

        $http.get('api/courses').
            success(function(data) {

                callback(data);
            });
    };

    this.addCourse = function(course, callback) {

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
    };

    this.deleteCourse = function(id, callback) {

        $http.delete('api/courses/deletion/' + id).success(function() {
            callback();
        });
    };

    //this.getCourse = function(id, callback) {
    //
    //    $http.get('api/course/' + id).success(function(data) {
    //        callback(data);
    //    })
    //};

    function hasExistCourse(course, courseList) {

        return _.any(courseList, function(aCourse) {
            return course.name === aCourse.name;
        });
    }

});



