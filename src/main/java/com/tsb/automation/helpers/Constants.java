package com.tsb.automation.helpers;

/**
 * @author thenna
 * This class contains the common variables used across this project
 */
public class Constants {

    public static final String BTN_SIGN_IN = "//a[@id='LoginLink']";
    public static final String LNK_LOG_OFF = "//font[contains(text(),'Sign Off')]";
    public static final String LNK_ONLINE_BANKING_LOGIN = "//a[contains(text(),'ONLINE BANKING LOGIN')]";
    public static final String BTN_LOGIN = "//input[@value='Login']";
    public static final String TXT_USERNAME = "//input[@id='uid']";
    public static final String TXT_PASSWORD = "//input[@id='passw']";
    public static final String LNK_MY_ACC = "//a[@id='AccountLink']";
    public static final String LST_ACC_DETAILS = "//select[@id='listAccounts']";
    public static final String BTN_GO = "//input[@id='btnGetAccount']";
    public static final String TXT_ACC_BALANCE = "//td[@colspan='2']//tr[4]//td[2]";
    public static final String BTN_SELECT_ACC = "//input[@id='btnGetAccount']";
    public static final String LNK_TRANSFER_FUND = "//a[@id='MenuHyperLink3']";
    public static final String LST_FROM_ACC = "//select[@name='fromAccount']";
    public static final String LST_TO_ACC = "//select[@id='toAccount']";
    public static final String TXT_TRANSFER_AMOUNT = "//input[@id='transferAmount']";
    public static final String BTN_TRANSFER = "//input[@id='transfer']";
    public static final String TXT_CASH_ADV_FEE = "//div[@id='recent']//tr[1]//td[3]";
    public static final String LNK_ACC_SUMMARY = "//a[contains(text(),'View Account Summary')]";
    public static final String VERIFY_TXN_DATE = "//div[@id='recent']//tr[1]//td[1]";
    public static final String VERIFY_TXN_DESC = "//div[@id='recent']//tr[1]//td[2]";
    public static final String VERIFY_TXN_AMOUNT = "//div[@id='recent']//tr[1]//td[3]";

    public static final String VERIFY_TXT_HEADER_1 = "PERSONAL";
    public static final String VERIFY_TXT_HEADER_2 = "SMALL BUSINESS";
    public static final String VERIFY_TXT_HEADER_3 = "INSIDE ALTORO MUTUAL";
    public static final String VERIFY_TXT_FOOTER = "This web application is open source!";
    public static final String VERIFY_TXT_LANDING_PAGE = "Welcome to Altoro Mutual Online.";
    public static final String VERIFY_TXT_AVAIL_BAL = "Available balance";
    public static final String TXT_ONE_DECIMAL = ".0";
    public static final String VERIFY_TXT_TRANSFER_SUCCESS_03_TO_02 = " was successfully transferred from Account 800003 into Account 800002";
    public static final String VERIFY_TXT_TRANSFER_SUCCESS_02_TO_03 = " was successfully transferred from Account 800002 into Account 800003";
    public static final String VERIFY_TXT_TRANSFER_SUCCESS_CC_TO_02 = " was successfully transferred from Account 4539082039396288 into Account 800002";
    public static final String VERIFY_TXT_LOGIN_FAIL_MESSAGE = "Login Failed";
    public static final String SAVINGS_ACC = "800002";
    public static final String CHECKING_ACC = "800003";
    public static final String CREDIT_CARD_ACC = "4539082039396288 ";
    public static final String VERIFY_TXT_CC_CASH_ADV_FEE = "$2.50";
    public static final String VERIFY_TXT_DEPOSIT = "Deposit";
    public static final String VERIFY_TXT_WITHDRAWAL = "Withdrawal";
    public static final String TXT_TWO_DECIMALS = ".00";
}
