APIs Testing using RestAssured

#Overview

This project demonstrates automated API testing using the RestAssured library in Java. It encompasses various HTTP methods, authentication mechanisms, and validation techniques to ensure robust API testing.

#Technologies Used

Java 8+

RestAssured for API testing

TestNG as the testing framework

Maven for project management

Jackson for JSON parsing

#Features

Automated testing of RESTful APIs

Integration with TestNG for test management

Validation of HTTP responses, headers

Clear and maintainable test structure

#project structure

APIsTask/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org.example/
│   │           └── Main.java          # Entry point (if needed)
│   └── test/
│       └── java/
│           ├── DeleteAPITest.java     # Test for DELETE method
│           ├── GETAPITests.java       # Test for GET requests
│           ├── GetToken.java          # Auth/token logic
│           ├── PatchAPITest.java      # Test for PATCH method
│           └── POSTAPITests.java      # Test for POST requests
│       └── testng.xml                 # TestNG configuration
├── pom.xml                            # Maven project file
├── README.md                          # Project documentation
├── .gitignore                         # Specifies files to be ignored by Git
└── APIsTask.iml                       # IntelliJ IDEA project file


#Test Scenarios Covered

1-Get Status

2-Get Books

3-GetSingleBook

4-User authentication and authorization

5-Post Order

6-Response status code validations

7-patch a posted order

8-Response body content verification

9-delete a posted order


reports can be found as a generated HTMLs in path : https://github.com/MayarGamal/APIs_Testing_using_RestAssured/blob/c9e61b3506ed58b6d61e86134ea7a12484d2e3ce/HTMLs
