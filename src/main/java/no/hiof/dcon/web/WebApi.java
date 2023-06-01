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
        throw new UnsupportedOperationException("WebApi is a utility class and should not be instantiated.");
    }

    /**
     * Takes a given url to a web api and returns the result from a call to that link.
     *
     * @param url This represents the URL of the web API to consume.
     * @return Returns an HttpResponse object. This contains everything that the API returned.
     * @throws IOException          If there is an error connecting to the web API.
     * @throws InterruptedException If the connection is interrupted.
     */
    public static HttpResponse<String> callWebApi(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    /**
     * This is a more specific version of the callWebApi method.
     * Instead of returning everything, this retrieves and returns just the content/body of the response.
     *
     * @param url This represents the URL of the web API to consume.
     * @return A string with the content of the response from the web API. This is usually in Json or Xml format.
     * @throws IOException          If there is an error connecting to the web API.
     * @throws InterruptedException If the connection is interrupted.
     */
    public static String getWebApiContent(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }
}
