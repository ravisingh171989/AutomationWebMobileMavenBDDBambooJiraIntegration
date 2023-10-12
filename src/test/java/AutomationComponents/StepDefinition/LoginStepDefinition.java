/*
 *   Author: Anand Ravi
 *   https://www.linkedin.com/in/anandravisingh/
 *   https://github.com/ravisingh171989
 *   https://anand.github.io/
 *
 * */

package AutomationComponents.StepDefinition;
import AutomationComponents.ActionsClass.GenericActions;
import AutomationComponents.Drivers.PageFactoryManager;
import AutomationComponents.Worlds.World;
import io.cucumber.java.en.*;
import AutomationComponents.ActionsClass.LoginActions;

public class LoginStepDefinition {
    GenericActions genericActions;
    World world;
    LoginActions loginActions;

    public LoginStepDefinition(World world) {
        this.world = world;
        genericActions = PageFactoryManager.getGenericActions(world.driver);
        loginActions = new LoginActions(world.driver);
    }

    @Given("I login to {string} site with {string} credential")
    public void ILoginToSiteWithCredential( String siteURL, String creds ) throws InterruptedException {
        loginActions.loginToTestSite(siteURL, creds);
    }

    @Then("I should be able to verify that I am able to login to {string} account")
    public void iShouldBeAbleToVerifyThatIAmAbleToLoginToAccount(String arg0) {
    }
}
