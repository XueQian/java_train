'use strict';

angular.module('gymSystem').controller('userController', function($scope, UserService) {

    getUsers();

    function getUsers() {

        UserService.getUsers(function(data){

            $scope.users = data;
        });
    }
});
