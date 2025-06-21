
package com.example.myfood_nguyenminhphat.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myfood_nguyenminhphat.database.DBHelper_MinhPhat;
import com.example.myfood_nguyenminhphat.model.Food_MinhPhat;

import java.util.ArrayList;
import java.util.List;

public class FoodDao_MinhPhat {

    private DBHelper_MinhPhat dbHelper;

    public FoodDao_MinhPhat(Context context) {
        dbHelper = new DBHelper_MinhPhat(context);
    }

    public List<Food_MinhPhat> getAllFood_MinhPhat() {
        List<Food_MinhPhat> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Food_NguyenMinhPhat", null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                Food_MinhPhat food = new Food_MinhPhat();
                food.setFoodID(cursor.getInt(0));
                food.setName(cursor.getString(1));
                food.setType(cursor.getString(2));
                food.setDescription(cursor.getString(3));
                food.setImage(cursor.getString(4));
                food.setResID(cursor.getInt(5));
                list.add(food);
            } while (cursor.moveToNext());
        }

        if (cursor != null) cursor.close();
        return list;
    }

    public Food_MinhPhat getFoodById_MinhPhat(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Food_NguyenMinhPhat WHERE FoodID=?", new String[]{String.valueOf(id)});
        if (c.moveToFirst()) {
            Food_MinhPhat f = new Food_MinhPhat();
            f.setFoodID(c.getInt(0));
            f.setName(c.getString(1));
            f.setType(c.getString(2));
            f.setDescription(c.getString(3));
            f.setImage(c.getString(4));
            f.setResID(c.getInt(5));
            c.close();
            return f;
        }
        if (c != null) c.close();
        return null;
    }
}
