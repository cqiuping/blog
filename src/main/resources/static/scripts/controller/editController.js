var editApp = angular.module('editApp',['ngRoute']);

editApp.controller('editController',function ($scope,$http) {
    $scope.save = function () {
        let content = document.getElementsByClassName("editormd-preview-container")[0].innerHTML;
        console.log(content);

        $http.post('backend/blog/saveBlog',content).then(function (data) {
            console.log(data);
        })
    }


});