'use strict';

angular.module('gymSystem').controller('employeeController', function($scope, EmployeeService) {

    getEmployees();

    function getEmployees() {

        EmployeeService.getEmployees(function(data){

            $scope.employees = data;
        })
    }
});
