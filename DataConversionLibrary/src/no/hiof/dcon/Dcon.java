package no.hiof.dcon;

public class Dcon {
    protected Dcon() {
    }

    public String readFileAsString(String filename) {
        return null;
    }

    public String writeToFile(String fileName) {
        return null;
    }

    public static boolean isBothInSameObject(DconList list, String value1, String value2) {
        return false;
    }

    public void appendFileNewLine(String filename, String value) {
    }

    public double calculateAverageProperty(DconList list, String keyName) {
        return 0;
    }

    // Json
    public String deserializeJson(String fileName, Class className) {
        return null;
    }

    public DconObject createObjectFromJson(String fileName) {
        return null;
    }

    public static boolean validateJson(String fileName){
        return false;
    }

    public DconList deserializeJsonToList(String jsonString) {
        return null;
    }

    public Class createClassFromJson(String className, String jsonString) {
        return null;
    }

    // XML
    public String deserializeXml(String fileName, Class className) {
        return null;
    }

    public DconObject createObjectFromXml(String fileName) {
        return null;
    }

    public boolean validateXml(String fileName) {
        return false;
    }

    public DconList deserializeXmlToList(String jsonString) {
        return null;
    }

}
