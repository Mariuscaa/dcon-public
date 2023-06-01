package no.hiof.dcon;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class is used to perform conversions with YAML data.
 */
public class YamlConverter {

    private YamlConverter() {
        throw new UnsupportedOperationException("YamlConverter is a utility class and should not be instantiated.");
    }

    /**
     * Deserializes YAML content from a file or a string into an object of the specified class.
     *
     * @param <T> the type of the desired object
     * @param inputClass the class of the desired object
     * @param input the YAML content to be deserialized; either a file path or a YAML string
     * @param isFile if true, treats 'input' as a file path; if false, treats 'input' as a YAML string
     * @return the deserialized object
     * @throws Exception if there is an error during deserialization
     */
    public static <T> T objectFromYaml(Class<T> inputClass, String input, boolean isFile) throws Exception {
        ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
        Reader reader = isFile ? new FileReader(input) : new StringReader(input);
        return yamlMapper.readValue(reader, inputClass);
    }

    /**
     * Deserializes YAML content from a file into an object of the specified class.
     *
     * @param <T> the type of the desired object
     * @param inputClass the class of the desired object
     * @param input the YAML content to be deserialized
     * @return the deserialized object
     * @throws Exception if there is an error during deserialization
     */
    public static <T> T objectFromYaml(Class<T> inputClass, String input) throws Exception {
        return objectFromYaml(inputClass, input, true);
    }

    /**
     * Creates a yaml file from an object.
     *
     * @param <T> the type of the object to be serialized
     * @param outputFileLocation the path of the file where the serialized YAML content should be written
     * @param object the object to be serialized
     * @throws Exception if there is an error during serialization or writing to the file
     * @throws UnsupportedOperationException if 'isFile' is false, as output to a string is not supported
     */
    public static <T> void yamlFromObject(String outputFileLocation, T object) throws Exception {
        File file = new File(outputFileLocation);
        ObjectMapper objectMapper = new YAMLMapper();
        objectMapper.writeValue(file, object);
    }

    /**
     * This method makes a yaml file from a json file.
     *
     * @param outputFileLocation The location of the output YAML file.
     * @param input              The JSON content to be converted.
     * @param isFile             Specifies whether the input is a file path or a string.
     * @throws Exception if there is an error during conversion.
     * @param <T>   The generic type of the object to be converted.
     */
    public static <T> void yamlFromJson(String outputFileLocation, String input, boolean isFile) throws Exception {
        Reader reader = isFile ? new FileReader(input) : new StringReader(input);
        ObjectMapper jsonMapper = new ObjectMapper();
        JsonNode jsonNode = jsonMapper.readTree(reader);
        ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
        yamlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        yamlMapper.writeValue(new File(outputFileLocation), jsonNode);
        reader.close();
    }

    /**
     * This method makes a yaml file from a json file.
     *
     * @param outputFileLocation The location of the output YAML file.
     * @param input              The JSON content to be converted.
     * @throws Exception if there is an error during conversion.
     * @param <T>  The generic type of the object to be converted.
     */
    public static <T> void yamlFromJson(String outputFileLocation, String input) throws Exception {
        yamlFromJson(outputFileLocation, input, true);
    }

    /**
     * This method converts CSV content into a YAML file.
     *
     * @param outputFileLocation The location of the output YAML file.
     * @param input              The CSV content to be converted.
     * @param inputClass              The Class representing the type of objects in the CSV.
     * @param isFile             Specifies whether the input is a file path or a string.
     * @throws Exception if there is an error during conversion.
     * @param <T>   The generic type of the object to be converted.
     */
    public static <T> void yamlFromCsv(String outputFileLocation, String input, Class<T> inputClass, boolean isFile) throws Exception {
        Reader reader = isFile ? new FileReader(input) : new StringReader(input);
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        ObjectReader oReader = csvMapper.readerFor(inputClass).with(schema);
        List<T> list = oReader.<T>readValues(reader).readAll();
        ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
        yamlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        yamlMapper.writeValue(new File(outputFileLocation), list);
        reader.close();
    }

    /**
     * This method converts CSV content into a YAML file.
     *
     * @param outputFileLocation The location of the output YAML file.
     * @param input              The CSV content to be converted.
     * @param inputClass         The Class representing the type of objects in the CSV.
     * @throws Exception if there is an error during conversion.
     * @param <T>  The generic type of the object to be converted.
     */
    public static <T> void yamlFromCsv(String outputFileLocation, String input, Class<T> inputClass) throws Exception {
        yamlFromCsv(outputFileLocation, input, inputClass, true);
    }

    /**
     * Converts XML input to YAML and writes the result to a file.
     * @param outputFileLocation the path of the output file to write the converted YAML to
     * @param input the XML input, which can be a file path or a string of XML data
     * @param inputClass the class of the objects that the XML input will be converted to
     * @param isFile a flag indicating whether the input is a file path ({@code true}) or a string of XML data ({@code false})
     * @param <T>   The generic type of the object to be converted.
     * @throws Exception if there is an error in reading the XML input, converting it to objects of the specified class,
     * or writing the output file
     */
    public static <T> void yamlFromXml(String outputFileLocation, String input, Class<T> inputClass, boolean isFile) throws Exception {
        Reader reader = isFile ? new FileReader(input) : new StringReader(input);
        XmlMapper xmlMapper = new XmlMapper();
        T object = xmlMapper.readValue(reader, inputClass);

        ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
        yamlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        yamlMapper.writeValue(new File(outputFileLocation), object);
        reader.close();
    }

    /**
     * This method converts XML content into a YAML file.
     *
     * @param outputFileLocation The location of the output YAML file.
     * @param input              The XML content to be converted.
     * @param inputClass         The Class representing the type of objects in the XML.
     * @throws Exception if there is an error during conversion.
     * @param <T> The generic type of the object to be converted.
     */
    public static <T> void yamlFromXml(String outputFileLocation, String input, Class<T> inputClass) throws Exception {
        yamlFromXml(outputFileLocation, input, inputClass, true);
    }


    /**
     * This method merges multiple YAML files into a single YAML file.
     *
     * @param input             The list of input YAML files to be merged.
     * @param outputFileLocation The location of the output merged YAML file.
     * @throws Exception if there is an error during merging.
     */
    public static void mergeYamlFiles(List<String> input, String outputFileLocation) throws Exception {
        Yaml yaml = new Yaml();
        List<Map<String, Object>> mergedData = new ArrayList<>();

        for (String yamlFile : input) {
            InputStream inputStream = new FileInputStream(yamlFile);
            List<Map<String, Object>> objs = yaml.load(inputStream);
            mergedData.addAll(objs);
        }

        FileWriter writer = new FileWriter(outputFileLocation);
        yaml.dump(mergedData, writer);
    }
}
