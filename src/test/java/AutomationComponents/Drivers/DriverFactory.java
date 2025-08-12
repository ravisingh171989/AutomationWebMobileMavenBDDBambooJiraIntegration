/*
 *   Author: Anand Ravi
 *   https://www.linkedin.com/in/anandravisingh/
 *   https://github.com/ravisingh171989
 *   https://anand.github.io/
 *
 * */

package AutomationComponents.Drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import org.openqa.selenium.grid.Main;

public class DriverFactory {

	public static WebDriver initializeDriver(String browser) throws MalformedURLException, URISyntaxException {
		WebDriver driver = null;
		browser = System.getProperty("browser");
		String executionType = System.getProperty("executionType");
		String url = "http://localhost:4444/wd/hub";
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setBrowserName(browser);
		desiredCapabilities.setPlatform(Platform.ANY);
		URI uri = new URI(url);
		// Start Selenium Grid in standalone mode
		Main.main(new String[] { "standalone", "--port", "4445" });
		if (browser.equalsIgnoreCase("chrome")) {
			// Resolve driver for Selenium Grid
			WebDriverManager.chromedriver().setup();
			if (executionType.equalsIgnoreCase("remote")) {
				driver = WebDriverManager.chromedriver()
						.remoteAddress("http://localhost:4445/wd/hub").create();
				//driver = new RemoteWebDriver(uri.toURL(), desiredCapabilities);
			} else if (executionType.equalsIgnoreCase("local")) {
				driver = WebDriverManager.chromedriver().create();
			}
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if (executionType.equalsIgnoreCase("remote")) {
				driver = WebDriverManager.chromedriver()
						.remoteAddress("http://localhost:4445/wd/hub").create();
			} else if (executionType.equalsIgnoreCase("local")) {
				driver = WebDriverManager.firefoxdriver().create();
			}
		}
		driver.manage().window().maximize();
		return driver;
	}
}
