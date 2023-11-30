package com.opendatahub.examples.java.api;

public class TourismClient extends SimpleHttpClient {

    private final String BASE_URL = "https://tourism.api.opendatahub.com/v1/";

    private SimpleHttpClient httpClient;

    public TourismClient() {
        httpClient = new SimpleHttpClient();
    }

    public String getData(String entity) throws Exception {
        return httpClient.get(BASE_URL + entity);
    }
}
