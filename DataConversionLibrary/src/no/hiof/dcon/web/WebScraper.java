package no.hiof.dcon.web;

public class WebScraper {
    public WebScraper() {
    }

    public String scrape(String url) {
        return null;
    }

    public static Gson createJsonParser(){
        /**
         *  on this JSON parsing library you want to use, you can choose to
         *  implement the method using Gson, Jackson or any other library of your choice.
         */
        return DconFactory.JsonParser(new Gson/Jackson());
    }

    public Webscraper build() {
        /**
         * The class has a public constructor to initialize the URL
         * and a public method named "uri" to set the URL.
         * The "uri" method returns the instance of the builder so that you can chain
         * method calls
         */
        return new Webscraper(this.url);
    }

    public static MyData consumeWebAPI(String url){
        /**
         * In this method, you can use a library like Apache HttpClient or
         * Java HttpURLConnection to make a HTTP request to the API URL and retrieve
         * the response.
         */
        return data;
    }

    public static CatFact parse(String jsonString){
        /**
         * In this method, you can use a JSON parsing library like Gson or
         * Jackson to convert the input JSON into a CatFact object.
         */
        return fact;
    }
}
