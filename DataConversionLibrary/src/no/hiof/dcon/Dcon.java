/**
 * The main namespace for Dcon. Contains classes and methods for basic data handling. Most used class here is Dcon.
 */
package no.hiof.dcon;

import org.w3c.dom.Document;
import java.util.ArrayList;

/**
 * A general class which has many methods for data conversion with both Json And Xml.
 */
public class Dcon {
    /**
     * Constructor is protected because instances should be created through DconFactory.create().
     */
    protected Dcon() {
    }
    // Methods without connection to data type.
    /**
     *  Reads a provided file and turns the result into a string.
     *  @param  filename  A string with the full name of a file. For example "file.txt".
     *  @return           A string with the contents of the file.
     */
    public String readFileAsString(String filename) {
        return null;
    }

    /**
     * Checks if two values can be found in the same object in a Dcon list.
     * @param list      A DconList object which contains Dcon Objects with values.
     * @param value1    The first value to look for.
     * @param value2    The Second value to look for, if the first one exists.
     * @return          True or false, depending on whether both the values were found.
     */
    public boolean isBothInSameObject(DconList list, String value1, String value2) {
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

    /**
     * createDconJSONList() is the static method that will create a DconJSONList object.
     * The method takes an ArrayList of String objects as a parameter.
     * @param list  An "ArrayList" that represents the list of elements to be converted to a DconList object.
     * @return      The createDconListFromArrayList method takes an ArrayList of String objects as input,
     *              and returns a new instance of the DconList class.
     */
    public DconList createDconListFromArrayList(ArrayList<String> list){
        return null;
    } // maybe?

    // Json related methods
    /**
     * Deserializes (also called decode) a file into a given class.
     * Class and file need to have corresponding properties/keys
     * @param fileName      A string with the full name of a file. For example "file.txt"
     * @param clazz         The full name of a class.
     * @return              An object of the provided class.
     * @param <T>           The class you want to create an object of.
     */
    public <T> T deserializeJsonFileToObject(String fileName, Class<T> clazz) {
        return null;
    }


    /**
     * parseJsonToDcon() is the static method that will parse the JSON string and create a Dcon object using the Dcon.parseToObject() method.
     * @param jsonString    This represents the JSON string to be parsed into a DconObject.
     * @return              It will return a new instance of the DconObject class.("an instance is a unique object that is created based on that blueprint")
     */
    public DconObject deserializeJsonStringToDconObject(String jsonString) {
        return DconObject.create();
    } // keep

    /**
     * Creates a general DconObject based on a Json file.
     * @param fileName  A string with the full name of a file. For example "file.txt"
     * @return  A DconObject instance with corresponding keys and values to the contents of the file.
     */
    public DconObject deserializeJsonFileToDconObject(String fileName) {
        return null;
    }

    /**
     * Deserializes a jsonString into a DconList object.
     * @param jsonString    The string with the json data that you want to deserialize.
     * @return              A DconList object with the values from the json string.
     */
    public DconList deserializeJsonToList(String jsonString) {
        return null;
    }

    /**
     * This method takes a String parameter named filename and returns a value of type DconList.
     * which is a list-like data structure used by the Dcon library.
     * @param filename  A string with the full name of a file. For example "file.txt"
     * @return          Return the converted DconList object.
     */
    public DconList deserializeJsonFileToDconList(String filename){
        return null;
    } // keep

    /**
     * The method should take a single parameter of type String,
     * which will represent the JSON string to be deserialized
     * @param jsonString    It represents a json string to be deserialized.
     * @return              Return the newly created DconList object. After Parse the JSON string into a JSON object using a JSON parsing library.
     *                      Extract the relevant information from the JSON object. Create a new DconList object with the extracted information.
     */
    public DconList deserializeJsonStringToDconList(String jsonString){
        return null;
    } // keep

    /**
     * Validates the structure of a json file.
     * @param fileName  The name of the file you want to validate.
     * @return          true or false, depending on whether the file was valid or not.
     */
    public boolean validateJson(String fileName){
        return false;
    }

    /**
     * Creates a new class based on the structure of the keys in a json string.
     * @param className     The name of the new class which will be created.
     * @param jsonString    A string with json data which will be used to determine the properties of the class.
     * @return              A new class.
     */
    public Class createClassFromJson(String className, String jsonString) {
        return null;
    }

    /**
     * serializeToJSON() is a method that will serialize the Dcon object to a JSON string using the builder.Serialize() method.
     * @param dconObject    This represents the data to be serialized to JSON.
     * @return              It return a JSON string representation of the input object.
     */
    public String convertDconObjectToJsonString(DconObject dconObject){
        return null;
    }

    /**
     * In this method, you can write a DconObject into a specified file with json format.
     * @param fileName      A string with the desired name of the output file.
     * @param dconObject    It represents the type of category for which a JSON object is requested.
     */
    public void writeDconObjectToJsonFile(String fileName, DconObject dconObject){
    }

    /**
     * Takes an object and writes it to a file with Json format.
     * @param fileName  A string with the name of the file you want to create.
     * @param object    The object with the data you want to write out.
     */
    public void writeObjectToJsonFile(String fileName, Object object){
    }

    // XML
    /**
     * Deserializes an Xml file into an object of a corresponding class.
     * Needs to have the same properties in both class and file.
     * @param fileName  The name of an Xml file.
     * @param clazz     A complete class name of an existing class. For example Person.class.
     * @return          An object of the given class.
     * @param <T>       The class which shall be deserialized into.
     */
    public <T> T deserializeXmlToObject(String fileName, Class<T> clazz) {
        return null;
    }

    /**
     * Creates a new DconObject based on an Xml file.
     * @param fileName  Name of the Xml file.
     * @return          A DconObject with the properties and values from the file.
     */
    public DconObject createDconObjectFromXml(String fileName) {
        return null;
    }

    /**
     * Writes a dcon object to a provided file in Xml format.
     * @param fileName      The desired name of a file.
     * @param dconObject    The object you want to write to the file.
     */
    public void writeObjectToXmlFile(String fileName, DconObject dconObject) {
    }

    /**
     * Validates the format of an XML file.
     * @param fileName  The name of a file.
     * @return          true or false, depending on whether the file was valid or not.
     */
    public boolean validateXml(String fileName) {
        return false;
    }

    /**
     * Deserializes an Xml string into a DconList.
     * @param xmlString    A string with Xml data
     * @return              A DconList with the corresponding data.
     */
    public DconList deserializeXmlStringToList(String xmlString) {
        return null;
    }

    /**
     * serializeDcon() is a method that will serialize a Dcon object using the Dcon.JsonSerializer().serialize() method.
     * @param dconObject    This represents the data to be serialized to XML.
     * @return              It is intended to return an XML string representation of the input object.
     */
    public String serializeDconObjectToXmlString(DconObject dconObject){
        return null;
    }

    /**
     * In this method, create a new DocumentBuilder object and use it
     * to parse the input XML file into a Document object.
     * @param inputFile     It represents the path to the input XML file.
     * @return              The Document object will be returned by the readXml method.
     */
    public Document readXmlAsDocument(String inputFile){
        return null;
    }//think about it

    /**
     * In this method, call the getElementsByTagName method of the Document object,
     * passing in the tag name as the argument.
     * @param doc       That represents an HTML or XML document.
     * @param tagName   Represents the name of the tag to search for in the document.
     * @return          The result string can be returned by the getElementsByTag method.
     */
    public String getElementsByTag(Document doc, String tagName){
        return null;
    }

    /**
     * In this method, call the toDconString method of the DconValue class and pass in the object as a parameter.
     * @param obj   An object.
     * @return      The resulting string can then be returned by the convertToDconString method.
     */
    public String convertToDconString(Object obj) {

        return null;
    } // Needs to be looked at again. Not sure how it works.
}
