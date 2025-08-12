import AutomationComponents.ActionsClass.GenericActions;
import AutomationComponents.Drivers.PageFactoryManager;
import AutomationComponents.Worlds.World;
import io.cucumber.java.en.Given;

public class CommonStepsAPI {

    private final World world;
    private final GenericActions genericActions;

    public CommonStepsAPI(World world) {
        this.world = world;
        genericActions = PageFactoryManager.getGenericActions(world.driver);
    }

    @Given("Run the API from restassured tool")
    public void runTheAPIFromRestassuredTool() {
    }
}
