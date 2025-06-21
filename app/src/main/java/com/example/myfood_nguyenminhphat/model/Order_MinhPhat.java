package com.example.myfood_nguyenminhphat.model;

public class Order_MinhPhat {
    private int orderID;
    private String address;
    private String dateOrder;
    private double totalValue;
    private String status;
    private int userID;

    public Order_MinhPhat() { }

    public Order_MinhPhat(int orderID, String address, String dateOrder, double totalValue, String status, int userID) {
        this.orderID = orderID;
        this.address = address;
        this.dateOrder = dateOrder;
        this.totalValue = totalValue;
        this.status = status;
        this.userID = userID;
    }

    public int getOrderID() { return orderID; }
    public void setOrderID(int orderID) { this.orderID = orderID; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getDateOrder() { return dateOrder; }
    public void setDateOrder(String dateOrder) { this.dateOrder = dateOrder; }

    public double getTotalValue() { return totalValue; }
    public void setTotalValue(double totalValue) { this.totalValue = totalValue; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getUserID() { return userID; }
    public void setUserID(int userID) { this.userID = userID; }
}
