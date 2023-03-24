package no.hiof.dcon.web;

import java.net.http.HttpResponse;

/**
 * Web is a class with methods for accessing web resources easily.
 */
public class WebApi {
    private WebApi() {
    }

    /**
     * Takes a given url to a web api and returns the result from a call to that link.
     * @param url   This represents the URL of the web API to consume.
     * @return      Returns an HttpResponse object. This contains everything that the API returned.
     */
    public static HttpResponse consumeWebApi(String url) {
        return null;
    }

    /**
     * This is a more specific version of the consumeWebApi method.
     * Instead of returning everything, this retrieves and returns just the content of the response.
     * @param url   This represents the URL of the web API to consume.
     * @return      A string with the content of the response from the web API. This is usually in Json or Xml format.
     */
    public static String retrieveWebApiContent(String url) {
        return null;
    }
}
