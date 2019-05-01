package com.tsb.automation.stepdefs;

import com.tsb.automation.helpers.Constants;
import com.tsb.automation.helpers.Log;
import com.tsb.automation.helpers.StepDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * @author thenna
 * This class contains the common step definitons used across all the features
 */
public class CommonStepDef {
    @Then("^I should logoff the user and close the browser$")
    public void iShouldLogoffTheUserAndCloseTheBrowser() {
        Log.log.info("Entering the step - iShouldLogoffTheUser");
        StepDriver.clickElement(Constants.LNK_LOG_OFF);
        StepDriver.closeBrowser();
    }

    @And("^I wait for \"([^\"]*)\" seconds$")
    public void iWaitForSeconds(String timeToWait) {
        Log.log.info("Entering the step - iShouldWaitForSeconds");
        StepDriver.waitForElement(Long.parseLong(timeToWait));
    }
}
