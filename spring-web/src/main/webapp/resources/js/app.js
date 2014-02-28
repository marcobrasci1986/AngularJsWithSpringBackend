'use strict';

// Declare app level module which depends on filters, and services

/**
 * 
 * LocalStorageService: https://github.com/grevory/angular-local-storage
 * Add the module, that "localStorageService" is available for injection in any controller
 * 
 * 
 */
var myApp = angular.module('myApp', [ 'ngRoute', 'ngAnimate', 'ui.bootstrap',
		'myApp.filters', 'myApp.services', 'myApp.directives',
		'myApp.controllers', 'LocalStorageModule' ]);

/**
 * The routprovider controllers the url's
 */
myApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/products', {
		templateUrl : 'products/add', //--> from "app" folder. User add.html in "app/products" folder
		controller : 'productController' //--> add a controller to this page
	});
	$routeProvider.when('/view2', {
		templateUrl : 'partials/partial2',
		controller : 'MyCtrl2'
	});
	$routeProvider.otherwise({
		redirectTo : '/products'
	});
} ]);






