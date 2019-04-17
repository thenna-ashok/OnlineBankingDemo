package com.tsb.automation.helpers;

/**
 * @author thenna
 * This class contains the common variables used across this project
 */
public class Constants {

    public static String BTN_SIGN_IN = "//a[@id='LoginLink']";
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

    public static String VERIFY_TXT_HEADER_1 = "PERSONAL";
    public static String VERIFY_TXT_HEADER_2 = "SMALL BUSINESS";
    public static String VERIFY_TXT_HEADER_3 = "INSIDE ALTORO MUTUAL";
    public static String VERIFY_TXT_FOOTER = "This web application is open source!";
    public static String VERIFY_TXT_LANDING_PAGE = "Welcome to Altoro Mutual Online.";
    public static String VERIFY_TXT_AVAIL_BAL = "Available balance";
    public static Float FUND_TO_TRANSFER = 100.0f;
}