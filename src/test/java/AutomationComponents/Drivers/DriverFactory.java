/*
 *   Author: Anand Ravi
 *   https://www.linkedin.com/in/anandravisingh/
 *   https://github.com/ravisingh171989
 *   https://anand.github.io/
 *
 * */

package AutomationComponents.Drivers;

import AutomationComponents.Worlds.World;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.http.ClientConfig;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {
	World world;
	WebDriver driver;

	public DriverFactory(World world) {
		this.world = world;
	}

	public WebDriver initializeDriver(String browser, String executionType) throws MalformedURLException, URISyntaxException {
		DevTools devTools;
		String url = "http://192.168.1.108:4444/wd/hub";
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setBrowserName(browser);
		desiredCapabilities.setPlatform(Platform.ANY);
		URI uri = new URI(url);
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			if (executionType.equalsIgnoreCase("remote")) {
				ClientConfig config = ClientConfig.defaultConfig().connectionTimeout(Duration.ofMinutes(20))
						.readTimeout(Duration.ofMinutes(20)); // I change this 3 minute(Default) to 20 minutes.
				ChromeOptions options = new ChromeOptions();
				driver = RemoteWebDriver.builder().oneOf(desiredCapabilities).address(uri).config(config).build(); // now you can use this remoteWebDriver.
				//driver = new RemoteWebDriver(new URL(url), options);
				driver = new Augmenter().augment(driver);
				devTools = ((HasDevTools) driver).getDevTools();
				devTools.createSession();
			} else if (executionType.equalsIgnoreCase("local")) {
				driver = new ChromeDriver();
			}
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if (executionType.equalsIgnoreCase("remote")) {
				driver = new RemoteWebDriver(uri.toURL(), desiredCapabilities);
			} else if (executionType.equalsIgnoreCase("local")) {
				driver = new FirefoxDriver();
			}
		}
		driver.manage().window().maximize();
		return driver;
	}
}
