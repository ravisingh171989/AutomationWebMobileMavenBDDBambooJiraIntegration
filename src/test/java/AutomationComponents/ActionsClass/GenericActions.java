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
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

public class GenericActions {
    Properties properties;
    protected static WebDriver driver;
    private static final Logger LOG = Logger.getLogger(GenericActions.class.getName());;

    public GenericActions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void launchURL( String siteURL ) {
        driver.get(Utils.getInstance().getURL(siteURL));
    }

    public void readJsonFile(String filename) throws FileNotFoundException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(filename+".json");
    }

    public boolean isElementPresentandEnabled(WebElement element) {
        LOG.info("Element is Enabled and Displayed");
        return element.isEnabled() && element.isDisplayed();
    }

    public static void clickElement(By element) {
        driver.findElement(element).click();
    }

    public static void sendkeysToElement(By element, String textToBeEntered) {
        driver.findElement(element).sendKeys(textToBeEntered);
    }

    public static WebElement findElementByLocator(By by) {
        WebElement element = driver.findElement(by);
        return element;
    }

    public static void waitForElement(By element) {
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

    public static void waitForPageToLoad(String PageName) {
        String pageLoadStatus;
        JavascriptExecutor js;

        do {
            js = (JavascriptExecutor) driver;
            pageLoadStatus = (String)js.executeScript("return document.readyState");
            LOG.info(".");
        } while ( !pageLoadStatus.equals("complete") );
        LOG.info(PageName + " page loaded successfully");
    }

    public static void sleep(int seconds) throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(seconds));
    }

    public static void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

    public static void browserRefresh() {
        driver.navigate().refresh();
    }
}