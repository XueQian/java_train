'use strict';

angular.module('gymSystem').service('UserService', function($http) {

    this.getUsers = function(callback) {

        $http.get('api/users').
            success(function(data) {

                callback(data);
            });
    };
});
