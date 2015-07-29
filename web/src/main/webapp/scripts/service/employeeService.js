'use strict';

angular.module('gymSystem').service('EmployeeService', function($http) {

    this.getEmployees = function(callback) {

        $http.get('api/employees').
            success(function(data) {

                callback(data);
            });
    };
});
