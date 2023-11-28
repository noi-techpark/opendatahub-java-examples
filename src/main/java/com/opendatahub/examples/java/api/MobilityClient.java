package com.opendatahub.examples.java.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MobilityClient extends SimpleHttpClient {

    private final String BASE_URL = "https://mobility.api.opendatahub.com/v2/flat,node/";

    private SimpleHttpClient httpClient;

    public MobilityClient() {
        httpClient = new SimpleHttpClient();
    }

    public String getStations() throws Exception {
        return httpClient.get(BASE_URL);
    }

    public String getStation(String stationType) throws Exception {
        return httpClient.get(BASE_URL + stationType);
    }

    public String getData(String stationType) throws Exception {
        return getData(stationType, "*");
    }

    public String getData(String stationType, String dataType) throws Exception {
        return httpClient.get(BASE_URL + stationType + "/" + dataType + "/");
    }
}
