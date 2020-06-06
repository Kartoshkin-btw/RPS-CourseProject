package com.model;

import java.util.List;

public class Item {
        private Clothes clothes;
        private Print print;
        private int quantity;
        private String size;
        private double lineSum;


    public Item(Clothes clothes, Print print, int quantity, String size, double lineSum) {
        this.clothes = clothes;
        this.print = print;
        this.quantity = quantity;
        this.size = size;
        this.lineSum = lineSum;
    }



    public Item() {
    }

    public Item(Clothes clothes, Print print, int quantity, String size) {
        this.clothes = clothes;
        this.print = print;
        this.quantity = quantity;
        this.size = size;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getLineSum() {
        return lineSum;
    }

    public void setLineSum(double lineSum) {
        this.lineSum = lineSum;
    }
}
