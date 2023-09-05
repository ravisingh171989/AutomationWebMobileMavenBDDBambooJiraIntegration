/*
 *   Author: Anand Ravi
 *   https://www.linkedin.com/in/anandravisingh/
 *   https://github.com/ravisingh171989
 *   https://anand.github.io/
 *
 * */

package StepDefs;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import ActionsClass.LoginActions;

public class Login {
    WebDriver driver;
    public Login() {
        LoginActions loginActions = new LoginActions(driver);

    }
    @Given("^I Anand developing the Automation Framework and launches a \"([^\"]*)\"$")
    public void iAnandDevelopingTheAutomationFrameworkAndLaunchesASite(String Env) throws Throwable {
        LoginActions.loginToTestSite();
    }
}
