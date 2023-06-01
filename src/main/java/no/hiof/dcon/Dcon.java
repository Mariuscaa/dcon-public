package no.hiof.dcon;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * Use Dcon.create() to make an object of this class.
 * This is the main Dcon class which has many methods for data conversion with both Json and Xml.
 * <p>Here is an example of how the class can be instantiated and used:
 *
 * <pre>
 * Dcon dcon = Dcon.create();
 * String jsonString = dcon.stringFromFile("test.json");
 * </pre>
 */
public class Dcon {

    /**
     * Creates a new instance of Dcon.
     * @return A new instance of Dcon.
     */
    public static Dcon create() {
        return new Dcon();
    }

    /**
     * The {@code DataType} enum represents various types of data formats that are commonly used.
     */
    public enum DataType {
        /**
         * JavaScript Object Notation (JSON) is a lightweight data-interchange format that is easy for humans to read and write and easy for machines to parse and generate.
         */
        JSON,

        /**
         * eXtensible Markup Language (XML) is a markup language that defines a set of rules for encoding documents in a format that is both human-readable and machine-readable.
         */
        XML,

        /**
         * YAML Ain't Markup Language (YAML) is a human-friendly data serialization standard for all programming languages.
         */
        YAML,
    }
    /**
     * The constructor is protcted to prevent direct instantiation of this class.
     * Use Dcon.create() to make an object of this class.
     */
    protected Dcon() {

    }

    /**
     * Reads a provided file and turns the result into a string.
     *
     * @param fileName A string with the full name of a file. For example "file.txt".
     * @return A string with the contents of the file.
     * @throws IOException Throws an exception if the file is not found.
     */
    public String stringFromFile(String fileName) throws IOException {
        return Files.lines(Paths.get(fileName), StandardCharsets.UTF_8)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    /**
     * Appends a file with a given string value.
     *
     * @param value    The string value that shall be appended on a new line.
     * @param filename A string with the full name of a file. For example "file.txt"
     * @throws IOException Throws exception if file does not exist.
     */
    public void appendNewLineToFile(String value, String filename) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename, true))) {
            out.println(value);
        }
    }

    /**
     * Converts data from the source type to the target type and saves it to the outputFileLocation.
     * And only support these operations i.e. xmlFromJson, yamlFromJson, jsonFromYaml and jsonFromXml.
     * @param sourceType         The source data type.
     * @param targetType         The target data type.
     * @param input              The input data to be converted.
     * @param outputFileLocation The location of the output file.
     * @param isFlag             Specifies whether the input data is a file path or a string.
     */
    public void convertData(DataType sourceType, DataType targetType, String input, String outputFileLocation, boolean isFlag) {
        try
        {
            switch (sourceType) {
                case JSON:
                    switch (targetType) {
                        case XML -> XmlConverter.xmlFromJson(outputFileLocation, input, isFlag);
                        case YAML -> YamlConverter.yamlFromJson(outputFileLocation, input, isFlag);
                        default -> System.out.println("Invalid target type for JSON source type");
                    }
                    break;
                case XML:
                    if (targetType == DataType.JSON) {
                        JsonConverter.jsonFromXml(outputFileLocation, input, isFlag);
                    } else {
                        System.out.println("Invalid target type for XML source type");
                    }
                    break;
                case YAML:
                    if (targetType == DataType.JSON) {
                        JsonConverter.jsonFromYaml(outputFileLocation, input, isFlag);
                    } else {
                        System.out.println("Invalid target type for YAML source type");
                    }
                    break;
                default:
                    System.out.println("Invalid source type");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Would have made more options available in the above method if we had more time.
}

