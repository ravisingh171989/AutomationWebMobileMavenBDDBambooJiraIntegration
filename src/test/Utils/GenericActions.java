public class GenericActions {
    public void readJsonFile(String filename) {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(filename+".json");
    }
}