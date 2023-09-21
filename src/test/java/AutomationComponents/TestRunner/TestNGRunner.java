/*
 *   Author: Anand Ravi
 *   https://www.linkedin.com/in/anandravisingh/
 *   https://github.com/ravisingh171989
 *   https://anand.github.io/
 *
 * */

package AutomationComponents.TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = { "/Users/anand/Desktop/Demoframeworks/AutomationWebMobileMavenBDDBambooJiraIntegration/src/test/java/AutomationComponents/StepDefinition" },
        plugin = {
                "html:target/cucumber/cucumber.html"
        },
        features = "/Users/anand/Desktop/Demoframeworks/AutomationWebMobileMavenBDDBambooJiraIntegration/src/test/resources/features",
        tags = "@Regression_Test"
        //monochrome=true,
        //dryRun=true
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
