package com.opendatahub.examples.java.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

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
