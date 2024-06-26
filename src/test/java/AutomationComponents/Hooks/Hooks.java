/*
*   Author: Anand Ravi
*   https://www.linkedin.com/in/anandravisingh/
*   https://github.com/ravisingh171989
*   https://anand.github.io/
*
* */

package AutomationComponents.Hooks;

import static AutomationComponents.Constants.FrameworkConstants.*;
import AutomationComponents.Drivers.DriverFactory;
import AutomationComponents.Worlds.World;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.*;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.logging.Logger;
import static AutomationComponents.Constants.FrameworkConstants.PARAMETER_BROWSER;
import static AutomationComponents.Constants.FrameworkConstants.PARAMETER_EXECUTIONTYPE;

public class Hooks {
    World world;
    WebDriver driver;
    Logger LOG;

    public Hooks(World world) {
        this.world = world;
    }

    @Before
    public void before(Scenario scenario) throws MalformedURLException, URISyntaxException {
        System.out.println("BEFORE: THREAD ID : " + Thread.currentThread().threadId() + "," + "SCENARIO NAME: " + scenario.getName());
        driver = DriverFactory.initializeDriver(System.getProperty(PARAMETER_BROWSER),System.getProperty(PARAMETER_EXECUTIONTYPE));
        world.driver = driver;
    }

    @After
    public void after(Scenario scenario) {
        System.out.println("AFTER: THREAD ID : " + Thread.currentThread().getId() + "," + "SCENARIO NAME: " + scenario.getName());
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        driver.quit();
    }

    @BeforeAll
    public static void beforeAll() {
    }
    @AfterAll
    public static void afterAll() {
    }
}
