/**
 * Project: Lab 4 - RabbitMQ and Web Service
 * Purpose Details: Sends a Pizza object as JSON to a web service.
 * Course: IST 242 Section 001
 * Author: Aziz
 * Date Developed: 2026-03-31
 * Last Date Changed: 2026-03-31
 * Rev: 1.0
 */
package com.lab4aziz;

import com.google.gson.Gson;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class WebServiceClient {

    public static void main(String[] args) throws Exception {

        Pizza pizza = new Pizza("Medium", "Cheese", "Stuffed", 12.99);
        String json = new Gson().toJson(pizza);

        URL url = new URL("http://localhost:8080/pizza");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setDoOutput(true);

        conn.getOutputStream().write(json.getBytes(StandardCharsets.UTF_8));

        System.out.println("Sent via Web: " + json);
        System.out.println("Response Code: " + conn.getResponseCode());
    }
}