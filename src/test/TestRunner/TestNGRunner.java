/*
 *   Author: Anand Ravi
 *   https://www.linkedin.com/in/anandravisingh/
 *   https://github.com/ravisingh171989
 *   https://anand.github.io/
 *
 * */

package AutomationWebMobileMavenBDDBambooJiraIntegration.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {
                "html:target/cucumber/cucumber.html" ,
                "me.jvt.cucumber.report.PrettyReports:target/cucumber/"
        },
        glue = { "AutomationWebMobileMavenBDDBambooJiraIntegration" },
        features = "src/test/resources/features",
        //tags = "@Regression_Test")

public class TestNGRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
