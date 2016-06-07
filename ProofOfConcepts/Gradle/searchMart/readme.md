# SearchMart

__Objective__ : This application as of current plan will retrieve search result from a retailer . Based on the first product of the search give recommendation and sort them based on certain criteria's.

__Acceptance Criteria__:
  1. Search for products based upon a user-provided search string
  2. Use the first item in the search response as input for a product recommendation search 
  3. Retrieve reviews of the first 10 product recommendations
  4. Rank order the recommended products based upon the review sentiments

  

__Tools and Application Used__

1. Spring MVC
2. Gradle
3. Angular
4. FindBugs
5. gretty


__TODO LIST__

* Brainstorm on how to implement solution ie. MVC,SPA,EJB,JPA etc.  etc...
* Create  a desing document to define how to handle workflow and decide functionality allocation
* Investigate on how to convert JSON to pojo quickly and efficiently
* Do a quick read on angular and implement client side code
* implement API classes to retrieve result from API on requests
* Write unit test for different scenarios for API class
* Implement the controller class for client side to interact with server
* Read and implement testing of controller
* Reasarch on best way to save API key
* apply gradle plugin for code coverage and findbug
* Verify if all necessary parts of application are on github and run it using gradle in different workspace
* Handle http error on client side gracefully i.e 500,404,403 etc..
* Reaserch and determine need of testing on angular code i.e Jasmine

  
