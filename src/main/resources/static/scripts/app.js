define(
    [
        'angular',
        'angular-route',//在main.js里面进行了exports
        'controller/index',
        'angular-sanitize'
        // '../vendors/angular/angular-sanitize.min.js'
    ], function (angular) {
        var app = angular.module("app",['ngRoute','controllers','ngSanitize']);
        return app;
    }
)
