package AutomationComponents.StepDefinition;

import AutomationComponents.ActionsClass.LoginActions;
import AutomationComponents.Utils.GenericActions;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class CommonSteps extends GenericActions {
    WebDriver driver = null;
    GenericActions genericActions;

    public CommonSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Given("I Anand developing the Automation Framework and launches a {string} site")
    public void i_anand_developing_the_automation_framework_and_launches_a_site( String siteURL ) {
        genericActions.initBrowser(siteURL);
    }
}