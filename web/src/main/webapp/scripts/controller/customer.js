'use strict';

angular.module('gymSystem').controller('customerController', function($scope, CustomerService) {

    getCustomers();

    function getCustomers() {

        CustomerService.getCustomers(function(data) {

            $scope.customers = data;
        });
    }
});
