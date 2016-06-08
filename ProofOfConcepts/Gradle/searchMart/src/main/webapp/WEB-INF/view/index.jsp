<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>Product Finder</title>  
   </head>
    <body ng-app="myProductFinder">
    
    	<div class="generic-container" ng-controller="UserController as ctrl">
  		<form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	  		<input type="text" ng-model="ctrl.searchString" id="uname" class="username form-control input-sm" placeholder="Enter your name" required/>
		        
		    <input type="submit"  value="Search" class="btn btn-primary btn-sm">{{ctrl.inputError}}
		    
		</form>                       
		
		<div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Recommendations </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>Product Id</th>
                              <th>Product Name</th>
                              <th>Product Price</th>
                              <th>Average Rating</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.recommededResults | orderBy:'-productReview.reviewStatistics.averageOverallRating'">
                              <td><span ng-bind="u.itemId"></span></td>
                              <td><span ng-bind="u.name"></span></td>
                              <td><span ng-bind="u.msrp"></span></td>
                              <td><span ng-bind="u.productReview.reviewStatistics.averageOverallRating"></span></td>
                          </tr>
                      </tbody>
                  </table>
              </div>         
         </div>      
	    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	    <script src="<c:url value='/static/js/app.js' />"></script>
        <script src="<c:url value='/static/js/service/productSearchService.js' />"></script>
        <script src="<c:url value='/static/js/controller/productSearchController.js' />"></script>
    </body>
</html>