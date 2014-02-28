/**
 * Creates a shoppingCart class.
 * localStorageService
 */
function ShoppingCart(localStorageService) {
	this.items = [];
	this.localStorageService = localStorageService;

	this.loadItems();
}

/**
 * 
 */
ShoppingCart.prototype.loadItems = function() {
	var products = this.localStorageService.get("products");
	if (products != null) {
		this.items = products;
	}
}
/**
 * Returns the total amount of all items in the cart
 */
ShoppingCart.prototype.getTotalAmount = function() {
	var total = 0;
	angular.forEach(this.items, function(value, key) {
		console.log(key);
		console.log(value);
		total += value.price;
	});

	return total;
};
/**
 * Returns the total lenght of the shopping cart
 */
ShoppingCart.prototype.getLength = function() {
	return this.items.length;
}
/**
 * Add an item to the cart item list
 */
ShoppingCart.prototype.addItem = function(product) {
	// var products = localStorageService.get("products");
	// if (products == null) {
	// var newProductsArray = new Array();
	// newProductsArray.push(product);
	//
	// localStorageService.add("products", newProductsArray);
	// } else {
	// products.push(product);
	// localStorageService.add('products', products);
	// }
	this.items.push(product);
	this.saveItems();
}
/**
 * Save th products in localstorage
 */
ShoppingCart.prototype.saveItems = function() {
	this.localStorageService.add('products', this.items);
}
/**
 * Clear the localstorage
 */
ShoppingCart.prototype.clearAll = function() {
	this.localStorageService.clearAll();
	this.items = [];
}