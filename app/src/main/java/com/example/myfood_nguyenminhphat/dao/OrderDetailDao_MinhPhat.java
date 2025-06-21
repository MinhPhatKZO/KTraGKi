package com.example.myfood_nguyenminhphat.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myfood_nguyenminhphat.database.DBHelper_MinhPhat;
import com.example.myfood_nguyenminhphat.model.OrderDetail_MinhPhat;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailDao_MinhPhat {

    private DBHelper_MinhPhat dbHelper;

    public OrderDetailDao_MinhPhat(Context context) {
        dbHelper = new DBHelper_MinhPhat(context);
    }

    public List<OrderDetail_MinhPhat> getOrderDetailsByOrderID_MinhPhat(int orderID) {
        List<OrderDetail_MinhPhat> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM OrderDetail_MinhPhat WHERE OrderID = ?", new String[]{String.valueOf(orderID)});
        if (cursor.moveToFirst()) {
            do {
                OrderDetail_MinhPhat detail = new OrderDetail_MinhPhat();
                detail.setOrderID(cursor.getInt(0));
                detail.setSize(cursor.getString(2));
                detail.setFoodID(cursor.getInt(1));
                detail.setQuantity(cursor.getInt(4));
                list.add(detail);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }
}
