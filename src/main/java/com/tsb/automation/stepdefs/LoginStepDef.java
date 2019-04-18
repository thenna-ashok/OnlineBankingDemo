package com.tsb.automation.stepdefs;

import com.tsb.automation.helpers.GetFilePathHelper;
import com.tsb.automation.helpers.Constants;
import com.tsb.automation.helpers.Log;
import com.tsb.automation.helpers.Webdriver;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author thenna
 * This class contains the step definitions for login feature
 */
public class LoginStepDef {
    private String url = null;

    @Before
    public void initializeData(){
        url = GetFilePathHelper.getGlobalPropertiesFile().getProperty("url");
    }

    @Given("^I navigate to the online banking application url$")
    public void iNavigateToTheOnlineBankingApplicationUrl() {
        Log.log.info(" Online Banking URL: " + url);
        Webdriver.getDriver();
        Webdriver.openURL(url);
    }

    @When("^I navigate to online banking portal login page$")
    public void iNavigateToOnlineBankingPortalLoginPage() {
        Webdriver.verifyPageLoad(Constants.BTN_SIGN_IN);
        Webdriver.clickElement(Constants.LNK_ONLINE_BANKING_LOGIN);
        Webdriver.verifyPageLoad(Constants.BTN_LOGIN);
    }

    @And("^I enter the \"([^\"]*)\" and \"([^\"]*)\" to login$")
    public void iEnterTheUsernameAndPasswordToLogin(String userName, String password) {
        Webdriver.enterValue(Constants.TXT_USERNAME, userName);
        Webdriver.enterValue(Constants.TXT_PASSWORD, password);
    }

    @And("^I click on login button$")
    public void iClickOnLoginButton() {
        Webdriver.clickElement(Constants.BTN_LOGIN);
    }

    @Then("^I should be on the landing page of user account$")
    public void iShouldBeOnTheLandingPageOfUserAccount() {
        Webdriver.verifyPageLoad(Constants.LNK_MY_ACC);
        Webdriver.verifyText(Constants.VERIFY_TXT_LANDING_PAGE);
        Webdriver.clickElement(Constants.LNK_LOG_OFF);
        Webdriver.closeBrowser();
    }
}
