# SearchMart

__Objective__ : This application as of current plan will retrieve search result from a retailer . Based on the first product of the search give recommendation and sort them based on certain criteria's.

__Acceptance Criteria__:
  1. Search for products based upon a user-provided search string
  2. Use the first item in the search response as input for a product recommendation search 
  3. Retrieve reviews of the first 10 product recommendations
  4. Rank order the recommended products based upon the review sentiments

###How to use it.

* Download the project searchMart specifically by using this command in the desired folder

`svn export https://github.com/praveen2710/Effective_Java/trunk/ProofOfConcepts/Gradle/searchMart`

* next type `cd searchMart`   

* Run the project using `gradle jettyRun`
  Open a browser and type the url below
*GET* :  `http://localhost:8080/searchMart/index`

* Type in product name you want to search
  

__Tools and Application Used__

1. Spring MVC
2. Gradle
3. Angular
4. gretty
5. Jacoco
6. findbugs
__TODO LIST__

* ~~Brainstorm on how to implement solution ie. MVC,SPA,EJB,JPA etc.  etc...~~
* ~~Create  a desing document to define how to handle workflow and decide functionality allocation~~
* ~~Investigate on how to convert JSON to pojo quickly and efficiently~~
* ~~Do a quick read on angular and implement client side code~~
* ~~implement API classes to retrieve result from API on requests~~
* ~~Write unit test for different scenarios for API class~~
* ~~Implement the controller class for client side to interact with server~~
* ~~Read and implement testing of controller~~
* ~~Reasarch on best way to save API key~~
* ~~apply gradle plugin for code coverage and findbug~~
* ~~Verify if all necessary parts of application are on github and run it using gradle in different workspace~~
* ~~Handle http error on client side gracefully i.e 500,404,403 etc..~~
* Reaserch and determine need of testing on angular code i.e Jasmine
* Mock  json reply from third party API to make tests truly unit tests
* ~~Add logger and replace print stack trace.~~

### API Calls

Request Type |Request API| Response |
-------------|-----------|----------|
GET             |  http://localhost:8080/searchMart/index/search?productName='{productName}'         |     List of 10 products that match the search string     |
GET             |  http://localhost:8080/searchMart/index/recommendation?productId='{productId}'         |   List Of recommendation with review based on product Id       |

###Overview Of Solution

####Backend
1. After brainstorming on how to implement this I went ahaead with having a Angular Clinet side and Spring MVC server side implementation . The reason I did not go ahead with SPA was because my API Key would be exposed which was not something I felt was a good design decision . I am using jetty as my webserver . 

2. I have used jacoco as code coverage and used log4j as my logging framework. 
  * junit test outputs can be found at `build/reports/tests/index.html` after running `gradle buile`
  * code coverage reports can be found at `build/jacocoHtml/index.html` after running `gradle jacocoTestReport` 
  * logs can be found at `logs/app.log`
  * static anaysis reports can be found at `build/reports/findbugs/main.html` after running `gradle findbugsMain`
  
3. I have used `@controllerAdvice` pattern to optimize my exception handling . This avoids the messy multi layer try catch block.

4. I also used `restTemplate` to make http calls and made uses of jackson binding to map incoming json to POJO and vice versa.

5. I also added `findbugs` and some of the ones reported I need to investigate best approach to fix.

####Front End

I used angular in front end as it uses module making code maitenance very easy. I also handed over the sorting of recommendations functionality to angular since it seemed to do reduce some load on server easily .

Added a few funtionality like retry logic,min 2 letter search and inform user if the search fails and give appropriate reason.

###Issue & Assumptions.
I was consistly seeing some issue with review API where it would give `access forbidden error` out of blue. As of now I have added retry logic to handle that. I assume that maybe there is some kind of limiter.This does not happen everytime but sometimes only. My intial investigation was only able to determine that I was getting a `403` status code back.Need to look into it more deeply later on

I added findbugs but it has compatibilty with java 8. Need to find a solution or alternative later.

I have used *avgUserRating* as __review sentiment__ described in the requirements.

### My Experience

I enjoyed working on it. Making something that is testable,modular,stable and reusable with using a lot of existing tools was pretty fun. In future I would like to add `splunk` and `jenkins` to accomodate for CI and central logging.I also got to learn a lot of new things and was able to use latest and greatest there was to offer. My grip of gradle got better and also learned about an awsome way to handle exception in spring MVC .There is a lot to learn still but this is a good start.

### Extra's & Troubleshoot
  1. You can run `gradle jacocoTestReport` and go to `build/jacocoHtml/index.html` to view the code coverage report.
  2. You can view the unit test results by going to  `build/reports/tests/index.html`
  3. If there are dependency issue's run `gradle eclipse` and refresh project to resolve the issue

### Good To Have
 1. ~~A front end functionality to disable submit until 3 letters are typed.~~
 2. Learn and implement functionality for @Autowired and @Submit
 3. ~~Improve error handling from the current implementation~~ `@controllerAdvice`
 4. Create a mockJson and implement it to make test's independent of API calls
 5. On front end move products with no review to bottom.
 6. Look into adding functionality where the recommendation can be dynamic based on the product selected from retrieved result and not onlt the top products recommendation.
 7. ~~Add retry logic in angular~~


