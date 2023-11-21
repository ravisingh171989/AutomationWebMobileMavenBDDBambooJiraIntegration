/*
 *   Author: Anand Ravi
 *   https://www.linkedin.com/in/anandravisingh/
 *   https://github.com/ravisingh171989
 *   https://anand.github.io/
 *
 * */

package AutomationComponents.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        glue = { "AutomationComponents.Hooks","AutomationComponents/StepDefinition" },
        plugin = {
                "pretty",
                "json:target/cucumber.json"
        },
        features = "src/test/resources/features",
        tags = "@Regression_Test",
        monochrome=true
)

public class TestNGRunner extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
