'use strict';

//scope here is a dependency
App.controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
	//declare variables to store data
	var self = this;
	self.subuser={id:null,name:'',phone:'',email:''};
	self.subusers = [];
	
	self.createUser = function(subuser){
		UserService.createUser(subuser)
						.then(
							self.fetchAllUsers,
							function(errResponse){
								console.error("Error while creating User.");
							}
			)
	}
	
   self.submit = function() {
       if(self.subuser.id===null){
           console.log('Saving New User yo msd', self.subuser);    
           self.createUser(self.subuser);
       }else{
           self.updateUser(self.subuser, self.subuser.id);
           console.log('User updated with id ', self.subuser.id);
       }
   };
}]);