package com.tsb.automation.stepdefs;

import com.tsb.automation.helpers.GlobalHelper;
import com.tsb.automation.helpers.Constants;
import com.tsb.automation.helpers.Log;
import com.tsb.automation.helpers.StepDriver;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author thenna
 * This class contains the step definitions for navigate feature
 */
public class NavigateStepDef {

    private String url = null;

    @Before
    public void initializeData(){
        url = GlobalHelper.getGlobalPropertiesFile().getProperty("url");
        Log.log.info("Website url: " + url);
    }

    @Given("^I navigate to the starting url$")
    public void iNavigateToTheStartingUrl() {
        Log.log.info("Entering the step - iNavigateToTheStartingUrl");

        StepDriver.getDriver();
        StepDriver.openURL(url);
    }

    @When("^I verify that the web page is loaded successfully$")
    public void iVerifyThatTheWebPageIsLoaded() {
        Log.log.info("Entering the step - iVerifyThatTheWebPageIsLoaded");
        StepDriver.verifyPageLoad(Constants.BTN_SIGN_IN);
    }

    @And("^I navigate to the banking portal login page via online banking login options$")
    public void iNavigateToTheBankingPortalLoginPageViaOnlineBankingLoginOptions() {
        Log.log.info("Entering the step - iNavigateToTheBankingPortalLoginPageViaOnlineBankingLoginOptions");

        StepDriver.clickElement(Constants.LNK_ONLINE_BANKING_LOGIN);
        StepDriver.verifyPageLoad(Constants.BTN_LOGIN);
    }

    @Then("^I could confirm that navigating to the website works correctly$")
    public void iConfirmThatNavigatingToTheWebsiteWorksCorrectly() {
        Log.log.info("Entering the step - iConfirmThatNavigatingToTheWebsiteWorksCorrectly");

        StepDriver.verifyText(Constants.VERIFY_TXT_HEADER_1);
        StepDriver.verifyText(Constants.VERIFY_TXT_HEADER_2);
        StepDriver.verifyText(Constants.VERIFY_TXT_HEADER_3);
        StepDriver.verifyText(Constants.VERIFY_TXT_FOOTER);
        StepDriver.closeBrowser();
    }
}
