package com.model;


public class OrderItem {
    private int id;
    private int orderID;
    private Clothes clothes;
    private Print print;
    private String size;
    private int quantity;


    public OrderItem(int id, int orderID, Clothes clothes, Print print, String size, int quantity) {
        this.id = id;
        this.orderID = orderID;
        this.clothes = clothes;
        this.print = print;
        this.size = size;
        this.quantity = quantity;
    }

    public OrderItem(int orderID, Clothes clothes, Print print, String size, int quantity) {
        this.orderID = orderID;
        this.clothes = clothes;
        this.print = print;
        this.size = size;
        this.quantity = quantity;
    }

    public OrderItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public Print getPrint() {
        return print;
    }

    public void setPrint(Print print) {
        this.print = print;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
