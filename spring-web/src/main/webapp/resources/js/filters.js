'use strict';

/* Filters */

var filters = angular.module('myApp.filters', []);


filters.filter('interpolate', ['version', function(version) {
    return function(text) {
      return String(text).replace(/\%VERSION\%/mg, version);
    }
}]);

/**
 * Append a € sign to the input 
 * USage: <tr ng-repeat="product in products | filter:filterName">
 */
filters.filter('currency', function(){
	return function(input){
		return input + " €";
	}
	
});
