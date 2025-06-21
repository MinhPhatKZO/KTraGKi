package com.example.myfood_nguyenminhphat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myfood_nguyenminhphat.database.DBHelper_MinhPhat;
import com.example.myfood_nguyenminhphat.model.User_MinhPhat;

public class UserDao_MinhPhat {

    private DBHelper_MinhPhat dbHelper;

    public UserDao_MinhPhat(Context context) {
        dbHelper = new DBHelper_MinhPhat(context);
    }

    // Hàm kiểm tra đăng nhập
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

    // Hàm kiểm tra Username đã tồn tại
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

    // Hàm thêm user mới (dùng trong đăng ký)
    public boolean insertUser_MinhPhat(User_MinhPhat user) {
        if (isUsernameExists_MinhPhat(user.getUsername())) {
            return false; // Username đã tồn tại
        }

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Name", user.getName());
        values.put("Gender", user.getGender());
        values.put("Date_of_birth", user.getDateOfBirth());
        values.put("Phone", user.getPhone());
        values.put("Username", user.getUsername());
        values.put("Password", user.getPassword());

        long result = db.insert("User_NguyenMinhPhat", null, values);
        return result != -1;
    }
}
