package com.example.myfood_nguyenminhphat.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myfood_nguyenminhphat.database.DBHelper_MinhPhat;
import com.example.myfood_nguyenminhphat.model.Restaurant_MinhPhat;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDao_MinhPhat {

    private DBHelper_MinhPhat dbHelper;

    public RestaurantDao_MinhPhat(Context context) {
        dbHelper = new DBHelper_MinhPhat(context);
    }

    public List<Restaurant_MinhPhat> getAllRestaurants_MinhPhat() {
        List<Restaurant_MinhPhat> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Restaurant_MinhPhat", null);
        if (cursor.moveToFirst()) {
            do {
                Restaurant_MinhPhat res = new Restaurant_MinhPhat();
                res.setResID(cursor.getInt(0));
                res.setName(cursor.getString(1));
                res.setAddress(cursor.getString(2));
                res.setPhone(cursor.getString(3));
                res.setImage(cursor.getString(4));
                list.add(res);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }
    public Restaurant_MinhPhat getRestaurantById_MinhPhat(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Restaurant_MinhPhat WHERE ResID=?", new String[]{String.valueOf(id)});
        if (c.moveToFirst()) {
            Restaurant_MinhPhat r = new Restaurant_MinhPhat();
            r.setResID(c.getInt(0));
            r.setName(c.getString(1));
            r.setAddress(c.getString(2));
            r.setPhone(c.getString(3));
            r.setImage(c.getString(4));
            c.close();
            return r;
        }
        return null;
    }

}
