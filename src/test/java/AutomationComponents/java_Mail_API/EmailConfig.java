/*
 *   Author: Anand Ravi
 *   https://www.linkedin.com/in/anandravisingh/
 *   https://github.com/ravisingh171989
 *   https://anand.github.io/
 *
 * */
package AutomationComponents.java_Mail_API;

import static AutomationComponents.Constants.FrameworkConstants.PROJECT_NAME;

// To send report to emails after test executions
public class EmailConfig {

	//Server which is being user to send email
	public static final String SERVER = "smtp.gmail.com";
	public static final String PORT = "";

	public static final String FROM = "";
	public static final String PASSWORD = "";

	public static final String[] TO = { "" };
	public static final String SUBJECT = PROJECT_NAME;
}