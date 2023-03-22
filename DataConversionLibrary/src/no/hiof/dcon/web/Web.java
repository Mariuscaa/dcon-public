package no.hiof.dcon.web;

import java.net.http.HttpResponse;

/**
 * Web is a class with methods for accessing web resources easily.
 */
public class Web {
    private Web() {
    }

    /**
     * this method represents the response from the web API.
     * It would need to be updated to make a HTTP request to the specified URL, consume the response from the web API,
     * and return the resulting response as a String.
     * @param url   This represents the URL of the web API to consume.
     * @return      It is intended to consume a web API from the given URL and return the response in a HttpResponse.
     */
    public static HttpResponse consumeWebApi(String url) {
        return null;
    }

    /**
     * this method represents the response from the web API.
     * It would need to be updated to make a HTTP request to the specified URL, consume the response from the web API,
     * and return the resulting response as a String.
     * @param url   This represents the URL of the web API to consume.
     * @return      It is intended to consume a web API from the given URL and return the content part of the response.
     */
    public static String consumeWebApiContent(String url) {
        return null;
    }
}
