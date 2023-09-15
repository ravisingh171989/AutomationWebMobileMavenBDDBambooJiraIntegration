package AutomationComponents.Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static AutomationComponents.Constants.FrameworkConstants.DIRECTORY_ENV_CONFIG;
import static AutomationComponents.Constants.FrameworkConstants.PARAMETER_ENV;

public class Utils {
    private static final String SEND_EMAIL_TO_USERS = "send_email_to_users";

    // private final Properties properties;
    private Properties properties;

    private static Utils utils;

    private Utils() {
        /**
         * Setting the Environment Parameter here.
         *
         * By default, Stage will be taken
         */
        properties = propertyReader(DIRECTORY_ENV_CONFIG + PARAMETER_ENV+"/config.properties");
    }

    public static Utils getInstance(String URL) {
        if (utils == null) {
            utils = new Utils();
        }
        return utils;
    }

    public String getSendEmailToUsers() {
        return getPropertyValue(SEND_EMAIL_TO_USERS);
    }

    public static Properties propertyReader(String filePath) {
        Properties properties = new Properties();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("failed to load properties file " + filePath);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("properties file not found at " + filePath);
        }
        return properties;
    }

    private String getPropertyValue(String propertyKey) {
        String prop = properties.getProperty(propertyKey);
        if (prop != null) {
            return prop.trim();
        } else {
            throw new RuntimeException("Property " + propertyKey + " is not specified in the config.properties file");
        }
    }

    public String getURL(String URL) {
        String url = properties.getProperty(URL+".url");
        return url;
    }
}
