'use strict';

//scope here is a dependency
App.controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
	//declare variables to store data
	var self = this;
	self.subuser={searchString:''};
	self.subusers = [];
	self.errorResp = '';
	self.retryCount = 0;
	self.maxCount = 10;
	
   self.searchProduct = function(productName){
		UserService.searchProduct(productName).then(
			function(resp){
				self.retryCount = 0;
				
				self.searchResult = resp.items
				if(self.searchResult[0].itemId!=null){
					self.getRecommendations(self.searchResult[0].itemId)
				}
				self.errorResp = ""
			},function(errResponse){
//				Logic to enable retries before giving up
				self.retryCount = self.retryCount + 1
				if(self.retryCount < self.maxCount){
					self.searchProduct(self.searchString)
				}else{
					self.dispError(errResponse)
				}
			})
		         
	}
		
	self.getRecommendations= function(productId){
		UserService.getRecommendations(productId).then(
			function (recProd){
				self.errorResp = ""
				self.retryCount = 0
					
				self.recommededResults = recProd
			},
			function(errResponse){
//				Logic to enable retries before giving up
				self.retryCount = self.retryCount + 1
				console.error("retried "+ self.retryCount)
				if(self.retryCount < self.maxCount){
					self.getRecommendations(self.searchResult[0].itemId)
				}else{
					self.dispError(errResponse)
				}
			})
	}
		
   self.submit = function() {
//	   angular ensure no null string will be passed but defensive programming
       if(self.searchString !=null){
           self.searchResult = ""
           self.recommededResults = ""   
           self.searchProduct(self.searchString)
       }
   };
   
	self.dispError = function(errResponse){
		if(errResponse.status == 403){
			self.errorResp = "Access was forbidden please contact admin"
		}else if(errResponse.status == 400){
			self.errorResp = "Bad request occured please contact admin"
		}else{
			self.errorResp = "Something unexpected occured contact admin"
		}
	}
}])

