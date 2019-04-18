package com.tsb.automation.stepdefs;

import com.tsb.automation.helpers.GetFilePathHelper;
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
 * This class contains the step definitions for login feature
 */
public class LoginStepDef {
    private String url = null;

    @Before
    public void initializeData() {
        url = GetFilePathHelper.getGlobalPropertiesFile().getProperty("url");
        Log.log.info("Website url: " + url);
    }

    @Given("^I navigate to the online banking application url$")
    public void iNavigateToTheOnlineBankingApplicationUrl() {
        Log.log.info("Entering the step - iNavigateToTheOnlineBankingApplicationUrl");

        StepDriver.getDriver();
        StepDriver.openURL(url);
    }

    @When("^I navigate to online banking portal login page$")
    public void iNavigateToOnlineBankingPortalLoginPage() {
        Log.log.info("Entering the step - iNavigateToOnlineBankingPortalLoginPage");

        StepDriver.verifyPageLoad(Constants.BTN_SIGN_IN);
        StepDriver.clickElement(Constants.LNK_ONLINE_BANKING_LOGIN);
        StepDriver.verifyPageLoad(Constants.BTN_LOGIN);
    }

    @And("^I enter the \"([^\"]*)\" and \"([^\"]*)\" to login$")
    public void iEnterTheUsernameAndPasswordToLogin(String userName, String password) {
        Log.log.info("Entering the step - iEnterTheUsernameAndPasswordToLogin");

        StepDriver.enterValue(Constants.TXT_USERNAME, userName);
        StepDriver.enterValue(Constants.TXT_PASSWORD, password);
    }

    @And("^I click on login button$")
    public void iClickOnLoginButton() {
        Log.log.info("Entering the step - iClickOnLoginButton");
        StepDriver.clickElement(Constants.BTN_LOGIN);
    }

    @Then("^I should be on the landing page of user account$")
    public void iShouldBeOnTheLandingPageOfUserAccount() {
        Log.log.info("Entering the step - iShouldBeOnTheLandingPageOfUserAccount");

        StepDriver.verifyPageLoad(Constants.LNK_MY_ACC);
        StepDriver.verifyText(Constants.VERIFY_TXT_LANDING_PAGE);
        StepDriver.clickElement(Constants.LNK_LOG_OFF);
        StepDriver.closeBrowser();
    }

    @Then("^I should see the login failure error message$")
    public void iShouldSeeTheLoginFailureErrorMessage() {
        Log.log.info("Entering the step - iShouldSeeTheLoginFailureErrorMessage");

        StepDriver.verifyPageLoad("//span[@id='_ctl0__ctl0_Content_Main_message']");
        StepDriver.verifyText(Constants.TXT_LOGIN_FAIL_MESSAGE);
        StepDriver.closeBrowser();
    }
}
