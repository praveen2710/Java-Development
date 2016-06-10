'use strict';

//App is name of module defined in app.js
App.factory('UserService', ['$http', '$q', function($http, $q){
	
	return{
		searchProduct: function(searchString){
			
			return $http.get('http://localhost:8080/searchMart/index/search?productName='+searchString)
						//the .then has two parts in it valid,error response
						.then(
								//the response has status,data,headers,config,statusText 
								function(response){
									console.log("retrieved search result succesfully")
									return response.data
								},
								function(errResponse){
									console.error("Error wile retrieving product")
									return $q.reject(errResponse)
								}	
								
						);
		},
		getRecommendations : function(productId){
			
			return $http.get('http://localhost:8080/searchMart/index/recommendation?productId='+productId)
			//the .then has two parts in it valid,error response
			.then(
					//the response has status,data,headers,config,statusText 
					function(response){
						console.log("retrieved recommendations succesfully")
						return response.data
					},
					function(errResponse){
						console.error("Error wile retrieving recommendation")
						return $q.reject(errResponse)
					}	
					
			);			
		}
	
	};//end of return
}]);
