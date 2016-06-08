'use strict';

//scope here is a dependency
App.controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
	//declare variables to store data
	var self = this;
	self.subuser={searchString:''};
	self.subusers = [];
	self.inputError = '';
	
	self.test = "mama"
		
	console.log("controler called in")
	
   self.searchProduct = function(productName){
		UserService.searchProduct(productName).then(function(resp){
			console.log("came in controller")
			self.searchResult = resp.items
			console.log(self.searchResult)
			console.log(self.searchResult[0].itemId)
			if(self.searchResult[0].itemId!=null){
				self.getRecommendations(self.searchResult[0].itemId)
			}
		})
		         
	}
	
	self.getRecommendations= function(productId){
		console.log("call service to get recommendations")
		console.log(productId)
		UserService.getRecommendations(productId).then(function (recProd){
			console.log("came in recomendation controller")
			self.recommededResults = recProd
			console.log(self.recommededResults)
		})
	}
		
   self.submit = function() {
       if(self.searchString !=null){
           console.log('Searching for product ', self.searchString); 
           self.inputError = ""
           self.searchProduct(self.searchString)
       }else{
           console.log('Search String was empty')
           self.inputError = "Search String was empty"
       }
   };
}])

