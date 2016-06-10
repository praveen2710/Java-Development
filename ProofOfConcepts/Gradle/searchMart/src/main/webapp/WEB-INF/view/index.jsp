<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>Product Finder</title>
    <style>
            .odd {
                background-color: #FFF;
            }
            .even {
                background-color: #ccc;
            }
            .lead{
               font-family: "Times New Roman", Times, serif;
               font-size: 1.875em;
               font-weight: bold;
               color: rgb(0,0,255);
            }
   </style>  
 </head>
    <body ng-app="myProductFinder">
    
    	<div class="generic-container" ng-controller="UserController as ctrl">
  		<form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	  		<input type="text" ng-model="ctrl.searchString" id="uname" class="username form-control input-sm" placeholder="Enter your name" required
	  		     ng-required="true" ng-minlength="2"/>
		        
		    <input type="submit"  value="Search" ng-disabled="myForm.$invalid" class="btn btn-primary btn-sm">
		    <p><b><font color="red">{{ctrl.errorResp}}</font></b></p>
		    
		</form> 
		
		<div class="panel panel-default" ng-show="ctrl.searchResult.length">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">Search Result </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>Product Name</th>
                              <th>Model Number</th>
                              <th>Sale Price</th>
                              <th>Availability</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="search in ctrl.searchResult" ng-class-odd="'odd'" ng-class-even="'even'">
                              <td><span ng-bind="search.name"></span></td>
                              <td><span ng-bind="search.modelNumber"></span></td>
                              <td><span ng-bind="search.salePrice"></span></td>
                              <td><span ng-bind="search.stock"></span></td>
                          </tr>
                      </tbody>
                  </table>
              </div>         
         	</div>                      
		
		<div class="panel panel-default" ng-show="ctrl.recommededResults.length">
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
                          <tr ng-repeat="u in ctrl.recommededResults | orderBy:'-productReview.reviewStatistics.averageOverallRating'"
                          	ng-class-odd="'odd'" ng-class-even="'even'">
                              <td><span ng-bind="u.itemId"></span></td>
                              <td><span ng-bind="u.name"></span></td>
                              <td><span ng-bind="u.msrp"></span></td>
                              <td><span ng-bind="u.productReview.reviewStatistics.averageOverallRating"></span></td>
                          </tr>
                      </tbody>
                  </table>
              </div>         
         	</div>
         </div>      
	    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	    <script src="<c:url value='/static/js/app.js' />"></script>
        <script src="<c:url value='/static/js/service/productSearchService.js' />"></script>
        <script src="<c:url value='/static/js/controller/productSearchController.js' />"></script>
    </body>
</html>