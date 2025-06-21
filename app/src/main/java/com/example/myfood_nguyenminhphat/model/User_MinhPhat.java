package com.example.myfood_nguyenminhphat.model;

public class User_MinhPhat {
    private int userID;
    private String name;
    private String gender;
    private String dateOfBirth;
    private String phone;
    private String username;
    private String password;

    public User_MinhPhat() { }

    public User_MinhPhat(int userID, String name, String gender, String dateOfBirth, String phone, String username, String password) {
        this.userID = userID;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public int getUserID() { return userID; }
    public void setUserID(int userID) { this.userID = userID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
