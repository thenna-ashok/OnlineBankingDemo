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
    public void initializeData() {
        url = GetFilePathHelper.getGlobalPropertiesFile().getProperty("url");
        Log.log.info("Website url: " + url);
    }

    @Given("^I navigate to the online banking portal and login with a valid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iNavigateToTheOnlineBankingPortalAndLoginAsAValidUser(String userName, String password) {
        Log.log.info("Entering the step - iNavigateToTheOnlineBankingPortalAndLoginAsAValidUser");

        // navigate to the website
        StepDriver.getDriver();
        StepDriver.openURL(url);

        // verify page load
        StepDriver.verifyPageLoad(Constants.BTN_SIGN_IN);
        StepDriver.clickElement(Constants.LNK_ONLINE_BANKING_LOGIN);
        StepDriver.verifyPageLoad(Constants.BTN_LOGIN);

        // Login page
        StepDriver.enterValue(Constants.TXT_USERNAME, userName);
        StepDriver.enterValue(Constants.TXT_PASSWORD, password);
        StepDriver.clickElement(Constants.BTN_LOGIN);

        // verify user landing page
        StepDriver.verifyPageLoad(Constants.LNK_MY_ACC);
        StepDriver.verifyText(Constants.VERIFY_TXT_LANDING_PAGE);
    }

    @When("^I check the \"([^\"]*)\" account have enough balance to transfer$")
    public void iCheckTheCheckingAccountHaveEnoughBalanceToTransfer(String accountName) {
        Log.log.info("Entering the step - iCheckTheCheckingAccountHaveEnoughBalanceToTransfer");

        // verify the checking account balance
        StepDriver.selectValueFromList(Constants.LST_ACC_DETAILS, accountName);
        StepDriver.clickElement(Constants.BTN_GO);
        StepDriver.verifyText(Constants.VERIFY_TXT_AVAIL_BAL);
        String availBal = StepDriver.getText(Constants.TXT_ACC_BALANCE);

        // converting the checking acc balance to float to verify the balance
        if (StringUtils.isNoneEmpty(availBal)) {
            availBal = availBal.replace("$", "").trim();
            checkingAccBalance = Float.parseFloat(availBal);
        }

        // verify checking account have enough balance to transfer fund
        if (!(checkingAccBalance > Constants.FUND_TO_TRANSFER)) {
            fail("Checking Account doesn't have enough balance to transfer!");
        }
    }

    @And("^I check the current balance in \"([^\"]*)\" account$")
    public void iCheckTheCurrentBalanceInSavingsAccount(String accountName) {
        Log.log.info("Entering the step - iCheckTheCurrentBalanceInSavingsAccount");

        // verify the checking account balance
        StepDriver.selectValueFromList(Constants.LST_ACC_DETAILS, accountName);
        StepDriver.clickElement(Constants.BTN_SELECT_ACC);
        StepDriver.verifyText(Constants.VERIFY_TXT_AVAIL_BAL);
        String availBal = StepDriver.getText(Constants.TXT_ACC_BALANCE);

        // converting the savings acc balance to float to verify the balance
        if (StringUtils.isNoneEmpty(availBal)) {
            availBal = availBal.replace("$", "").trim();
            savingsAccBalance = Float.parseFloat(availBal);
        }
    }

    @And("^I navigate to the transfer funds and transfer \"([^\"]*)\" dollars from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void iNavigateToTheTransferFundsAndTransferDollars(final String amountToTransfer, final String fromAccount, final String toAccount) {
        Log.log.info("Entering the step - iNavigateToTheTransferFundsAndTransferDollars");

        StepDriver.clickElement(Constants.LNK_TRANSFER_FUND);

        // Select from and to account to transfer funds between accounts
        StepDriver.selectValueFromList(Constants.LST_FROM_ACC, fromAccount);
        StepDriver.selectValueFromList(Constants.LST_TO_ACC, toAccount);
        StepDriver.enterValue(Constants.TXT_TRANSFER_AMOUNT, amountToTransfer);
        StepDriver.clickElement(Constants.BTN_TRANSFER);
    }

    @Then("^I verify that the \"([^\"]*)\" transferred successfully from \"([^\"]*)\"$")
    public void iVerifyThatTheFundsTransferredSuccessfully(final String amount, final String accountName) {
        Log.log.info("Entering the step - iVerifyThatTheFundsTransferredSuccessfully");

        if(accountName.equalsIgnoreCase(Constants.SAVINGS_ACC)) {
            StepDriver.verifyText(amount + Constants.TXT_DECIMAL + Constants.TXT_TRANSFER_SUCCESS_02_TO_03);
        } else if(accountName.equalsIgnoreCase(Constants.CHECKING_ACC)) {
            StepDriver.verifyText(amount + Constants.TXT_DECIMAL + Constants.TXT_TRANSFER_SUCCESS_03_TO_02);
        } else if(accountName.equalsIgnoreCase(Constants.CREDIT_CARD_ACC)) {
            StepDriver.verifyText(amount + Constants.TXT_DECIMAL + Constants.TXT_TRANSFER_SUCCESS_CC_TO_02);
        }

        StepDriver.clickElement(Constants.LNK_LOG_OFF);
        StepDriver.closeBrowser();
    }
}
