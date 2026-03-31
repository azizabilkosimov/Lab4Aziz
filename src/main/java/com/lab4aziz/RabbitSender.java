/**
 * Project: Lab 4 - RabbitMQ and Web Service
 * Purpose Details: Sends a Pizza object as JSON using RabbitMQ.
 * Course: IST 242 Section 001
 * Author: Aziz
 * Date Developed: 2026-03-31
 * Last Date Changed: 2026-03-31
 * Rev: 1.0
 */
package com.lab4aziz;

import com.google.gson.Gson;
import com.rabbitmq.client.*;

public class RabbitSender {

    private static final String QUEUE_NAME = "pizzaQueue";

    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Pizza pizza = new Pizza("Large", "Pepperoni", "Thin", 15.99);
        String json = new Gson().toJson(pizza);

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicPublish("", QUEUE_NAME, null, json.getBytes());

            System.out.println("Sent: " + json);
        }
    }
}