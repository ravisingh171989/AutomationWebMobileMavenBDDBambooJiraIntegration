package AutomationComponents.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        tags = "",
        features = "@target/TestFailedScenarios/failedrerun.txt",
        glue = { "AutomationComponents.Hooks","AutomationComponents/StepDefinition" },
        plugin = {
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "pretty",
                "json:target1/cucumber-reports/cucumber.json",
                "html:target1/cucumber-reports/cucumber.html"}
)
public class TestNGRunnerRerunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
