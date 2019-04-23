Online Banking demo using Selenium and BDD Framework

This project demonstrates the Test Approach to automate the online banking demo scenarios using Java, Selenium. Cucumber and Maven.


#Feature files:

package: com.tsb.automation.features

There are three feature files used to automate the scenarios.
1. login.feature - This feature file execute the positive and negative test scenarios for validating the logon implementation.
2. navigate.feature - This feature contains navigation scenario steps
3. acctransfer.feature - This feature file execute the test scenarios for transferring amount between accounts

#Java classes:

package: com.tsb.automation.helpers

This package contains java helper classes used across this project

package: com.tsb.automation.stepdefs

This package contains step definition classes for all the feature files

#resources:

This folder contains all the properties files used in this project and drivers to run on the browser

#spotlessApply 

This is a general-purpose formatting plugin. Execute the below command when ever the code is modified $ mvn spotless:apply

#How to run this project using intellij

Prerequisites

    JDK 1.8 or above
    Maven
    Install Cucumber plugin in intellij

Using the maven command clean and test

#Reports 

After execution of the scenarios, cucumber test results are saved under the below path 
target -> cucumber-pretty-report -> cucumber-html-reports -> index.html