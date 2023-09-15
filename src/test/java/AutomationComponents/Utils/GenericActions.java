package AutomationComponents.Utils;

import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class GenericActions {
    Properties properties;
    WebDriver driver = null;

    public GenericActions(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public void initBrowser( String siteURL ) {
        driver.get(Utils.getInstance(siteURL).getURL(siteURL));
    }
    public void readJsonFile(String filename) throws FileNotFoundException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(filename+".json");
    }
}