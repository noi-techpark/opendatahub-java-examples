package com.opendatahub.examples.java;

import com.opendatahub.examples.java.api.MobilityClient;
import com.opendatahub.examples.java.api.TourismClient;

import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args) throws Exception {

        Logger logger = Logger.getLogger(Main.class.getName());

        TourismClient tourismClient = new TourismClient();
        MobilityClient mobilityClient = new MobilityClient();

        /********************************************************
         * MOBILITY API - https://mobility.api.opendatahub.com
         *******************************************************/

        // get all stations
        // https://mobility.api.opendatahub.com/v2/flat,node/
        String stations = mobilityClient.getStations();
        logger.info(stations);

        // get details of specific station type for example CarsharingStation
        // https://mobility.api.opendatahub.com/v2/flat,node/CarsharingStation
        String carsharingStations = mobilityClient.getStation("CarsharingStation");
        logger.info(carsharingStations);

        // get details of specific station type for example CarsharingCar
        // https://mobility.api.opendatahub.com/v2/flat,node/CarsharingCar
        String carsharingCar = mobilityClient.getStation("CarsharingCar");
        logger.info(carsharingCar);

        // get all data of a station
        // https://mobility.api.opendatahub.com/v2/flat,node/CarsharingCar/*/latest
        String allData = mobilityClient.getData("CarsharingCar");
        logger.info(allData);

        // get specific data of a station
        // https://mobility.api.opendatahub.com/v2/flat,node/CarsharingCar/availability/latest
        String specificData = mobilityClient.getData("CarsharingCar", "availability");
        logger.info(specificData);

        // Convert String from previous call to a JSONObject
        // then extract mvalue, representing the availability of the CarsharingCar
        JSONObject json = new JSONObject(specificData);
        JSONArray data = json.getJSONArray("data");
        JSONObject firstDataSet = data.getJSONObject(0);
        double mvalue = firstDataSet.getDouble("mvalue");
        logger.info("value is : " + mvalue);

        /********************************************************
         * TOURISM API - https://tourism.api.opendatahub.com
         *******************************************************/

        // get specific Entity like Accommodation
        // https://tourism.api.opendatahub.com/v1/Accommodation
        String accommodations = tourismClient.getData("Accommodation");
        logger.info(accommodations);

        // // get specific Entity like Article
        // // https://tourism.api.opendatahub.com/v1/Article
        String articles = tourismClient.getData("Article");
        logger.info(articles);

    }
}
