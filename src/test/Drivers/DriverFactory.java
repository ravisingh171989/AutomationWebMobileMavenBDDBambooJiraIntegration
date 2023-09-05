/*
 *   Author: Anand Ravi
 *   https://www.linkedin.com/in/anandravisingh/
 *   https://github.com/ravisingh171989
 *   https://anand.github.io/
 *
 * */

package Drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static Constants.FrameworkConstants.BROWSER_CHROME;
import static Constants.FrameworkConstants.BROWSER_FIREFOX;

public class DriverFactory {

	public static WebDriver initializeDriver(String browser) {
		WebDriver driver;

		switch (browser) {
			case BROWSER_CHROME: {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			}
			case BROWSER_FIREFOX: {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			}
			default:
				throw new IllegalStateException("INVALID BROWSER: " + browser);
		}
		driver.manage().window().maximize();
		return driver;
	}
}
