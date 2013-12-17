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
//        	alert("update");
            $scope.currentGenre = Genre.update($scope.currentGenre);
            
        }
        $scope.cancel();
    };

    $scope.edit = function (genre) {
    	$scope.currentGenre = genre;
//    	alert($scope.currentGenre.id);
    };

    $scope.remove = function (index, id) {
		$scope.genres.splice(index, 1);
		Genre.remove({genreId:id});
    };
}]);


controllers.controller('AlbumController', ['$scope', 'Album', function($scope, Album) {
    $scope.currentAlbum = new Album();
    $scope.albums = Album.query();
    $scope.showId = false;

    $scope.cancel = function () {
        $scope.currentAlbum = new Album();
    };

    $scope.save = function () {
        var isNew = $scope.currentAlbum.id == null;
        if (isNew) {
            $scope.currentAlbum = Album.save($scope.currentAlbum);
            $scope.albums.push($scope.currentAlbum);
        } else {
//        	alert("update");
            $scope.currentAlbum = Album.update($scope.currentAlbum);
            
        }
        $scope.cancel();
    };

    $scope.edit = function (album) {
    	$scope.currentAlbum = album;
//    	alert($scope.currentAlbum.id);
    };

    $scope.remove = function (index, id) {
		$scope.albums.splice(index, 1);
		Album.remove({albumId:id});
    };
}]);



controllers.controller('TitleController', ['$scope', 'Title', function($scope, Title) {
    $scope.currentTitle = new Title();
    $scope.titles = Title.query();
    $scope.showId = false;

    $scope.cancel = function () {
        $scope.currentTitle = new Title();
    };

    $scope.save = function () {
        var isNew = $scope.currentTitle.id == null;
        if (isNew) {
            $scope.currentTitle = Title.save($scope.currentTitle);
            $scope.titles.push($scope.currentTitle);
        } else {
//        	alert("update");
            $scope.currentTitle = Title.update($scope.currentTitle);
            
        }
        $scope.cancel();
    };

    $scope.edit = function (title) {
    	$scope.currentTitle = title;
//    	alert($scope.currentTitle.id);
    };

    $scope.remove = function (index, id) {
		$scope.titles.splice(index, 1);
		Title.remove({titleId:id});
    };
}]);


controllers.controller('ArtistController', ['$scope', 'Artist', function($scope, Artist) {
    $scope.currentArtist = new Artist();
    $scope.currentArtist.birthday = new Date();
    $scope.artists = Artist.query();
    $scope.showId = false;

    $scope.pattern=/^[0-9]{2}\/[0-9]{2}\/[0-9]{4}$/i;
    $scope.errorMsg='';
    
    $scope.validation=function(aForm){
        console.log(aForm);
        if(aForm.birthday.$error.pattern)
            $scope.errorMsg='The pattern you entered isn\'t good enough, try again !';
            else{
                if(aForm.$invalid)
                     $scope.errorMsg='Something is invalid, please check all the fields !';
                else//valid
                {
                    $scope.errorMsg='Not bad !';
                    //alert("good job !")
                     
                }
            }
    };
    
    $scope.whatToDisplay=function(aForm){
        if(aForm.$valid)
            return 'valid';
        if(aForm.birthday.$error.pattern)
            return 'date';
        if (aForm.$invalid)
           return 'notdate';
    };
 
    
    
    
    $scope.cancel = function () {
        $scope.currentArtist = new Artist();
        $scope.currentArtist.birthday = new Date();
    };

    $scope.save = function () {
//alert(Date.parse($scope.currentArtist.birthday));
//alert($scope.currentArtist.birthday);
        var isNew = $scope.currentArtist.id == null;
        if (isNew) {
            $scope.currentArtist = Artist.save($scope.currentArtist);
            $scope.artists.push($scope.currentArtist);
        } else {
//        	alert("update: "+$scope.currentArtist.birthday);
            $scope.currentArtist = Artist.update($scope.currentArtist);
            
        }
        $scope.cancel();
    };

    $scope.edit = function (artist) {
    	$scope.currentArtist = artist;
//    	alert($scope.currentArtist.id);
    };

    $scope.remove = function (index, id) {
		$scope.artists.splice(index, 1);
		Artist.remove({artistId:id});
    };
}]);
