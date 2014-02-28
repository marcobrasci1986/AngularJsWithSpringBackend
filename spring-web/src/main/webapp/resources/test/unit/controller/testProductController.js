describe("test product controller", function(){
		beforeEach(module("myApp"));
		
		beforeEach(inject(function (_$httpBackend_, $rootScope, $controller, $log){
			$httpBackend = _$httpBackend_;
			$httpBackend.expectGET('/spring-web/products/products.json').respond([{name: 'Lakland'}, {name: 'Gibson'}]);
			scope = $rootScope.$new();
			
			var appCtrl = $controller('productController', {$scope: scope});
		}));
		
		it("should create 'products' model with 2 products fetched from xhr", function(){
			expect(scope.products).toBeUndefined();
			$httpBackend.flush();
			expect(scope.products).toEqual([{name: 'Lakland'}, {name: 'Gibson'}]);
		})
		
		
	});


