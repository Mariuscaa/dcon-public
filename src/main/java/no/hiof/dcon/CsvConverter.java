package no.hiof.dcon;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to perform conversions with CSV format.
 */
public class CsvConverter {

    private CsvConverter() {
        throw new UnsupportedOperationException("CsvConverter is a utility class and should not be instantiated.");
    }

    /**
     * This method convert an object into Csv file
     *
     * @param object   The object to be converted
     * @param outputFileLocation The File name representing the file to which the objects should be written
     * @param <T>      The generic type of the object to be converted.
     * @throws IOException if there is an error writing to the file
     */
    public static <T> void csvFromObject(String outputFileLocation, T object) throws Exception {
        CsvMapper objectMapper = new CsvMapper();
        CsvSchema schema = objectMapper.schemaFor(object.getClass()).withHeader();
        File csvFile = new File(outputFileLocation);
        objectMapper.writer(schema).writeValue(csvFile, object);
    }

    /**
     * This method converts JSON content into a CSV file.
     *
     * @param outputFileLocation The location of the output CSV file.
     * @param input              The JSON content to be converted.
     * @param inputClass              The Class representing the type of objects in the JSON.
     * @param isFile             Specifies whether the input is a file path or a string.
     * @throws Exception if there is an error during conversion.
     * @param <T>   The generic type of the object to be converted.
     */
    public static <T> void csvFromJson(String outputFileLocation, String input, Class<T> inputClass, boolean isFile) throws Exception {
        Reader reader = isFile ? new FileReader(input) : new StringReader(input);
        ObjectMapper jsonMapper = new ObjectMapper();
        JsonNode jsonNode = jsonMapper.readTree(reader);

        List<T> list;
        if (jsonNode.isArray()) {
            String firstFieldName = jsonNode.fieldNames().next();
            JsonNode arrayNode = jsonNode.get(firstFieldName);

            CollectionType collectionType = jsonMapper.getTypeFactory().constructCollectionType(List.class, inputClass);
            list = jsonMapper.convertValue(arrayNode, collectionType);
        } else {
            T object = jsonMapper.treeToValue(jsonNode, inputClass);
            list = new ArrayList<>();
            list.add(object);
        }

        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = csvMapper.schemaFor(inputClass).withHeader();
        ObjectWriter writer = csvMapper.writer(schema);
        writer.writeValue(new File(outputFileLocation), list);
        reader.close();
    }

    /**
     * This method converts JSON content into a CSV file.
     *
     * @param outputFileLocation The location of the output CSV file.
     * @param input              The JSON content to be converted.
     * @param inputClass              The Class representing the type of objects in the JSON.
     * @throws Exception if there is an error during conversion.
     * @param <T>  The generic type of the object to be converted.
     */
    public static <T> void csvFromJson(String outputFileLocation, String input, Class<T> inputClass) throws Exception {
        csvFromJson(outputFileLocation, input, inputClass, true);
    }

    /**
     * This method converts YAML content into a CSV file.
     *
     * @param outputFileLocation The location of the output CSV file.
     * @param input              The YAML content to be converted.
     * @param inputClass         The Class representing the type of objects in the YAML.
     * @param isFile             Specifies whether the input is a file path or a string.
     * @throws Exception if there is an error during conversion.
     * @param <T>   The generic type of the object to be converted.
     */
    public static <T> void csvFromYaml(String outputFileLocation, String input, Class<T> inputClass, boolean isFile) throws Exception {
        Reader reader = isFile ? new FileReader(input) : new StringReader(input);
        ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = csvMapper.schemaFor(inputClass).withHeader();
        ObjectWriter writer = csvMapper.writer(schema);

        List<T> list;

        // If yaml starts with '-' it is an array.
        if (input.startsWith("-")) {
            CollectionType collectionType = yamlMapper.getTypeFactory().constructCollectionType(List.class, inputClass);
            list = yamlMapper.readValue(reader, collectionType);
        } else {
            T obj = yamlMapper.readValue(reader, inputClass);
            list = new ArrayList<>();
            list.add(obj);
        }

        writer.writeValue(new File(outputFileLocation), list);
        reader.close();
    }

    /**
     * This method converts YAML content into a CSV file.
     *
     * @param outputFileLocation The location of the output CSV file.
     * @param input              The YAML content to be converted.
     * @param inputClass         The Class representing the type of objects in the YAML.
     * @throws Exception if there is an error during conversion.
     * @param <T>  The generic type of the object to be converted.
     */
    public static <T> void csvFromYaml(String outputFileLocation, String input, Class<T> inputClass) throws Exception {
        csvFromYaml(outputFileLocation, input, inputClass, true);
    }

    /**
     * This method converts XML content into a CSV file.
     *
     * @param outputFileLocation The location of the output CSV file.
     * @param input              The XML content to be converted.
     * @param inputClass              The Class representing the type of objects in the XML.
     * @param isFile             Specifies whether the input is a file path or a string.
     * @throws Exception if there is an error during conversion.
     * @param <T>   The generic type of the object to be converted.
     */
    public static <T> void csvFromXml(String outputFileLocation, String input, Class<T> inputClass, boolean isFile) throws Exception {
        Reader reader = isFile ? new FileReader(input) : new StringReader(input);
        XmlMapper xmlMapper = new XmlMapper();
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = csvMapper.schemaFor(inputClass).withHeader();
        ObjectWriter writer = csvMapper.writer(schema);

        JsonNode node = xmlMapper.readTree(reader);

        List<T> list = new ArrayList<>();
        if (node.isArray()) {
            CollectionType collectionType = xmlMapper.getTypeFactory().constructCollectionType(List.class, inputClass);
            list = xmlMapper.convertValue(node, collectionType);
        } else {
            T object = xmlMapper.treeToValue(node, inputClass);
            list.add(object);
        }

        writer.writeValue(new File(outputFileLocation), list);
    }

    /**
     * This method converts XML content into a CSV file.
     *
     * @param outputFileLocation The location of the output CSV file.
     * @param input              The XML content to be converted.
     * @param inputClass              The Class representing the type of objects in the XML.
     * @throws Exception if there is an error during conversion.
     * @param <T> The generic type of the object to be converted.
     */
    public static <T> void csvFromXml(String outputFileLocation, String input, Class<T> inputClass) throws Exception {
        csvFromXml(outputFileLocation, input, inputClass, true); // Default value: isFile = true
    }

    /**
     * Merges multiple CSV files into a single CSV file.
     *
     * @param input             A list of file paths of the CSV files to be merged.
     * @param outputFileLocation The file path of the merged CSV output file.
     * @throws Exception if there is an error during merging.
     */
    public static void mergeCsvFiles(List<String> input, String outputFileLocation) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileLocation));
        for (String csvFile : input) {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            br.close();
        }
        bw.close();
    }
}
