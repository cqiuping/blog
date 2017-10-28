require.config({
    paths:{
        "angular": "/static/vendors/angular/angular",
        "jQuery": "/static/vendors/jQuery/jquery-2.2.3.min",
        "bootstrap": "/static/vendors/bootstrap/js/bootstrap.min",
        "angular-route": "/static/vendors/angular-route/angular-route",
        "angular-sanitize":"/static/vendors/angular/angular-sanitize.min"
    },
    shim:{
        'angular':{
            exports: 'angular'
        },
        'angular-route':{
            deps:['angular']
        },
        'angular-sanitize':{
            deps:['angular']
        }
    }
});
require(["angular-sanitize","route"],
    function () {
        angular.bootstrap(document, ["app"]);
    });
