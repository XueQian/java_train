'use strict';

angular.module('gymSystem').service('CourseService', function($http) {

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
                });

                //$http.post('api/courses/creation',{name:course.name,description:course.description})
                //    .success(
                //        function(){
                //        callback();
                //    })
            }
        });
    };

    this.deleteCourse = function(id, callback) {

        $http.delete('api/courses/deletion/' + id).success(function() {
            callback();
        });
    };

    this.getCourse = function(id, callback) {

        $http.get('api/courses/' + id).success(function(data) {
            callback(data);
        })
    };

    this.modifyCourse = function(courseToBeModified, callback) {
        var self = this;
        this.getCourses(function(data) {

            self.getCourse(courseToBeModified.id, function(courseData) {

                if(hasExistCourse(courseToBeModified, data) && !isSameCourse(courseToBeModified, courseData)) {

                    alert("该课程已存在，请重新操作")
                } else {

                    $http({
                        method: 'PUT',
                        url: 'api/courses/' + courseToBeModified.id,
                        params: {
                            id: courseToBeModified.id,
                            name: courseToBeModified.name,
                            description: courseToBeModified.description
                        }
                    }).success(function() {

                        callback();
                    })
                }
            });
        });
    };

    function hasExistCourse(course, courseList) {

        return _.any(courseList, function(aCourse) {
            return course.name === aCourse.name;
        });
    }

    function isSameCourse(courseToBeModified, course) {

        var flag = false;

        if(course.name === courseToBeModified.name) {

            flag = true;
        }
        return flag;
    }
});





