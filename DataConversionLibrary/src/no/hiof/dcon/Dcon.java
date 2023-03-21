package no.hiof.dcon;

import org.w3c.dom.Document;
import java.util.ArrayList;

/**
 * A general class which has many methods for dataconversion with both Json And Xml.
 */
public class Dcon {
    protected Dcon() {
    }
    
    /**
     *  Reads a provided file and turns the result into a string.
     *  @param  filename  A string with the full name of a file. For example "file.txt"
     *  @return           A string with the contents of the file.
     */
    public static String readFileAsString(String filename) {
        return null;
    }

    /**
     * Checks if two values can be found in the same object in a Dcon list.
     * @param list      A DconList object which contains Dcon Objects with values.
     * @param value1    The first value to look for.
     * @param value2    The Second value to look for, if the first one exists.
     * @return          True or false, depending on whether both the values were found.
     */
    public static boolean isBothInSameObject(DconList list, String value1, String value2) {
        return false;
    }

    /**
     * Appends a file with a given string value.
     * @param filename  A string with the full name of a file. For example "file.txt"
     * @param value     The string value that shall be appended on a new line.
     */
    public void appendFileNewLine(String filename, String value) {
    }

    /**
     * Looks through a list and searches for a specific key. Takes the value for every key and finds the average.
     * @param list      A DconList object which contains Dcon Objects with keys and values.
     * @param keyName   The name of the key to find the value for.
     * @return          A double with the result of the average calculation.
     */
    public double calculateAverageProperty(DconList list, String keyName) {
        return 0;
    }

    // Json

    /**
     * Deserializes (also called decode) a file into a given class.
     * @param fileName      A string with the full name of a file. For example "file.txt"
     * @param <className>   The name of a class that you want to convert the file into.
     *                      Needs to have corresponding property values to the keys in the file.
     * @return              An object of the provided class.
     */
    public <className> Object deserializeJson(String fileName) {
        return null;
    }

    /**
     * Creates a general DconObject based on a Json file.
     * @param fileName  A string with the full name of a file. For example "file.txt"
     * @return  A DconObject instance with corresponding keys and values to the contents of the file.
     */
    public DconObject createObjectFromJson(String fileName) {
        return null;
    }

    /**
     * Writes a dcon object to a provided file in Json format.
     * @param fileName      The desired name of a file.
     * @param dconObject    The object you want to write to the file.
     */
    public void writeObjectToJsonFile(String fileName, DconObject dconObject) {
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

    /**
     * Writes a dcon object to a provided file in Xml format.
     * @param fileName      The desired name of a file.
     * @param dconObject    The object you want to write to the file.
     */
    public void writeObjectToXmlFile(String fileName, DconObject dconObject) {
    }

    public boolean validateXml(String fileName) {
        return false;
    }

    public DconList deserializeXmlToList(String jsonString) {
        return null;
    }


    /**
     * parseJsonToDcon() is the static method that will parse the JSON string and create a Dcon object using the Dcon.parseToObject() method.
     * @param jsonString    This represents the JSON string to be parsed into a DconObject.
     * @return              It will return a new instance of the DconObject class.("an instance is a unique object that is created based on that blueprint")
     */
    public DconObject parseJsonStringToDconObject(String jsonString) {

        return new DconObject();
    } // keep


    /**
     * "serializeToJSON() is the static method that will serialize the Dcon object to a JSON string using the builder.Serialize() method.
     * @param dconObject    This represents the data to be serialized to JSON.
     * @return              It return a JSON string representation of the input object.
     */
    public String serializeToJSON(DconObject dconObject){

        String jsonString = null;
        return jsonString;
    } // keep


    /**
     * "createDconJSONList() is the static method that will create a DconJSONList object.
     * The method takes an ArrayList of String objects as a parameter.
     * @param list  An "ArrayList" that represents the list of elements to be converted to a DconList object.
     * @return      The createDconListFromArrayList method takes an ArrayList of String objects as input,
     *              and returns a new instance of the DconList class.
     */
    public static DconList createDconListFromArrayList(ArrayList<String> list){
        return new DconList();
    } // maybe?


    /**
     * serializeDcon() is the static method that will serialize a Dcon object using the Dcon.JsonSerializer().serialize() method.
     * @param dconObject    This represents the data to be serialized to XML.
     * @return              It is intended to return an XML string representation of the input object.
     */
    public static String serializeToXml(DconObject dconObject){
        return null;
    }


    /**
     * createDconArrayList() is the static method that will create an ArrayList object of Dcon objects using the Dcon.ArrayList() method.
     * @return  It will return a new instance of the ArrayList class, which is a built-in Java class that
     *          represents a dynamically resizable array of objects.
     */
    public static ArrayList<Dcon> createDconArrayList(){
        return new ArrayList<>();
    } // maybe?


    /**
     * This code defines a public static method named convertJsonFileToList that takes a String parameter
     * named filename and returns a value of type DconList.
     * which is a list-like data structure used by the Dcon framework.
     * @param filename  A string with the full name of a file. For example "file.txt"
     * @return          Return the converted DconList object.
     */
    public static DconList convertJsonFileToList(String filename){
        return null;
    } // keep


    /**
     * The method should take a single parameter of type String,
     * which will represent the JSON string to be deserialized
     * @param jsonString    It represents a json string to be deserialized.
     * @return              Return the newly created DconList object. After Parse the JSON string into a JSON object using a JSON parsing library.
     *                      Extract the relevant information from the JSON object. Create a new DconList object with the extracted information.
     */
    public static DconList deserializeJsonStringToList(String jsonString){
        return null;
    } // keep


    /**
     * In this method, you can create a new JSONObject and populate it
     * with the data for the specified gender category.
     * @param dconObject    It represents the type of category for which a JSON object is requested.
     * @return              It is return JSON string can be returned by the getJSONObject method.
     */
    public static String getJSONObject(DconObject dconObject){
        return null;
    }


    /**
     * In this method, create a new DocumentBuilder object and use it
     * to parse the input XML file into a Document object.
     * @param inputFile     It represents the path to the input XML file.
     * @return              The Document object will be returned by the readXml method.
     */
    public static Document readXml(String inputFile){
        return null;
    }//think about it


    /**
     * In this method, call the getElementsByTagName method of the Document object,
     * passing in the tag name as the argument.
     * @param doc       That represents an HTML or XML document.
     * @param tagName   Represents the name of the tag to search for in the document.
     * @return          The result string can be returned by the getElementsByTag method.
     */
    public static String getElementsByTag(Document doc, String tagName){
        return null;
    }



    /**
     * In this method, call the toDconString method of the DconValue class and pass in the object as a parameter.
     * @param obj   An object.
     * @return      The resulting string can then be returned by the convertToDconString method.
     */
    public static String convertToDconString(Object obj) {

        return null;
    } // Needs to be looked at again. Not sure how it works.
}
