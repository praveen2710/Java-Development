<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>AngularJS $http Example</title>  
   	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
   </head>
    <body ng-app="myApp">
    
    	<div class="generic-container" ng-controller="UserController as ctrl">
  		
  		<input type="text" ng-model="ctrl.user.username" id="uname" class="username form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
	    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	    <script src="<c:url value='/static/js/app.js' />"></script>
	    <script src="<c:url value='/static/js/service/user_service.js' />"></script>
        <script src="<c:url value='/static/js/controller/user_controller.js' />"></script>
    </body>
</html>