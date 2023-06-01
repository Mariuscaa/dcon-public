package no.hiof.dcon;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to perform conversions with JSON format.
 */
public class JsonConverter {

    private JsonConverter() {
        throw new UnsupportedOperationException("JsonConverter is a utility class and should not be instantiated.");
    }

    /**
     * This method deserializes JSON content into an object of the specified class.
     *
     * @param inputClass  The Class representing the type of the object to be deserialized.
     * @param input  The JSON content to be deserialized.
     * @param isFile Specifies whether the input is a file path or a string.
     * @param <T>    The generic type of the object to be converted.
     * @return An object deserialized from the JSON content.
     * @throws Exception if there is an error during deserialization.
     */
    public static <T> T objectFromJson(Class<T> inputClass, String input, boolean isFile) throws Exception {
        Gson gson = new GsonBuilder().setLenient().create();
        Reader reader = isFile ? new FileReader(input) : new StringReader(input);
        T object = gson.fromJson(reader, inputClass);
        reader.close();
        return object;
    }



    /**
     * This method deserializes JSON content into an object of the specified class.
     *
     * @param inputClass  The Class representing the type of the object to be deserialized.
     * @param input  The JSON content to be deserialized.
     * @param <T>    The generic type of the object to be converted.
     * @return An object deserialized from the JSON content.
     * @throws Exception if there is an error during deserialization.
     */
    public static <T> T objectFromJson(Class<T> inputClass, String input) throws Exception {
        return objectFromJson(inputClass, input, true);
    }

    /**
     * This method serializes an object into a JSON file.
     *
     * @param outputFileLocation The location of the output JSON file.
     * @param object             The object to be serialized.
     * @param <T>                The generic type of the object to be converted.
     * @throws Exception if there is an error during serialization.
     */
    public static <T> void jsonFromObject(String outputFileLocation, T object) throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(object);
        FileWriter writer = new FileWriter(outputFileLocation);
        writer.write(json);
        writer.close();
    }

    /**
     * This method converts YAML content into a JSON file.
     *
     * @param outputFileLocation The location of the output JSON file.
     * @param input              The YAML content to be converted.
     * @param isFile             Specifies whether the input is a file path or a string.
     * @throws Exception if there is an error during conversion.
     * @param <T>      The generic type of the object to be converted.
     */
    public static <T> void jsonFromYaml(String outputFileLocation, String input, boolean isFile) throws Exception {
        Reader reader = isFile ? new FileReader(input) : new StringReader(input);
        ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
        JsonNode jsonNode = yamlMapper.readTree(reader);
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
        jsonMapper.writeValue(new File(outputFileLocation), jsonNode);
    }

    /**
     * This method converts YAML content into a JSON file.
     *
     * @param outputFileLocation The location of the output JSON file.
     * @param input              The YAML content to be converted.
     * @throws Exception if there is an error during conversion.
     * @param <T>     The generic type of the object to be converted.
     */
    public static <T> void jsonFromYaml(String outputFileLocation, String input) throws Exception {
        jsonFromYaml(outputFileLocation, input, true);
    }

    /**
     * This method converts XML input into JSON output.
     *
     * @param <T> The generic type of the object to be converted.
     * @param outputFileLocation The file location where the JSON output should be written to.
     * @param input The input which is either XML string or the path to a XML file.
     * @param isFile A boolean flag indicating whether the input is a file path (if true) or a XML string (if false).
     * @throws Exception If an error occurs during reading the input or writing to the output.
     */
    public static <T> void jsonFromXml(String outputFileLocation, String input, boolean isFile) throws Exception {
        Reader reader = isFile ? new FileReader(input) : new StringReader(input);
        XmlMapper xmlMapper = new XmlMapper();
        JsonNode jsonNode = xmlMapper.readTree(reader);
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
        jsonMapper.writeValue(new File(outputFileLocation), jsonNode);
    }

    /**
     * This method converts XML input into JSON output.
     *
     * @param <T> The type of the input object.
     * @param outputFileLocation The file location where the JSON output should be written to.
     * @param input The input which is either a XML string or the path to a XML file.
     * @throws Exception If an error occurs during reading the input or writing to the output.
     */
    public static <T> void jsonFromXml(String outputFileLocation, String input) throws Exception {
        jsonFromXml(outputFileLocation, input, true); // Default value: isFile = true
    }

    /**
     * This method converts CSV content into a JSON file.
     *
     * @param outputFileLocation The location of the output JSON file.
     * @param input              The CSV content to be converted.
     * @param inputClass         The Class representing the type of objects in the CSV.
     * @param isFile             Specifies whether the input is a file path or a string.
     * @throws Exception if there is an error during conversion.
     * @param <T>   The generic type of the object to be converted.
     */
    public static <T> void jsonFromCsv(String outputFileLocation, String input, Class<T> inputClass, boolean isFile) throws Exception {
        Reader reader = isFile ? new FileReader(input) : new StringReader(input);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
        List<T> list = new ArrayList<>();
        Gson gson = new Gson();
        for (CSVRecord record : records) {
            String json = gson.toJson(record.toMap());
            T obj = gson.fromJson(json, inputClass);
            list.add(obj);
        }
        Writer writer = new FileWriter(outputFileLocation);
        gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(list, writer);
        writer.close();
    }

    /**
     * This method converts CSV content into a JSON file.
     *
     * @param outputFileLocation The location of the output JSON file.
     * @param input              The CSV content to be converted.
     * @param inputClass         The Class representing the type of objects in the CSV.
     * @throws Exception if there is an error during conversion.
     * @param <T>  The generic type of the object to be converted.
     */
    public static <T> void jsonFromCsv(String outputFileLocation, String input, Class<T> inputClass) throws Exception {
        jsonFromCsv(outputFileLocation, input, inputClass, true);
    }

    /**
     * Validates the structure of a JSON file.
     *
     * @param input  The input/content which you want to validate. Can be either a string or the name of a file.
     * @param isFile A boolean which indicates whether the input is a file or a string.
     * @return true or false, depending on whether the input was valid or not.
     */
    public static boolean validateJson(String input, boolean isFile) {
        try {
            Gson gson = new Gson();
            Reader reader = isFile ? new FileReader(input) : new StringReader(input);
            JsonElement jsonElement = gson.fromJson(reader, JsonElement.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Validates the structure of a JSON file.
     *
     * @param input The input/content which you want to validate. Can be either a string or the name of a file.
     * @return true or false, depending on whether the input was valid or not.
     */
    public static boolean validateJson(String input) {
        return validateJson(input, true);
    }

    /**
     * Merges multiple JSON files into a single JSON file.
     *
     * @param input             A list of file paths of the JSON files to be merged.
     * @param outputFileLocation The file path of the merged JSON output file.
     * @throws Exception if there is an error during merging.
     */
    public static void mergeJsonFiles(List<String> input, String outputFileLocation) throws Exception {
        JSONArray mergedJson = new JSONArray();
        String rootKey = null;
        for (String jsonFile : input) {
            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFile)));

            JSONObject wholeJsonObject = new JSONObject(jsonContent);

            rootKey = wholeJsonObject.keys().next();

            JSONArray jsonArray = wholeJsonObject.getJSONArray(rootKey);

            for(int i = 0; i < jsonArray.length(); i++){
                mergedJson.put(jsonArray.get(i));
            }
        }

        JSONObject outputObject = new JSONObject();
        outputObject.put(rootKey, mergedJson);

        try (FileWriter file = new FileWriter(outputFileLocation)) {
            file.write(outputObject.toString());
        }
    }
}
