/*
 *   Author: Anand Ravi
 *   https://www.linkedin.com/in/anandravisingh/
 *   https://github.com/ravisingh171989
 *   https://anand.github.io/
 *
 * */
package AutomationComponents.ActionsClass;

import AutomationComponents.ObjectRepository.ObjectRepositoryOfSite;
import AutomationComponents.Utils.Utils;
import com.google.gson.JsonParser;
import gherkin.JSONParser;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Logger;

public class GenericActions {
    Properties properties;
    WebDriver driver;
    public Logger LOG = Logger.getLogger(GenericActions.class.getName());
    public Actions actions;
    public GenericActions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public void launchURL( String siteURL ) {
        driver.get(Utils.getInstance().getURL(siteURL));
    }

    public void readJsonFile(String filename) throws FileNotFoundException {
        JsonParser jsonParser = new JsonParser();
        FileReader reader = new FileReader(filename+".json");
    }

    public boolean isElementPresentandEnabled(By element) {
        LOG.info("Element is Enabled and Displayed");
        return driver.findElement(element).isEnabled() && driver.findElement(element).isDisplayed();
    }

    public void clickElement(By element) {
        driver.findElement(element).click();
    }

    public void sendkeysToElement(By element, String textToBeEntered) {
        driver.findElement(element).sendKeys(textToBeEntered);
    }

    public WebElement findElementByLocator(By by) {
        WebElement element = driver.findElement(by);
        return element;
    }

    public void waitForElement(By element) {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
        }
        catch(TimeoutException e ){
            System.out.println("Element is not visible: " + element );
            System.out.println();
            System.out.println(e.getMessage());
            throw new TimeoutException();
        }
    }

    public void waitForPageToLoad(String PageName) {
        String pageLoadStatus;
        JavascriptExecutor js;
        do {
            js = (JavascriptExecutor) driver;
            pageLoadStatus = (String)js.executeScript("return document.readyState");
            LOG.info(".");
        } while ( !pageLoadStatus.equals("complete") );
        LOG.info(PageName + " page loaded successfully");
    }

    public void delayExecution(int seconds) throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(seconds));
    }

    public void takeScreenshot(String screenshot) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("/src/test/resources/ScreenShots/"+screenshot+".png"));
            System.out.println("ScreenShot Taken");
        }
        catch (Exception e) {
            System.out.println("Exception while taking ScreenShot "+e.getMessage());
        }
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

    public void moveToElementToClick(By element) {
        actions.moveToElement(findElementByLocator(element)).build().perform();
    }

    public void fail() {
        Assert.fail();
    }

    public String getText(By element) {
        String textRetrieved = driver.findElement(element).getText();
        return textRetrieved;
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void browserRefresh() {
        driver.navigate().refresh();
    }

    public void navigateToModule() throws InterruptedException {
        delayExecution(20);
        clickElement(ObjectRepositoryOfSite.modulesButton);
    }

    public String generateRandomWords(int numberOfWords) {
        String randomString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder randomStringGenerated = new StringBuilder();
        Random random = new Random();
        while (randomStringGenerated.length() < 5) {
            int index = (int) (random.nextFloat() * randomString.length());
            randomStringGenerated.append(randomString.charAt(index));
        }
        String saltStr = randomStringGenerated.toString();
        return saltStr;
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
