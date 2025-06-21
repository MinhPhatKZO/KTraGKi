package com.example.myfood_nguyenminhphat.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myfood_nguyenminhphat.database.DBHelper_MinhPhat;


public class UserDao_MinhPhat {

    private DBHelper_MinhPhat dbHelper;

    public UserDao_MinhPhat(Context context) {
        dbHelper = new DBHelper_MinhPhat(context);
    }

    //  Hàm kiểm tra đăng nhập
    public boolean checkLogin_MinhPhat(String username, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM User_NguyenMinhPhat WHERE Username = ? AND Password = ?",
                new String[]{username, password}
        );
        boolean result = cursor.getCount() > 0;
        cursor.close();
        return result;
    }

    // Hàm kiểm tra Username đã tồn tại hay chưa
    public boolean isUsernameExists_MinhPhat(String username) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM User_NguyenMinhPhat WHERE Username = ?",
                new String[]{username}
        );
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }

    //  Hàm đăng ký tài khoản mới
    public boolean registerUser_MinhPhat(String name, String gender, String dob, String phone, String username, String password) {
        try {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.execSQL("INSERT INTO User_NguyenMinhPhat (Name, Gender, Date_of_birth, Phone, Username, Password) VALUES (?, ?, ?, ?, ?, ?)",
                    new Object[]{name, gender, dob, phone, username, password});
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
