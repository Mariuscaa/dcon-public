/**
 * Contains web related classes. For example useful for web API or web scraping.
 */
package no.hiof.dcon.web;

/**
 * Webscraper is a class which is specialized in scraping webpages and handling the data with either Json or Xml.
 */
public class WebScraper {

    /**
     * Scrapes an entire website and returns the data in Json format.
     * @param url   A string with the URL for the website to scrape.
     * @return      Returns a string with json format.
     */
    public static String scrapeAsJson(String url) {
        return null;
    }

    /**
     * On this JSON parsing library you want to use, you can choose to
     * implement the method using Gson, Jackson or any other library of your choice.
     * @return  It will return the parser object.
     */
    public static String createJsonParser(){
        return null;
    }

    /**
     * The class has a public constructor to initialize the URL
     * and a public method named "uri" to set the URL.
     * The "uri" method returns the instance of the builder so that you can chain
     * method calls.
     * @param url   This represents the URL of the web page to scrape.
     * @return      It is intended to scrape web data from the given URL and return it.
     */
    public static String Webscraper(String url) {
        return null;
    }

}
