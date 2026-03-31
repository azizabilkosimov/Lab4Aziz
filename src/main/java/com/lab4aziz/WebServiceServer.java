/**
 * Project: Lab 4 - RabbitMQ and Web Service
 * Purpose Details: Acts as a web service to receive Pizza JSON data and convert it to a Pizza object.
 * Course: IST 242 Section 001
 * Author: Aziz
 * Date Developed: 2026-03-31
 * Last Date Changed: 2026-03-31
 * Rev: 1.0
 */
package com.lab4aziz;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class WebServiceServer {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/pizza", exchange -> {
            if ("POST".equals(exchange.getRequestMethod())) {

                String json = new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
                Pizza pizza = new Gson().fromJson(json, Pizza.class);

                System.out.println("Received via Web: " + pizza);

                String response = "OK";
                exchange.sendResponseHeaders(200, response.length());
                exchange.getResponseBody().write(response.getBytes());
                exchange.getResponseBody().close();
            }
        });

        server.start();
        System.out.println("Server running on http://localhost:8080/pizza");
    }
}