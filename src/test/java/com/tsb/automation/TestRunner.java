package com.tsb.automation;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/tsb/automation/features",
        glue = "com.tsb.automation.stepdefs",
        plugin = {"html:target/cucumber-html-report", "junit:target/cucumber-junit.xml"},
        format = {"pretty", "json:target/json/output.json"})

public class TestRunner {
}
