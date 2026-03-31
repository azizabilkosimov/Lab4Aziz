/**
 * Project: Lab 4 - RabbitMQ and Web Service
 * Purpose Details: Represents a Pizza object used for sending and receiving data.
 * Course: IST 242 Section 001
 * Author: Aziz
 * Date Developed: 2026-03-31
 * Last Date Changed: 2026-03-31
 * Rev: 1.0
 */
package com.lab4aziz;

public class Pizza {

    /** The pizza size */
    private String size;

    /** The pizza topping */
    private String topping;

    /** The pizza crust */
    private String crust;

    /** The pizza price */
    private double price;

    public Pizza() {}

    public Pizza(String size, String topping, String crust, double price) {
        this.size = size;
        this.topping = topping;
        this.crust = crust;
        this.price = price;
    }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public String getTopping() { return topping; }
    public void setTopping(String topping) { this.topping = topping; }

    public String getCrust() { return crust; }
    public void setCrust(String crust) { this.crust = crust; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Pizza{" +
                "size='" + size + '\'' +
                ", topping='" + topping + '\'' +
                ", crust='" + crust + '\'' +
                ", price=" + price +
                '}';
    }
}