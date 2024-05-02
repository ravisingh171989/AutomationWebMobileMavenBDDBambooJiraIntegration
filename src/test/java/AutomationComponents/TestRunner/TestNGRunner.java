package AutomationComponents.TestRunner;

import io.cucumber.core.plugin.RerunFormatter;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        glue = { "AutomationComponents.Hooks","AutomationComponents/StepDefinition" },
        plugin = {
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "pretty",
                "json:target/cucumber.json",
                "html:target/cucumber.html",
                "rerun:target/TestFailedScenarios/failedrerun.txt"
        },
        tags = "@Regression_Test2",
        features = "src/test/resources/features"
)

public class TestNGRunner extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
