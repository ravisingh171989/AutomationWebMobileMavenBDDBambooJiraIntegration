package AutomationComponents.Utils;

import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class GenericActions {
    Properties properties;
    protected WebDriver driver;

    public GenericActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void launchURL( String siteURL ) {
        driver.get(Utils.getInstance().getURL("test"));
    }
    public void readJsonFile(String filename) throws FileNotFoundException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(filename+".json");
    }
}