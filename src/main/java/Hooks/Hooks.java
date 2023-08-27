/*
*   Author: Anand Ravi
*   https://www.linkedin.com/in/anandravisingh/
*   https://github.com/ravisingh171989
*   https://anand.github.io/
*
* */

package Hooks;

import static Constants.FrameworkConstants.*;

import Drivers.DriverFactory;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;

    public Hooks() {
    }

    @Before
    public void before(Scenario scenario) {
        System.out.println(
                "BEFORE: THREAD ID : " + Thread.currentThread().getId() + "," + "SCENARIO NAME: " + scenario.getName());
        driver = DriverFactory.initializeDriver(System.getProperty(PARAMETER_BROWSER, BROWSER_CHROME));
    }

    @After
    public void after(Scenario scenario) {
        System.out.println(
                "AFTER: THREAD ID : " + Thread.currentThread().getId() + "," + "SCENARIO NAME: " + scenario.getName());
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