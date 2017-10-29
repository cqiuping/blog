define(["controller/controllers"], function (controllers) {
    controllers.controller('blogController', ['$scope', '$http',
        function ($scope, $http,) {
            // $http.get("backend/blog/getAllBlog").then(function (data) {
            //
            // });
            $scope.id = 578;
            $http.get("backend/blog/getBlog/" + $scope.id).then(function (data) {
                console.log(data);
                if(data.data.status == 0){
                    console.log(data.data.data);
                    $scope.myBlog = data.data.data.content;
                }
            })

        }]
    )
});