'use strict';

var controllers = angular.module('controllers', ['services']);

controllers.controller('GenreController', ['$scope', 'Genre', function($scope, Genre) {
    $scope.currentGenre = new Genre();
    $scope.genres = Genre.query();
    $scope.showId = false;

    $scope.cancel = function () {
        $scope.currentGenre = new Genre();
    };

    $scope.save = function () {
        var isNew = $scope.currentGenre.id == null;
        if (isNew) {
            $scope.currentGenre = Genre.save($scope.currentGenre);
            $scope.genres.push($scope.currentGenre);
        } else {
        	alert("update");
            $scope.currentGenre = Genre.update($scope.currentGenre);
            
        }
        $scope.cancel();
    };

    $scope.edit = function (genre) {
    	$scope.currentGenre = genre;
    	alert($scope.currentGenre.id);
    };

    $scope.remove = function (index, id) {
		$scope.genres.splice(index, 1);
		Genre.remove({genreId:id});
    };
}]);