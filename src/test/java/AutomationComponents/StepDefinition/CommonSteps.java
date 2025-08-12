/*
 *   Author: Anand Ravi
 *   https://www.linkedin.com/in/anandravisingh/
 *   https://github.com/ravisingh171989
 *   https://anand.github.io/
 *
 * */

package AutomationComponents.StepDefinition;

import AutomationComponents.Drivers.PageFactoryManager;
import AutomationComponents.ActionsClass.GenericActions;
import AutomationComponents.Worlds.World;
import io.cucumber.java.en.*;

import java.util.logging.Logger;

public class CommonSteps {
    private final World world;
    private final GenericActions genericActions;
    Logger LOG;

    public CommonSteps(World world) {
        this.world = world;
        genericActions = PageFactoryManager.getGenericActions(world.driver);
    }

    @Given("I Anand developing the Automation Framework and launches a {string} site")
    public void i_anand_developing_the_automation_framework_and_launches_a_site( String siteURL ) {
        genericActions.launchURL(siteURL);
    }

    @And("Logout from the application")
    public void logoutFromTheApplication() throws InterruptedException {
        GenericActions.deleteAllCookies();
        GenericActions.sleep(10);
        GenericActions.browserRefresh();
    }
}