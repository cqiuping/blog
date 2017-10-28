define(["controller/controllers"], function (controllers) {
    controllers.controller('mainController', ['$scope', '$http',
        function ($scope, $http) {
            $http.get("backend/loginUser").then(function (data) {
                    console.log(data);
                    if(data.data.status == 0){
                        $scope.loginUser = data.data.data;
                        console.log($scope.loginUser);
                    }
            });

            // //这是要放到blogController.js里面的，这里做测试
            // $scope.id = 6;
            // $http.get("backend/blog/getBlog/" + $scope.id).then(function (data) {
            //     console.log(data);
            // })

        }]
    )
});