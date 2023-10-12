/*
 *   Author: Anand Ravi
 *   https://www.linkedin.com/in/anandravisingh/
 *   https://github.com/ravisingh171989
 *   https://anand.github.io/
 *
 * */

package AutomationComponents.Drivers;

import AutomationComponents.ActionsClass.GenericActions;
import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

    private static GenericActions genericActions;

	public static GenericActions getGenericActions(WebDriver driver) {
		return genericActions == null ? new GenericActions(driver) : genericActions;
	}
}
