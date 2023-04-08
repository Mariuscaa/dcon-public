package no.hiof.dcon.web;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
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
    public static HttpResponse<String> consumeWebApi(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null; // or throw a custom exception or handle the error accordingly
        }
    }

    /**
     * This is a more specific version of the consumeWebApi method.
     * Instead of returning everything, this retrieves and returns just the content/body of the response.
     * @param url   This represents the URL of the web API to consume.
     * @return      A string with the content of the response from the web API. This is usually in Json or Xml format.
     */
    public static String retrieveWebApiContent(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://catfact.ninja/fact"))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null; // or throw a custom exception or handle the error accordingly
        }



    }
}
