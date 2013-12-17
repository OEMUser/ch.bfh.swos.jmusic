'use strict';

var services = angular.module('services', ['ngResource']);

services.factory('Genre', ['$resource', function ($resource) {
    return $resource('rest/genre/:genreId', {genreId:'@id'}, {
        'update': {method: 'PUT'}
    });
}]);

services.factory('Artist', ['$resource', function ($resource) {
    return $resource('rest/artist/:artistId', {artistId:'@id'}, {
        'update': {method: 'PUT'}
    });
}]);

services.factory('Album', ['$resource', function ($resource) {
    return $resource('rest/album/:albumId', {albumId:'@id'}, {
        'update': {method: 'PUT'}
    });
}]);

services.factory('Title', ['$resource', function ($resource) {
    return $resource('rest/title/:titleId', {titleId:'@id'}, {
        'update': {method: 'PUT'}
    });
}]);