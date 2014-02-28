describe("test product controller", function(){
	var appCtrl;
	beforeEach(module("myApp"));
	
	beforeEach(inject(function ($controller){
		appCtrl = $controller("AppCtrl");
	}))
	
	describe("AppCtrl", function(){
		it("should have a message of hello", function(){
			expect(appCtrl.message).toBe("Hello"); 
		})
		
	})
	
})