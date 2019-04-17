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
 * This class contains the step definitions for login feature
 */
public class LoginStepDef {
    private String url = null;
    private String userName = null;
    private String password = null;

    @Before
    public void initializeData(){
        url = GetFilePathHelper.getGlobalPropertiesFile().getProperty("url");
        userName = GetFilePathHelper.getGlobalPropertiesFile().getProperty("username");
        password = GetFilePathHelper.getGlobalPropertiesFile().getProperty("password");
    }

    @Given("^I navigate to the online banking application url$")
    public void iNavigateToTheOnlineBankingApplicationUrl() {
        Log.log.info(" Online Banking URL: " + url);
        Webdriver.getDriver();
        Webdriver.openURL(url);
    }

    @When("^I navigate to online banking portal login page$")
    public void iNavigateToOnlineBankingPortalLoginPage() {
        Webdriver.verifyPageLoad(GlobalConstants.BTN_SIGN_IN);
        Webdriver.clickElement(GlobalConstants.LINK_ONLINE_BANKING_LOGIN);
        Webdriver.verifyPageLoad(GlobalConstants.BTN_LOGIN);
    }

    @And("^I enter the username and password to login$")
    public void iEnterTheUsernameAndPasswordToLogin() {
        Webdriver.enterValue(GlobalConstants.TXT_USERNAME, userName);
        Webdriver.enterValue(GlobalConstants.TXT_PASSWORD, password);
    }

    @And("^I click on login button$")
    public void iClickOnLoginButton() {
        Webdriver.clickElement(GlobalConstants.BTN_LOGIN);
    }

    @Then("^I should be on the landing page of user account$")
    public void iShouldBeOnTheLandingPageOfUserAccount() {
        Webdriver.verifyPageLoad(GlobalConstants.LINK_MY_ACC);
        Webdriver.verifyText(GlobalConstants.VERIFY_TXT_LANDING_PAGE);
    }
}
