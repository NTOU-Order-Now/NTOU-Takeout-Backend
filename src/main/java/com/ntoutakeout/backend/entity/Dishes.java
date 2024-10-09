package com.ntoutakeout.backend.entity;

public class Dishes {
    private String name;
    private int price;

    public Dishes(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Price: " + price;
    }
}
