package AutomationComponents.Utils;

import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class GenericActions {
    Properties properties;
    private WebDriver driver;

    public GenericActions(WebDriver driver) {
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