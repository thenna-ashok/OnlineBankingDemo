package com.tsb.automation.helpers;

/**
 * @author thenna
 * This class contains the common variables used across this project
 */
public class Constants {

    public static String BTN_SIGN_IN = "//a[@id='LoginLink']";
    public static String LNK_LOG_OFF = "//font[contains(text(),'Sign Off')]";
    public static String LNK_ONLINE_BANKING_LOGIN = "//a[contains(text(),'ONLINE BANKING LOGIN')]";
    public static String BTN_LOGIN = "//input[@value='Login']";
    public static String TXT_USERNAME = "//input[@id='uid']";
    public static String TXT_PASSWORD = "//input[@id='passw']";
    public static String LNK_MY_ACC = "//a[@id='AccountLink']";
    public static String LST_ACC_DETAILS = "//select[@id='listAccounts']";
    public static String BTN_GO = "//input[@id='btnGetAccount']";
    public static String TXT_ACC_BALANCE = "//td[@colspan='2']//tr[4]//td[2]";
    public static String BTN_SELECT_ACC = "//input[@id='btnGetAccount']";
    public static String LNK_TRANSFER_FUND = "//a[@id='MenuHyperLink3']";
    public static String LST_FROM_ACC = "//select[@name='fromAccount']";
    public static String LST_TO_ACC = "//select[@id='toAccount']";
    public static String TXT_TRANSFER_AMOUNT = "//input[@id='transferAmount']";
    public static String BTN_TRANSFER = "//input[@id='transfer']";

    public static String VERIFY_TXT_HEADER_1 = "PERSONAL";
    public static String VERIFY_TXT_HEADER_2 = "SMALL BUSINESS";
    public static String VERIFY_TXT_HEADER_3 = "INSIDE ALTORO MUTUAL";
    public static String VERIFY_TXT_FOOTER = "This web application is open source!";
    public static String VERIFY_TXT_LANDING_PAGE = "Welcome to Altoro Mutual Online.";
    public static String VERIFY_TXT_AVAIL_BAL = "Available balance";
    public static Float FUND_TO_TRANSFER = 100.0f;
    public static String TXT_DECIMAL = ".0";
    public static String TXT_TRANSFER_SUCCESS_03_TO_02 = " was successfully transferred from Account 800003 into Account 800002";
    public static String TXT_TRANSFER_SUCCESS_02_TO_03 = " was successfully transferred from Account 800002 into Account 800003";
    public static String TXT_TRANSFER_SUCCESS_CC_TO_02 = " was successfully transferred from Account 4539082039396288 into Account 800002";
    public static String TXT_TRANSFER_SUCCESS_CC_TO_03 = " was successfully transferred from Account 4539082039396288 into Account 800003";
    public static String TXT_LOGIN_FAIL_MESSAGE = "Login Failed";
    public static final String SAVINGS_ACC = "800002";
    public static final String CHECKING_ACC = "800003";
    public static final String CREDIT_CARD_ACC = "4539082039396288 ";
}
