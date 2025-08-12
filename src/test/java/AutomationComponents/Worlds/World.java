/*
 *   Author: Anand Ravi
 *   https://www.linkedin.com/in/anandravisingh/
 *   https://github.com/ravisingh171989
 *   https://anand.github.io/
 *
 * */

package AutomationComponents.Worlds;

import AutomationComponents.DomainSpecific.Cookies;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class World {
    public WebDriver driver;
    public Cookies cookies;

    public World() throws IOException {
        cookies = new Cookies();
        cookies.setCookies(new io.restassured.http.Cookies());
    }

    public WebDriver getDriver() {
        return driver;
    }
}
