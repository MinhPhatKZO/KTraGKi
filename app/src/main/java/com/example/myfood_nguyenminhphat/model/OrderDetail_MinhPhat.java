package com.example.myfood_nguyenminhphat.model;

public class OrderDetail_MinhPhat {
    private int orderID;
    private int foodID;
    private String size;
    private String food;
    private int quantity;

    public OrderDetail_MinhPhat() { }

    public OrderDetail_MinhPhat(int orderID, int foodID, String size, String food, int quantity) {
        this.orderID = orderID;
        this.foodID = foodID;
        this.size = size;
        this.food = food;
        this.quantity = quantity;
    }

    public int getOrderID() { return orderID; }
    public void setOrderID(int orderID) { this.orderID = orderID; }

    public int getFoodID() { return foodID; }
    public void setFoodID(int foodID) { this.foodID = foodID; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public String getFood() { return food; }
    public void setFood(String food) { this.food = food; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
