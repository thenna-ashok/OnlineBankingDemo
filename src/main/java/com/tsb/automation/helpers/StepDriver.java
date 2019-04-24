package com.tsb.automation.helpers;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class initialize the web drive and contains selenium methods used for UI automation
 */
public class StepDriver {

    private static WebDriver driver = null;
    private static String browser = null;

    public static void getDriver() {
        Log.log.info("Entering method getDriver()");
        browser = GlobalHelper.getGlobalPropertiesFile().getProperty("browser");
        if(StringUtils.isNotEmpty(browser)) {
            switch (browser.toLowerCase()) {
                case Constants.CHROME_BROWSER:
                    Log.log.info("setting up chrome browser");
                    System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
                case Constants.FIREFOX_BROWSER:
                    Log.log.info("setting up firefox browser");
                    System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;
                default:
                    driver = new ChromeDriver();
            }
        } else {
            Log.log.error("** There is no browser defined **");
        }
    }

    public static void openURL(String url){
        Log.log.info("opening the url in the browser");
        driver.get(url);
    }

    public static void closeBrowser() {
        Log.log.info("closing the browser");
        driver.close();
        if(browser.equalsIgnoreCase(Constants.CHROME_BROWSER)) {
            driver.quit();
        }
    }

    public static void verifyPageLoad(String elementToVerify) {
        Log.log.info("verifying the page load");
        WebDriverWait waitForElement = new WebDriverWait(driver, 20);
        WebElement element = driver.findElement(By.xpath(elementToVerify));
        waitForElement.until(ExpectedConditions.visibilityOf(element));
    }

    public static void clickElement(String elementToClick) {
        Log.log.info("clicking the element");
        driver.findElement(By.xpath(elementToClick)).click();
    }

    public static void enterValue(String elementToEnterValue, String valueToEnter) {
        Log.log.info("entering the value: " + valueToEnter);
        driver.findElement(By.xpath(elementToEnterValue)).sendKeys(valueToEnter);
    }

    public static void verifyText(String textToVerify) {
        Log.log.info("verifying the text: " + textToVerify);
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + textToVerify + "')]"));
        Assert.assertTrue("Text not found!", list.size() > 0);
    }

    public static void selectValueFromList(String elementID, String listValue) {
        Log.log.info("selecting value from the list");
        Select account = new Select(driver.findElement(By.xpath(elementID)));
        account.selectByValue(listValue);
    }

    public static String getText(String elementToGetTxt) {
        Log.log.info("getting the text from the element");
        return driver.findElement(By.xpath(elementToGetTxt)).getText();
    }

    public static void waitForElement(long timeToWait) {
        Log.log.info("Entering into waiForElement method");
        driver.manage().timeouts().implicitlyWait(timeToWait, TimeUnit.SECONDS);
    }
}
