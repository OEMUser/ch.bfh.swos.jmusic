'use strict';

var services = angular.module('services', ['ngResource']);

services.factory('Genre', ['$resource', function ($resource) {
    return $resource('rest/genre/:genreId', {genreId:'@id'}, {
        'update': {method: 'PUT'}
    });
}]);