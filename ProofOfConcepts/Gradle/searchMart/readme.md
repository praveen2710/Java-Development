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
6. Jacoco
7. findbugs (currently disable as it is not compatible with java 8)

__TODO LIST__

* ~~Brainstorm on how to implement solution ie. MVC,SPA,EJB,JPA etc.  etc...~~
* ~~Create  a desing document to define how to handle workflow and decide functionality allocation~~
* ~~Investigate on how to convert JSON to pojo quickly and efficiently~~
* Do a quick read on angular and implement client side code
* ~~implement API classes to retrieve result from API on requests~~
* ~~Write unit test for different scenarios for API class~~
* ~~Implement the controller class for client side to interact with server~~
* Read and implement testing of controller
* Reasarch on best way to save API key
* apply gradle plugin for code coverage and findbug
* Verify if all necessary parts of application are on github and run it using gradle in different workspace
* Handle http error on client side gracefully i.e 500,404,403 etc..
* Reaserch and determine need of testing on angular code i.e Jasmine
* Mock  json reply from third party API to make tests truly unit tests
* 

###How to use it.

* Download the project searchMart specifically by using this command in the desired folder

`svn export https://github.com/praveen2710/Effective_Java/trunk/ProofOfConcepts/Gradle/searchMart`

* Import the folder in eclipse as a gradle project

* Run the project using `gradle jettyRun`
  Open a browser and type the url below
*GET* :  `http://localhost:8080/searchMart/index`

### API Calls

Request Type |Request API| Response |
-------------|-----------|----------|
GET             |  http://localhost:8080/searchMart/index/search?productName='{productName}'         |     List of 10 products that match the search string     |
GET             |  http://localhost:8080/searchMart/index/recommendation?productId='{productId}'         |   List Of recommendation with review based on product Id       |

### Extra's & Troubleshoot
  1. You can run `gradle jacocoTestReport` and go to `build/jacocoHtml/index.html` to view the code coverage report.
  2. You can view the unit test results by going to  `build/reports/tests/index.html`
  3. If there are dependency issue's run `gradle eclipse` and refresh project to resolve the issue

### Good To Have
 1. A front end functionality to disable submit until 3 letters are typed.
 2. Learn and implement functionality for @Autowired and @Submit
 3. Improve error handling from the current implementation
 4. Create a mockJson and implement it to make test's independent of API
 5. On front end move products with no review to bottom.
 6. Look into adding functionality where the recommendation can be dynamic based on the product selected from retrieved result and not onlt the top products recommendation.
