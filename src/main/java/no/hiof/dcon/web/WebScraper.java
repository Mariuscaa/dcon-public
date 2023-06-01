/**
 * Contains web related classes. For example useful for web API or web scraping.
 */
package no.hiof.dcon.web;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.w3c.dom.Element;
import org.yaml.snakeyaml.Yaml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Webscraper is a class which is specialized in scraping webpages and handling the data with either Json or Xml.
 */
public class WebScraper {

    private WebScraper() {
        throw new UnsupportedOperationException("WebScraper is a utility class and should not be instantiated.");
    }

    /**
     * This method scrapes a webpage and creates an XML document from it.
     *
     * @param url       the URL of the webpage to scrape
     * @param inputTag  the name of the XML element to store the webpage's title
     * @param outputFileLocation  the path of the file where the XML document will be written
     * @throws Exception if any error occurs during webpage scraping or XML document creation
     */
    public static void scrapeAsXml(String url, String inputTag, String outputFileLocation) throws Exception {

        var doc = Jsoup.connect(url).get();
        String webPageTitle = doc.title();

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        org.w3c.dom.Document xmlDocument = dBuilder.newDocument();

        Element rootElement = xmlDocument.createElement("webpage");
        xmlDocument.appendChild(rootElement);
        Element titleElement = xmlDocument.createElement(inputTag);
        titleElement.appendChild(xmlDocument.createTextNode(webPageTitle));
        rootElement.appendChild(titleElement);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(xmlDocument);

        try (FileWriter writer = new FileWriter(outputFileLocation)) {
            StreamResult result = new StreamResult(writer);
            transformer.transform(domSource, result);
        }
    }


    /**
     * This method scrapes a webpage and creates a JSON object from it.
     *
     * @param url       the URL of the webpage to scrape
     * @param inputTag  the name of the JSON element to store the webpage's title
     * @param outputFileLocation  the path of the file where the JSON object will be written
     * @throws Exception if any error occurs during webpage scraping or JSON object creation
     */
    public static void scrapeAsJson(String url, String inputTag, String outputFileLocation) throws Exception {
        var doc = Jsoup.connect(url).get();
        String webPageTitle = doc.title();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(inputTag, webPageTitle);
        FileWriter fileWriter = new FileWriter(outputFileLocation);
        fileWriter.write(jsonObject.toString());
        fileWriter.close();
    }

    /**
     * This method scrapes a webpage and creates a YAML document from it.
     *
     * @param url       the URL of the webpage to scrape
     * @param inputTag  the name of the YAML element to store the webpage's title
     * @param outputFileLocation  the path of the file where the YAML document will be written
     * @throws Exception if any error occurs during webpage scraping or YAML document creation
     */
    public static void scrapeAsYaml(String url, String inputTag, String outputFileLocation) throws Exception {
        var doc = Jsoup.connect(url).get();
        String webPageTitle = doc.title();
        Map<String, String> data = new HashMap<>();
        data.put(inputTag, webPageTitle);
        Yaml yaml = new Yaml();
        FileWriter fileWriter = new FileWriter(outputFileLocation);
        yaml.dump(data, fileWriter);
        fileWriter.close();
    }

    /**
     * This method scrapes a webpage and creates a CSV record from it.
     *
     * @param url       the URL of the webpage to scrape
     * @param inputTag  the name of the CSV column to store the webpage's title
     * @param filePath  the path of the file where the CSV record will be written
     * @throws Exception if any error occurs during webpage scraping or CSV record creation
     */
    public static void scrapeAsCsv(String url, String inputTag, String filePath) throws Exception {
        var doc = Jsoup.connect(url).get();
        String webPageTitle = doc.title();
        FileWriter csvWriter = new FileWriter(filePath);
        csvWriter.append(inputTag);
        csvWriter.append('\n');
        csvWriter.append(webPageTitle);
        csvWriter.append('\n');
        csvWriter.flush();
        csvWriter.close();
    }
}
