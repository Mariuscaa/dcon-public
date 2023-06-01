package no.hiof.dcon;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * This class is used to perform conversions with XML format.
 */
public class XmlConverter {

    private XmlConverter() {
        throw new UnsupportedOperationException("XmlConverter is a utility class and should not be instantiated.");
    }

    /**
     * This method deserializes XML content into an object of the specified class.
     *
     * @param inputClass  The Class representing the type of the object to be deserialized.
     * @param input  The XML content to be deserialized.
     * @param <T>    The generic type of the object to be converted.
     * @param isFile             Specifies whether the input is a file path or a string.
     * @return An object deserialized from the XML content.
     * @throws Exception if there is an error during deserialization.
     */
    public static <T> T objectFromXml(Class<T> inputClass, String input, boolean isFile) throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        Reader reader = isFile ? new FileReader(input) : new StringReader(input);
        return xmlMapper.readValue(reader, inputClass);
    }

    /**
     * This method deserializes XML file into an object of the specified class.
     *
     * @param inputClass  The Class representing the type of the object to be deserialized.
     * @param input  The XML content to be deserialized.
     * @param <T>    The generic type of the object to be converted.
     * @return An object deserialized from the XML content.
     * @throws Exception if there is an error during deserialization.
     */
    public static <T> T objectFromXml(Class<T> inputClass, String input) throws Exception {
        return objectFromXml(inputClass, input, true);
    }

    /**
     * This method serializes an object into an XML file.
     *
     * @param outputFileLocation The location of the output XML file.
     * @param object             The object to be serialized.
     * @param <T>                The generic type of the object to be converted.
     * @throws Exception if there is an error during serialization.
     */
    public static <T> void xmlFromObject(String outputFileLocation, T object) throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        String xmlString = xmlMapper.writeValueAsString(object);
        File file = new File(outputFileLocation);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(xmlString);
        writer.close();
    }

    /**
     * This method converts YAML content into an XML file.
     *
     * @param outputFileLocation The location of the output XML file.
     * @param input              The YAML content to be converted.
     * @param inputClass         The Class representing the type of objects in the YAML.
     * @param isFile             Specifies whether the input is a file path or a string.
     * @throws Exception if there is an error during conversion.
     * @param <T>   The generic type of the object to be converted.
     */
    public static <T> void xmlFromYaml(String outputFileLocation, String input, Class<T> inputClass, boolean isFile) throws Exception {
        Reader reader = isFile ? new FileReader(input) : new StringReader(input);
        ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
        List<T> object = yamlMapper.readValue(reader, yamlMapper.getTypeFactory().constructCollectionType(List.class, inputClass));
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.writeValue(new File(outputFileLocation), object);
        reader.close();
    }

    /**
     * This method converts YAML content into an XML file.
     *
     * @param outputFileLocation The location of the output XML file.
     * @param input              The YAML content to be converted.
     * @param inputClass         The Class representing the type of objects in the YAML.
     * @throws Exception if there is an error during conversion.
     * @param <T>  The generic type of the object to be converted.
     */
    public static <T> void xmlFromYaml(String outputFileLocation, String input, Class<T> inputClass) throws Exception {
        xmlFromYaml(outputFileLocation, input, inputClass, true);
    }

    /**
     * This method converts CSV content into an XML file.
     *
     * @param outputFileLocation The location of the output XML file.
     * @param input              The CSV content to be converted.
     * @param inputClass         The Class representing the type of objects in the CSV.
     * @param isFile             Specifies whether the input is a file path or a string.
     * @throws Exception if there is an error during conversion.
     * @param <T>   The generic type of the object to be converted.
     */
    public static <T> void xmlFromCsv(String outputFileLocation, String input, Class<T> inputClass, boolean isFile) throws Exception {
        Reader reader = isFile ? new FileReader(input) : new StringReader(input);
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        ObjectReader oReader = csvMapper.readerFor(inputClass).with(schema);
        List<T> list = oReader.<T>readValues(reader).readAll();
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.writeValue(new File(outputFileLocation), list);
        reader.close();
    }

    /**
     * This method converts JSON content into an XML file.
     *
     * @param outputFileLocation The location of the output XML file.
     * @param input              The JSON content to be converted.
     * @param isFile             Specifies whether the input is a file path or a string.
     * @throws Exception if there is an error during conversion.
     * @param <T>   The generic type of the object to be converted.
     */
    public static <T> void xmlFromJson(String outputFileLocation, String input,  boolean isFile) throws Exception {
        Reader reader = isFile ? new FileReader(input) : new StringReader(input);
        ObjectMapper jsonMapper = new ObjectMapper();
        JsonNode jsonNode = jsonMapper.readTree(reader);
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String xmlString = xmlMapper.writeValueAsString(jsonNode);
        Files.write(Paths.get(outputFileLocation), xmlString.getBytes());
        reader.close();
    }

    /**
     * This method makes an XML file from a JSON file.
     *
     * @param outputFileLocation The location of the output XML file.
     * @param input              The JSON content to be converted.
     * @throws Exception if there is an error during conversion.
     * @param <T>  The generic type of the object to be converted.
     */
    public static <T> void xmlFromJson(String outputFileLocation, String input) throws Exception {
        xmlFromJson(outputFileLocation, input, true);
    }



    /**
     * Validates the structure of an XML file or string.
     *
     * @param input The file name of the XML file to be validated.
     * @param isFile Specifies whether the input is a file path or a string.
     * @return true if the XML is valid, false otherwise.
     */
    public static boolean validateXml(String input, boolean isFile) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            if (isFile) {
                docBuilder.parse(new File(input));
            } else {
                docBuilder.parse(input);
            }
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * Validates the structure of an XML file.
     *
     * @param input The file name of the XML file to be validated.
     * @return true if the XML is valid, false otherwise.
     */
    public static boolean validateXml(String input) {
        return validateXml(input, true);
    }

    /**
     * Merges multiple XML files into a single XML file.
     *
     * @param input             A list of file paths of the XML files to be merged.
     * @param outputFileLocation The file path of the merged XML output file.
     * @throws Exception if there is an error during merging.
     */
    public static void mergeXmlFiles(List<String> input, String outputFileLocation) throws Exception{
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();

        Document mergedDoc = docBuilder.newDocument();
        Element rootElement = mergedDoc.createElement("root");
        mergedDoc.appendChild(rootElement);

        for (String xmlFile : input) {
            Document doc = docBuilder.parse(new File(xmlFile));
            Element root = doc.getDocumentElement();
            Node importedNode = mergedDoc.importNode(root, true);
            rootElement.appendChild(importedNode);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource dbSource = new DOMSource(mergedDoc);
        StreamResult result = new StreamResult(new File(outputFileLocation));
        transformer.transform(dbSource, result);
    }
}
