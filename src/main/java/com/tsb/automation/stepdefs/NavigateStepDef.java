package com.tsb.automation.stepdefs;

import com.tsb.automation.helpers.GetFilePathHelper;
import com.tsb.automation.helpers.GlobalConstants;
import com.tsb.automation.helpers.Log;
import com.tsb.automation.helpers.Webdriver;
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
        url = GetFilePathHelper.getGlobalPropertiesFile().getProperty("url");
    }

    @Given("^I navigate to the starting url$")
    public void iNavigateToTheStartingUrl() {
        Log.log.info("Starting URL: " + url);
        Webdriver.getDriver();
        Webdriver.openURL(url);
    }

    @When("^I verify that the web page is loaded successfully$")
    public void iVerifyThatTheWebPageIsLoaded() {
        Webdriver.verifyPageLoad(GlobalConstants.BTN_SIGN_IN);
        Log.log.info("Page load verified successfully");
    }

    @And("^I navigate to the banking portal login page via online banking login options$")
    public void iNavigateToTheBankingPortalLoginPageViaOnlineBankingLoginOptions() {
        Webdriver.clickElement(GlobalConstants.LINK_ONLINE_BANKING_LOGIN);
        Webdriver.verifyPageLoad(GlobalConstants.BTN_LOGIN);
    }

    @Then("^I could confirm that navigating to the website works correctly$")
    public void iConfirmThatNavigatingToTheWebsiteWorksCorrectly() {
        Webdriver.verifyText(GlobalConstants.VERIFY_TXT_HEADER_1);
        Webdriver.verifyText(GlobalConstants.VERIFY_TXT_HEADER_2);
        Webdriver.verifyText(GlobalConstants.VERIFY_TXT_HEADER_3);
        Webdriver.verifyText(GlobalConstants.VERIFY_TXT_FOOTER);
        Webdriver.closeBrowser();
    }

}
