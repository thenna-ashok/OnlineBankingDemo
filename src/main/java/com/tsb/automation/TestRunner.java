package com.tsb.automation;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //format = {"pretty", "html:target/cucumber-reports" }
        plugin = { "json:target/cucumber.json" },
        features = {"src/main/java/com/tsb/automation/features"},
        glue = {"stepdefs"}
        // dryRun = false,
        // strict = true,
       // monochrome = true
)

public class TestRunner {
}
