/*
 *   Author: Anand Ravi
 *   https://www.linkedin.com/in/anandravisingh/
 *   https://github.com/ravisingh171989
 *   https://anand.github.io/
 *
 * */

package StepDefs;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;

public class Login {
    @Given("^I Anand developing the Automation Framework and launches a \"([^\"]*)\" site$")
    public void iAnandDevelopingTheAutomationFrameworkAndLaunchesASite( String arg0 ) throws Throwable {
        Actions.Login.loginToTestSite();
    }
}
