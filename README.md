# UI and API Automated Tests

## Summary of the Automation task

## A) UI Tests
The purpose of this task is to automate UI tests according to existing scenarios.

### Test Case 1:
As stated in the task, after navigating to the homepage, 
the user hover over Services Link and then click Automation link. 
It is verified that Automation Screen is displayed, and “Automation” text is visible in Page.
In addition, after the user hover over Services Link again, 
it is verified that the Services and Automation are selected.

### Test Case 2:
The user fill the "Contact us" form on the Automation Page. 
After checking the "I agree" checkbox and clicking the "SUBMIT" button, 
it is verified that "Thank you" message is displayed.

# reCAPTCHA issue 
There are three ways by which it can be handled Captcha issue in Selenium:

1-You can disable Captcha in test environments.
2-YOu can click the reCAPTCHA checkbox (iframe switch is used).
3-You can add a delay in your selenium script and manually solving Captcha while running test automation.

In order to handle reCAPTCHA issue, second and third ones are used in this Test Case.

### Test Case 3:
All the Country specific Sogeti links on the "Country" dropdown should work properly.

## B) API Tests

### Test Case 1:
Writing API Test for http://api.zippopotam.us/de/bw/stuttgart
It is verified that status code is 200, content type is JSON and response time is below 1s.
After that it is verified in Response that "country" is "Germany" and "state" is "Baden-Württemberg".
Finally, it is verified in Response that for Post Code "70597" the place name has "Stuttgart Degerloch".

### Test Case 2:
Writing API Data Driven Test for http://api.zippopotam.us/{country}/{postal-code}
It is verified that status code is 200, content type is JSON and response time is below 1s.
After that, "Place Name" is verified in Response for each input "Country" and "Postal Code".

## FRAMEWORK: Selenium-Cucumber-Java

The`selenium-cucumber-java` framework is used for this automation task.
Test cases are written in Gherkin language. Automation scripts are developed with Java 
and as Automation test framework the Cucumber (v.5.7.0) BDD framework is used.
The framework generates both cucumber reports, and `screen shots` for tests. 

## Installation

1. JDK 1.8+ 
2. IntelliJ
3. Project Dependencies needed
    - Maven
    - Cucumber-java v.5.7.0
    - Selenium-java v.4.0.0 
    - Web Driver Manager v.4.4.3 (bonigarcia/webdrivermanager)
    - Cucumber-JUnit v.5.7.0
    - Logger slf4j-simple v.1.7.21
    - Java Faker v.1.0.2
    - rest-assured v.4.3.2
4. Browser driver (desired browser driver and Configuration files' path should be set)

## Framework set up
You can fork or clone repository from [here](https://github.com/fatihsems/sogeti.git) or download zip and set
it up in your local workspace.

## Executing Task
Open terminal (MAC OSX) or command prompt / Powershell (for Windows OS) go to the project directory and
type `mvn verify test` command to run test automation. 
Tests are executed default with Google Chrome browser.

## Reporters
This framework `selenium-cucumber-java` creates different reports according to dependencies/plugins.

##### HTML Report
Path: ...\target\default-html.reports\ 
(you can open the index HTML document)

##### Graphical HTML Report
Path: ...\target\myReports\cucumber-html-reports\ 
(here you can open any of HTML documents)

##### JSON Report
Path: ...\target\cucumber.json

## Jira-XRAY Integration
You can import the `cucumber.json` file into the Test Execution in Jira-XRAY.

### Automation scripts using BDD approach - Cucumber-Java
Gherkin uses a set of special keywords to give structure and meaning to executable specifications. 
Each keyword is translated to many spoken languages
You can find further information about Cucumber-BDD [here](https://cucumber.io/docs/guides/overview/)

##### A typical Scenario
```
Scenario: eat 5 out of 12
  Given there are 12 cucumbers
  When I eat 5 cucumbers
  Then I should have 7 cucumbers
  
Scenario Outline: eating
  Given there are <start> cucumbers
  When I eat <eat> cucumbers
  Then I should have <left> cucumbers

  Examples:
    | start | eat | left |
    |    12 |   5 |    7 |
    |    20 |   5 |   15 |

```


