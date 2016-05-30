<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>AngularJS Example</title>  
   	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
   </head>
    <body ng-app="myApp">
    
    	<div class="generic-container" ng-controller="UserController as ctrl">
  		<form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	  		<input type="hidden" ng-model="ctrl.subuser.id" />
	  		<input type="text" ng-model="ctrl.subuser.name" id="uname" class="username form-control input-sm" placeholder="Enter your name" required/>
		    <input type="text" ng-model="ctrl.subuser.phone" id="phone" class="form-control input-sm" placeholder="Enter your phone mama."/>
		    <input type="text" ng-model="ctrl.subuser.email" id="email" class="email form-control input-sm" placeholder="Enter your Email" required/>
			<input type="submit"  value="{{!ctrl.user.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm">
		</form>                              
                              
	    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	    <script src="<c:url value='/static/js/app.js' />"></script>
	    <script src="<c:url value='/static/js/service/user_service.js' />"></script>
        <script src="<c:url value='/static/js/controller/user_controller.js' />"></script>
    </body>
</html>