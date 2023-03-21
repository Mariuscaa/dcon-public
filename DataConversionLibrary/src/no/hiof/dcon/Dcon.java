package no.hiof.dcon;

/**
 * A general class which has many methods for dataconversion with both Json And Xml.
 */
public class Dcon {
    protected Dcon() {
    }

    /**
     * Reads a provided file and turns the result into a string.
     * @param filename  A string with the full name of a file. For example "file.txt"
     * @return A string with the contents of the file.
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
     * @param keyName
     * @return
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


public String createObjectFromJson(jsonFileName){
    /**
     * is the method that will create the object from the JSON file.
     * You can replace the readFile() function with the appropriate code for reading the JSON file in your programming language
     */
    return null;
}

    public bool validateDcon(Dcon dconInstance){
        /**
         * "validateDcon() is the method that will validate the Dcon instance using the Dcon.validate() method.
         */
        return isValid;
    }

    public String parseJsonToDcon(jsonString) {
        /**
         * "parseJsonToDcon() is the static method that will parse the JSON string and create a Dcon object using the Dcon.parseToObject() method.
         */
        return dconObject;
    }

    public static String readFileAsString(String filePath){
        /**
         * "readFileAsString() is the static method that will read the file as a string using the Dcon.readFileAsString() method.
         */
        return fileContent;
    }

    public static Dcon DeserializeJsonToDcon(string jsonString){
        /**
         * "DeserializeJsonToDcon() is the static method that will deserialize the JSON string to a Dcon object using the Dcon.Deserializer() method.
         */
        return dconObject;
    }

    public String serializeToJSON(dconObject){
        /**
         * "serializeToJSON() is the static method that will serialize the Dcon object to a JSON string using the builder.Serialize() method.
         */
        return jsonString;
    }

    public static DconJSONList createDconJSONList(ArrayList<String> list){
        /**
         * "createDconJSONList() is the static method that will create a DconJSONList object.
         * The method takes an ArrayList of String objects as a parameter.
         */
        return dconJSONList;
    }

    public static WriterBuilder addAttributeToWriter(WriterBuilder writerBuilder, String attributeName, Object attributeValue){
        /**
         * "addAttributeToWriter() is the static method that will add a new attribute to a WriterBuilder object.
         */
        return writerBuilder;
    }

    public static String serializeDcon(Dcon dcon){
        /**
         * serializeDcon() is the static method that will serialize a Dcon object using the Dcon.JsonSerializer().serialize() method.
         */
        return serializedDcon;
    }

    public static ArrayList<Dcon> createDconArrayList(){
        /**
         * "createDconArrayList() is the static method that will create an ArrayList object of Dcon objects using the Dcon.ArrayList<>() method.
         */
        return dconArrayList;
    }

    public static void writeJsonStringToFile(String json, String filePath){
        /**
         * "writeJsonStringToFile() is the static method that will write a
         * JSON string to a file using the dcon.writeJsonToFile() method.
         * The method takes a JSON string and a file path as parameters.
         */
        writer.write(json);
        writer.close();
    }

    public static List<Object> convertJsonToList(String filename){

        return list;
    }

    public static double calculateAverageProperty(List<Object> list, String propertyName){
        /**
         * this method, iterate through the List of Objects and extract the property value for each object using
         * Java Reflection. Then, calculate the average of the property values.
         */
        return sum / count;
    }

    public static String readAsString(String filename){
        /**
         * The method should take a single parameter of type String,
         * which will represent the name of the JSON file to be read.
         */
        return content;
    }

    public static List<Object> deserializeToList(String jsonString){
        /**
         * The method should take a single parameter of type String,
         * which will represent the JSON string to be deserialized
         */
        return list;
    }

    public static JSONObject getJSONObject(String gender){
        /**
         * In this method, you can create a new JSONObject and populate it
         * with the data for the specified gender category.
         */
        return jsonObject;
    }

    public static Document parseXml(String xmlContent){
        /**
         * In this method, create a new DocumentBuilder object
         * and use it to parse the XML content into a Document object
         */
        return doc;
    }

    public static Document readXml(String inputFile){
        /**
         *  In this method, create a new DocumentBuilder object and use it
         *  to parse the input XML file into a Document object.
         */
        return doc;
    }

    public static Person createPerson(){
        /**
         * in this method, use Java reflection to create a new instance of
         * the Person class using the default constructor.
         */
        return (Person) constructor.newInstance();
    }

    public static Unmarshaller createUnmarshaller(Class<?> type){
        /**
         * in this method, create a new JAXBContext object for the specified class.
         */
        return unmarshaller;
    }

    public static void validateXml(String xmlFilePath){
        /**
         * in the method, create a new SchemaFactory object and use it to create a new
         * Schema object from an XML schema file or a schema source.
         */
        validator.validate(source);
    }

    public static void serializeToXml(Object object, String xmlFilePath){
        /**
         * in this method, create a new JAXBContext object for the object to be serialized.
         */
        marshaller.marshal(object, new File(xmlFilePath));
    }

    public static NodeList getElementsByTag(Document doc, String tagName){
        /**
         * in this method, call the getElementsByTagName method of the Document object,
         * passing in the tag name as the argument.
         */
        return nodeList;
    }

    public static StringBuilder createStringBuilder() {
        /**
         * in this method, create a new instance of the StringBuilder class and return it
         */
        return new StringBuilder();
    }

    public static String convertToDconString(Object obj) {
        /**
         * in this method, call the toDconString method of the DconValue class and pass in the object as a parameter.
         */
        return DconValue.toDconString(obj);
    }
}
