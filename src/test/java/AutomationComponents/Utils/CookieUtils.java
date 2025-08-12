/*
 *   Author: Anand Ravi
 *   https://www.linkedin.com/in/anandravisingh/
 *   https://github.com/ravisingh171989
 *   https://anand.github.io/
 *
 * */

package AutomationComponents.Utils;

import io.restassured.http.Cookies;
import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookieUtils {

	/*Convert RestAssured Cookies -> Selenium Cookies*/
	public List<Cookie> convertRestAssuredCookiesToSeleniumCookies(Cookies cookies) {
		
		List<io.restassured.http.Cookie> restAssuredCookies;
		restAssuredCookies = cookies.asList();
		
		List<Cookie> seleniumCookies = new ArrayList<>();
		
		for (io.restassured.http.Cookie restAssuredCookie : restAssuredCookies) {
			seleniumCookies.add(
					new Cookie(restAssuredCookie.getName(), 
							restAssuredCookie.getValue(), 
							restAssuredCookie.getDomain(), 
							restAssuredCookie.getPath(),
							restAssuredCookie.getExpiryDate(), 
							restAssuredCookie.isSecured(), 
							restAssuredCookie.isHttpOnly(), 
							/*Present in Selenium 4.x*/
							restAssuredCookie.getSameSite()));
		}
		return seleniumCookies;
	}
}
