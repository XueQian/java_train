'use strict';

angular.module('gymSystem').service('CustomerService', function($http) {

    this.getCustomers = function(callback) {

        $http.get('api/customers').
            success(function(data) {

                callback(data);
            });
    };
});
