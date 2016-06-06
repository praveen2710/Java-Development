'use strict';

//App is name of module defined in app.js
App.factory('UserService', ['$http', '$q', function($http, $q){
	
	return{
		searchProduct: function(searchString){
			console.log("in search product function")
			console.log(searchString)
			
			return $http.get('http://localhost:8080/searchMart/index/search?productName='+searchString)
						//the .then has two parts in it valid,error response
						.then(
								//the response has status,data,headers,config,statusText 
								function(response){
									console.log("came in sucess")
									console.log(response)
									return response.data
								},
								function(errResponse){
									console.error("Error wile creating user")
									console.log(errResponse)
									return $q.reject(errResponse)
								}	
								
						);
		},
		getRecommendations : function(productId){
			console.log("came in recommendations to make call")
			
			return $http.get('http://localhost:8080/searchMart/index/recommendation?productId='+productId)
			//the .then has two parts in it valid,error response
			.then(
					//the response has status,data,headers,config,statusText 
					function(response){
						console.log("came in sucess for recommendation")
						console.log(response.data)	
						return response.data
					},
					function(errResponse){
						console.error("Error wile creating user")
						console.log(errResponse)
						return $q.reject(errResponse)
					}	
					
			);			
		}
	
	};//end of return
}]);
