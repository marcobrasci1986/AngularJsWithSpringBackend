'use strict';

/* Services */

// Demonstrate how to register services
// In this case it is a simple value service.
var services = angular.module('myApp.services', []);

services.value('version', '0.1');

/**
 * Can be injected in a controller.
 * Usage:
 * $scope.allInfos = Informer.allInfos;
 * 
 */
services.factory('Informer', function() {

	var messages = [];
	var Informer = {};

	Informer.inform = function(msg, type) {
		messages.push({
			msg : msg,
			type : "alert alert-" + type
		});
	};

	/**
	 * Returns all the messages that are available
	 */
	Informer.allInfos = function() {
		return messages;
	};

	/**
	 * Remove a certain message from the message list
	 */
	Informer.remove = function(info) {
		messages.splice(messages.indexOf(info), 1);
	};

	return Informer;
});

/**
 * Can be injected in a controller.
 * Usage:
 * $scope.cart = DataService.cart;
 * 
 */
services.factory('DataService', function(localStorageService) {
	var cart = new ShoppingCart(localStorageService);
	
	return {
        cart: cart
    };
});
