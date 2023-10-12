/*
 *   Author: Anand Ravi
 *   https://www.linkedin.com/in/anandravisingh/
 *   https://github.com/ravisingh171989
 *   https://anand.github.io/
 *
 * */

package AutomationComponents.ActionsClass;

import AutomationComponents.ObjectRepository.ObjectRepositoryOfSite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static AutomationComponents.ActionsClass.GenericActions.*;

public class LoginActions {
    WebDriver driver;

    public LoginActions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginToTestSite(String url, String creds) throws InterruptedException {
        String username = System.getProperty("username");
        String password = System.getProperty("password");

        waitForPageToLoad("Username Page");
        waitForElement(ObjectRepositoryOfSite.usernameTextbox);
        sendkeysToElement(ObjectRepositoryOfSite.usernameTextbox, username);
        clickElement(ObjectRepositoryOfSite.nextButton);
        waitForPageToLoad("Password Page");
        sleep(10);
        sendkeysToElement(ObjectRepositoryOfSite.passwordTextbox, password);
    }
}
