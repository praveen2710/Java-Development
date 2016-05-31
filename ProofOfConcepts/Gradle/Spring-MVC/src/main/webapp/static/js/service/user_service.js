'use strict';

//App is name of module defined in app.js
App.factory('UserService', ['$http', '$q', function($http, $q){
	
	return{
		createUser: function(subuser){
			console.log("in create user class here")
			console.log(subuser.name)
			return $http.post('http://localhost:8080/Spring-MVC/uform/',subuser)
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
									return $q.reject(errResponse)
								}	
								
						);
		}
	};//end of return
}]);
