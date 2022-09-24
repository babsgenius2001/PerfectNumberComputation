# Prefect Number Computation Application

This application validates if a provided number is a perfect number or not. It also fetches a list of perfect numbers within a specified range of numbers. 

On top of these 2 functions - ValidatePerfectNumber and GetPerfectNumbers lies an API - PerfectNumbersAPI.

### Getting Started

All the code required to run this project/application is available in this Git repository. You can either download it as a zip file from Github or run:

```bash
$ git clone https://github.com/babsgenius2001/WordlineAssignment.git
```

### Running the application

The application contains 2 segments as earlier mentioned: 

- The program segment which contains the two methods to validate if a number is a perfect number and another to fetch all perfect numbers within a range,
- The API proper layered on the program segment.

#### Program Segment
To run the program segment, you can run both of the classes from the terminal by providing input via the Scanner class provided to test the functionality.

#### API Segment

- If you don't want to go through the process of using an IDE and just want to get the project running to explore it, navigate to the directory where you downloaded the source code and run:

    ```bash
    $ mvn spring-boot:run
    ```
If everything went well, you should be able to access the web app here: http://localhost:8080/api/

- You can also run the API application via your IDE after importing the application by running the application through the PerfectNumberApiApplication class after navigating to the PerfectNumberAPI module.

A swagger-ui link to test the functionality of the API after running the application is also available via:
* http://localhost:8080/swagger-ui/index.html

## Running Tests

There are Unit Tests for the program segment as well as end-to-end tests for the REST API.

  ### Unit Tests
  
  Unit Tests are written in JUnit and are located within the GetPerfectNumbersTest & ValidatePerfectNumbersTests classes.
  
  ### REST API Tests
  
  The REST API tests using MockMvc can be found within the PerfectNumberControllerTest class.
