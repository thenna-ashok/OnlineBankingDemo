package com.tsb.automation.stepdefs;

import com.tsb.automation.helpers.GetFilePathHelper;
import com.tsb.automation.helpers.Constants;
import com.tsb.automation.helpers.Webdriver;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import static junit.framework.TestCase.fail;

/**
 * @author thenna
 * This class contains the step definitions for fund transfer between accounts feature
 */
public class AccTransferStepDef {
    private String url = null;
    private Float checkingAccBalance = 0.0f;
    private Float savingsAccBalance = 0.0f;

    @Before
    public void initializeData(){
        url = GetFilePathHelper.getGlobalPropertiesFile().getProperty("url");
    }

    @Given("^I navigate to the online banking portal and login with a valid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iNavigateToTheOnlineBankingPortalAndLoginAsAValidUser(String userName, String password) {
        // navigate to the website
        Webdriver.getDriver();
        Webdriver.openURL(url);

        // verify page load
        Webdriver.verifyPageLoad(Constants.BTN_SIGN_IN);
        Webdriver.clickElement(Constants.LNK_ONLINE_BANKING_LOGIN);
        Webdriver.verifyPageLoad(Constants.BTN_LOGIN);

        // Login page
        Webdriver.enterValue(Constants.TXT_USERNAME, userName);
        Webdriver.enterValue(Constants.TXT_PASSWORD, password);
        Webdriver.clickElement(Constants.BTN_LOGIN);

        // verify user landing page
        Webdriver.verifyPageLoad(Constants.LNK_MY_ACC);
        Webdriver.verifyText(Constants.VERIFY_TXT_LANDING_PAGE);
    }

    @When("^I check the \"([^\"]*)\" account have enough balance to transfer$")
    public void iCheckTheCheckingAccountHaveEnoughBalanceToTransfer(String accountName) {
        // verify the checking account balance
        Webdriver.selectValueFromList(Constants.LST_ACC_DETAILS, accountName);
        Webdriver.clickElement(Constants.BTN_GO);
        Webdriver.verifyText(Constants.VERIFY_TXT_AVAIL_BAL);
        String availBal = Webdriver.getText(Constants.TXT_ACC_BALANCE);

        // converting the checking acc balance to float to verify the balance
        if(StringUtils.isNoneEmpty(availBal)) {
            availBal = availBal.replace("$", "").trim();
            checkingAccBalance = Float.parseFloat(availBal);
        }

        // verify checking account have enough balance to transfer fund
        if(!(checkingAccBalance > Constants.FUND_TO_TRANSFER)){
                fail("Checking Account doesn't have enough balance to transfer!");
        }
    }

    @And("^I check the current balance in \"([^\"]*)\" account$")
    public void iCheckTheCurrentBalanceInSavingsAccount(String accountName) {
        // verify the checking account balance
        Webdriver.selectValueFromList(Constants.LST_ACC_DETAILS, accountName);
        Webdriver.clickElement(Constants.BTN_SELECT_ACC);
        Webdriver.verifyText(Constants.VERIFY_TXT_AVAIL_BAL);
        String availBal = Webdriver.getText(Constants.TXT_ACC_BALANCE);

        // converting the savings acc balance to float to verify the balance
        if(StringUtils.isNoneEmpty(availBal)) {
            availBal = availBal.replace("$", "").trim();
            savingsAccBalance = Float.parseFloat(availBal);
        }
    }

    @And("^I navigate to the transfer funds and transfer \"([^\"]*)\" dollars from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void iNavigateToTheTransferFundsAndTransferDollars(String amountToTransfer, String fromAccount, String toAccount) {
        Webdriver.clickElement(Constants.LNK_TRANSFER_FUND);

        // Select from and to account to transfer funds between accounts
        Webdriver.selectValueFromList(Constants.LST_FROM_ACC, fromAccount);
        Webdriver.selectValueFromList(Constants.LST_TO_ACC, toAccount);
        Webdriver.enterValue(Constants.TXT_TRANSFER_AMOUNT, amountToTransfer);
        Webdriver.clickElement(Constants.BTN_TRANSFER);
    }

    @Then("^I verify that the \"([^\"]*)\" transferred successfully$")
    public void iVerifyThatTheFundsTransferredSuccessfully(String amount) {
        Webdriver.verifyText(amount + Constants.TXT_DECIMAL + Constants.TXT_TRANSFER_SUCCESS_03_TO_02);
        Webdriver.clickElement(Constants.LNK_LOG_OFF);
        Webdriver.closeBrowser();
    }

}
