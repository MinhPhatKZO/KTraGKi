package com.example.myfood_nguyenminhphat.model;

public class Food_MinhPhat {
    private int foodID;
    private String name;
    private String type;
    private String description;
    private String image;
    private int resID;

    public Food_MinhPhat() { }

    public Food_MinhPhat(int foodID, String name, String type, String description, String image, int resID) {
        this.foodID = foodID;
        this.name = name;
        this.type = type;
        this.description = description;
        this.image = image;
        this.resID = resID;
    }

    public int getFoodID() { return foodID; }
    public void setFoodID(int foodID) { this.foodID = foodID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public int getResID() { return resID; }
    public void setResID(int resID) { this.resID = resID; }
}
