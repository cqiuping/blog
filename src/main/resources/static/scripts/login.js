var loginApp = angular.module('loginApp', []);


loginApp.controller('loginCtrl', function ($scope, $http,$location) {
    $scope.user = {};
    $scope.doLogin = function () {
        console.log($scope.user.username);
        $http.post("/login", $scope.user).then(function (data) {
            console.log(data);
            if(data.data.status == 0){
                location.href="./";
            }else{
                location.href="login"
                alert(data.data.errorMsg);
            }
        })
    }
})


