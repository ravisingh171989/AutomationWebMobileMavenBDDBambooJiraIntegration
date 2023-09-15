package AutomationComponents.Utils;

import AutomationComponents.ActionsClass.LoginActions;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class CommonSteps {
    WebDriver driver;
    GenericActions genericActions;

    public CommonSteps() {
        this.driver= driver;
        genericActions = new GenericActions(driver);
    }

    @When("I Anand developing the Automation Framework and launches a {string} site")
    public void iAnandDevelopingTheAutomationFrameworkAndLaunchesASite( String siteURL ) {
        genericActions.initBrowser(siteURL);
    }
}