define([
    "app"
],function (app) {
    app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider
        .when('/',{templateUrl:'/views/backend/index.html',controller:'mainController'})
        /**
         * 编辑博客
         */
            .when('/editBlog',{controller:'editController'})
        .when('/allBlog',{templateUrl:'/views/backend/index.html',controller:'blogController'})
    }]);
})
