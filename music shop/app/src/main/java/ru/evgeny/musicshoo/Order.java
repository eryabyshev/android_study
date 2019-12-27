package ru.evgeny.musicshoo;

import java.io.Serializable;

public class Order implements Serializable {

    public final String userName;
    public final String itemName;
    public final int priceTotal;
    public final int count;
    public final int price;

    public Order(String userName, String itemName, int priceTotal, int count, int price) {
        this.userName = userName;
        this.itemName = itemName;
        this.priceTotal = priceTotal;
        this.count = count;
        this.price = price;
    }
}