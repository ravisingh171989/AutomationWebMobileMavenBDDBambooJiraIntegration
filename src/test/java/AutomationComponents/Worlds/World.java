/*
 *   Author: Anand Ravi
 *   https://www.linkedin.com/in/anandravisingh/
 *   https://github.com/ravisingh171989
 *   https://anand.github.io/
 *
 * */

package AutomationComponents.Worlds;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class World {
    public WebDriver driver;

    public World() throws IOException {
    }

    public WebDriver getDriver() {
        return driver;
    }
}
