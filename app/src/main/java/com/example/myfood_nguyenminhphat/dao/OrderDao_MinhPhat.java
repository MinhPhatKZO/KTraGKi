package com.example.myfood_nguyenminhphat.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myfood_nguyenminhphat.database.DBHelper_MinhPhat;
import com.example.myfood_nguyenminhphat.model.Order_MinhPhat;

import java.util.ArrayList;
import java.util.List;

public class OrderDao_MinhPhat {

    private DBHelper_MinhPhat dbHelper;

    public OrderDao_MinhPhat(Context context) {
        dbHelper = new DBHelper_MinhPhat(context);
    }

    public List<Order_MinhPhat> getAllOrders_MinhPhat() {
        List<Order_MinhPhat> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Order_MinhPhat", null);
        if (cursor.moveToFirst()) {
            do {
                Order_MinhPhat order = new Order_MinhPhat();
                order.setOrderID(cursor.getInt(0));
                order.setAddress(cursor.getString(1));
                order.setDateOrder(cursor.getString(2));
                order.setTotalValue(cursor.getDouble(3));
                order.setStatus(cursor.getString(4));
                order.setUserID(cursor.getInt(5));
                list.add(order);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }
}
