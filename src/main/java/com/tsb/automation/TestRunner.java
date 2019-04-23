package com.tsb.automation;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "json:target/json/output.json" },
        plugin = {"html:target/cucumber-html-report", "junit:target/cucumber-junit.xml"},
        features = {"src/main/java/com/tsb/automation/features/"}
        //glue = {"stepdefs"}
        // dryRun = false,
        // strict = true,
       // monochrome = true
)

public class TestRunner {
}
