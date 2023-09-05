package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber/cucumber.html" ,
                "me.jvt.cucumber.report.PrettyReports:target/cucumber/"
        },
        glue = { "AutomationWebMobileMavenBDDBambooJiraIntegration/src/test" },
        features = "src/test/resources/features",
        tags = "@Regression_Test")
)
public class JunitRunner {
}
