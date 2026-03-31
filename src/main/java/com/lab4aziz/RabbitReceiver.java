/**
 * Project: Lab 4 - RabbitMQ and Web Service
 * Purpose Details: Receives a Pizza JSON message from RabbitMQ and converts it to a Pizza object.
 * Course: IST 242 Section 001
 * Author: Aziz
 * Date Developed: 2026-03-31
 * Last Date Changed: 2026-03-31
 * Rev: 1.0
 */
package com.lab4aziz;

import com.google.gson.Gson;
import com.rabbitmq.client.*;

import java.nio.charset.StandardCharsets;

public class RabbitReceiver {

    private static final String QUEUE_NAME = "pizzaQueue";

    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println("Waiting for messages...");

        DeliverCallback callback = (tag, delivery) -> {
            String json = new String(delivery.getBody(), StandardCharsets.UTF_8);
            Pizza pizza = new Gson().fromJson(json, Pizza.class);

            System.out.println("Received: " + pizza);
        };

        channel.basicConsume(QUEUE_NAME, true, callback, tag -> {});
    }
}