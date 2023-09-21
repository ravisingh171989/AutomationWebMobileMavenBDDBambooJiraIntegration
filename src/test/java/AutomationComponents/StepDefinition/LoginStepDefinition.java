/*
 *   Author: Anand Ravi
 *   https://www.linkedin.com/in/anandravisingh/
 *   https://github.com/ravisingh171989
 *   https://anand.github.io/
 *
 * */

package AutomationComponents.StepDefinition;

import AutomationComponents.Utils.GenericActions;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import AutomationComponents.ActionsClass.LoginActions;

public class LoginStepDefinition {
    GenericActions genericActions;

    public LoginStepDefinition(WebDriver driver) {
        genericActions = new GenericActions(driver);
    }

    @Given("I login to {string} site with {string} credential")
    public void ILoginToSiteWithCredential( String siteURL ) {
        LoginActions.loginToTestSite(siteURL);
    }

    @Then("I should be able to verify that I am able to login to {string} account")
    public void iShouldBeAbleToVerifyThatIAmAbleToLoginToAccount(String arg0) {
    }
}
