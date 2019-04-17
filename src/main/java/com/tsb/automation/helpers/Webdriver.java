package com.tsb.automation.helpers;

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
import java.util.List;

/**
 * This class initialize the web drive and contains selenium methods used for UI automation
 */
public class Webdriver {

    public static WebDriver driver = null;

    public static WebDriver getDriver() {
        String browser = GetFilePathHelper.getGlobalPropertiesFile().getProperty("browser");
        if(StringUtils.isNotEmpty(browser)) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;
                default:
                    driver = new ChromeDriver();
            }
        } else {
            Log.log.error("** There is no browser defined **");
        }
        return driver;
    }

    public static void openURL(String url){
        driver.get(url);
    }

    public static void closeBrowser() {
        driver.close();
        driver.quit();
    }

    public static void verifyPageLoad(String elementToVerify){
        WebDriverWait waitForElement = new WebDriverWait(driver, 20);
        WebElement element = driver.findElement(By.xpath(elementToVerify));
        waitForElement.until(ExpectedConditions.visibilityOf(element));
    }

    public static void clickElement(String elementToClick){
        driver.findElement(By.xpath(elementToClick)).click();
    }

    public static void enterValue(String elementToEnterValue, String valueToEnter) {
        driver.findElement(By.xpath(elementToEnterValue)).sendKeys(valueToEnter);
    }

    public static void verifyText(String textToVerify){
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + textToVerify + "')]"));
        Assert.assertTrue("Text not found!", list.size() > 0);
    }

    public static void selectValueFromList(String elementID, String listValue){
        Select account = new Select(driver.findElement(By.xpath(elementID)));
        account.selectByVisibleText(listValue);
    }

    public static String getText(String elementToGetTxt){
        return driver.findElement(By.xpath(elementToGetTxt)).getText();
    }
}
