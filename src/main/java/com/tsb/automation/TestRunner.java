package com.tsb.automation;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/com/tsb/automation/features",
        glue = "stepdefs",
        plugin = {"html:target/cucumber-html-report"}
)

public class TestRunner {
}
