package com.tsb.automation.stepdefs;


import com.tsb.automation.helpers.GetFilePathHelper;
import com.tsb.automation.helpers.Log;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigateStepDef {

    WebDriver driver = null;
    public static String BTN_SIGN_IN = "//a[@id='LoginLink']";

    @Given("^I navigate to the starting url$")
    public void i_navigate_to_the_starting_url() {
        String url = GetFilePathHelper.getGlobalPropertiesFile().getProperty("url");
        Log.log.info("starting URL: " + url);
        driver = openBrowser(url);
        driver.get(url);
    }

    @And("^I verify that the web page is loaded$")
    public void i_verify_that_the_web_page_is_loaded() throws Throwable {
        verifyPageLoad(BTN_SIGN_IN);
        Log.log.info("Page  load verified successfully");
    }

    @When("^The page loads correctly with required details$")
    public void the_page_loads_correctly_with_required_details() throws Throwable {

    }

    @Then("^I confirm that navigating to the website works correctly$")
    public void i_confirm_that_navigating_to_the_website_works_correctly() throws Throwable {

    }

    private WebDriver openBrowser(String url){
        String browser = GetFilePathHelper.getGlobalPropertiesFile().getProperty("browser");

        if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if(browser.equalsIgnoreCase("firefox")) {
            // Initialize firefox driver
        } else if(browser.equalsIgnoreCase("ie")) {
            // Initialize IE driver
        }
        return driver;
    }

    private void closeBrowser() {
        driver.close();
        driver.quit();
    }

    private void verifyPageLoad(String elementToVerify){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        By addItem = By.xpath(elementToVerify);

        // get the "Add Item" element
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(addItem));

        //trigger the reload of the page
        driver.findElement(By.id("...")).click();

        // wait the element "Add Item" to become stale
        wait.until(ExpectedConditions.stalenessOf(element));

        // click on "Add Item" once the page is reloaded
        wait.until(ExpectedConditions.presenceOfElementLocated(addItem)).click();
    }
}
