'use strict';

myApp.controller("productController", function($scope, $modal, $http, $log,
		Informer, DataService) {
	this.filterName = "";

	$scope.allInfos = Informer.allInfos;
	$scope.remove = Informer.remove;

	$scope.cart = DataService.cart;

	/**
	 * Find all products from the backend
	 */
	$scope.findAllProducts = function() {
		$http.get('/spring-web/products/products.json').success(
				function(products) {
					$scope.products = products;
				});
	}

	/**
	 * Remove a product from the list
	 */
	$scope.removeProduct = function(product) {
		var modalInstance = $modal.open({
			templateUrl : '/spring-web/products/model/deletePopup',
			controller : modalInstanceController,
			resolve : {
				product : function() {
					return product;
				}
			}
		});

		modalInstance.result.then(function(data) {
			if (data.status == 'OK') {
				Informer.inform(data.message, "info");
				$scope.findAllProducts();
			} else {
				$scope.setErrorMessage(data.message);
			}
		}, function(data) {
			$log.info("popup dismissed")
		});
	};

	$scope.findAllProducts();

});

var modalInstanceController = function($scope, $modalInstance, $http, product) {

	$scope.ok = function(data) {
		$http.post('/spring-web/products/delete', product).success(
				function(data) {
					$modalInstance.close(data);
				}).error(function(data) {
			$modalInstance.close(data);
		})

	};

	$scope.cancel = function() {
		$modalInstance.dismiss('cancel');
	};
};