package com.tsb.automation.helpers;

import org.apache.log4j.Logger;

public class Log {

    public static Logger log = Logger.getLogger(Log.class.getName());

    public Log() {
    }

    public static String ExecuteTestForScenario(String scenarioName, String testCaseNumber) {
        return "\nStarted Executing " + scenarioName + " TestCase " + testCaseNumber + " by parsing json using GSON \n";
    }

    public static String ExecuteTest(String scenarioName, String testCaseNumber) {
        return "\nStarted Executing " + scenarioName + " TestCase " + testCaseNumber + " by parsing xml using DOMParser \n";
    }

    public static String ShowSuccessfulMessage(String scenarioName, String testCaseNumber) {
        return "\nTestCase " + testCaseNumber + " for " + scenarioName + " is Successfully Executed \n";
    }
}
