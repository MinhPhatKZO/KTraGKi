package com.example.myfood_nguyenminhphat.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper_MinhPhat extends SQLiteOpenHelper {

    public static final String DB_NAME = "Food_NguyenMinhPhat.db";
    public static final int DB_VERSION = 1;

    public DBHelper_MinhPhat(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Bảng User
        db.execSQL("CREATE TABLE IF NOT EXISTS User_NguyenMinhPhat (" +
                "UserID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name TEXT, Gender TEXT, Date_of_birth TEXT, Phone TEXT, Username TEXT, Password TEXT)");

        db.execSQL("INSERT INTO User_NguyenMinhPhat VALUES (1, 'Nguyen Minh Phát', 'Nam', '28-12-2005', '0989782503', 'user1', '123456')");
        db.execSQL("INSERT INTO User_NguyenMinhPhat VALUES (2, 'Phạm Hoàng Lâm', 'Nam', '29-12-2005', '0989782502', 'user2', '123456')");
        db.execSQL("INSERT INTO User_NguyenMinhPhat VALUES (3, 'Trịnh Long Vũ', 'Nam', '30-12-2005', '0989782501', 'user3', '123456')");
        db.execSQL("INSERT INTO User_NguyenMinhPhat VALUES (4, 'Huy Vũ', 'Nam', '31-12-2005', '0989782500', 'user4', '123456')");
        db.execSQL("INSERT INTO User_NguyenMinhPhat VALUES (5, 'Vũ Thuỳ Linh', 'Nữ', '1-12-2005', '0989782509', 'user5', '123456')");

        // Bảng Restaurant
        db.execSQL("CREATE TABLE IF NOT EXISTS Restaurant_NguyenMinhPhat (" +
                "ResID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name TEXT, Address TEXT, Phone TEXT, Image TEXT)");

        db.execSQL("INSERT INTO Restaurant_NguyenMinhPhat VALUES (1, 'Hai lúa', 'nguyen van qua', '0989782503', '1.img')");
        db.execSQL("INSERT INTO Restaurant_NguyenMinhPhat VALUES (2, 'Cho gao', 'truong chinh', '0989782504', '1.img')");
        db.execSQL("INSERT INTO Restaurant_NguyenMinhPhat VALUES (3, 'Tien giang', 'quang trung', '0989782505', '1.img')");
        db.execSQL("INSERT INTO Restaurant_NguyenMinhPhat VALUES (4, 'My dinh', 'le duc tho', '0989782506', '1.img')");
        db.execSQL("INSERT INTO Restaurant_NguyenMinhPhat VALUES (5, 'Ngon nhuc nach', 'nguyen van quoi', '0989782507', '1.img')");

        // Bảng Food
        db.execSQL("CREATE TABLE IF NOT EXISTS Food_NguyenMinhPhat (" +
                "FoodID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name TEXT, Type TEXT, Description TEXT, Image TEXT, ResID INTEGER, " +
                "FOREIGN KEY (ResID) REFERENCES Restaurant_NguyenMinhPhat(ResID))");

        db.execSQL("INSERT INTO Food_NguyenMinhPhat (Name, Type, Description, Image, ResID) VALUES " +
                "('Bún bò', 'Food', 'Món ăn đặc sản Huế', '1.img', 1)");
        db.execSQL("INSERT INTO Food_NguyenMinhPhat (Name, Type, Description, Image, ResID) VALUES " +
                "('Cơm tấm', 'Food', 'Thơm ngon sườn bì chả', '2.img', 1)");
        db.execSQL("INSERT INTO Food_NguyenMinhPhat (Name, Type, Description, Image, ResID) VALUES " +
                "('Trà sữa', 'Drink', 'Thức uống hot giới trẻ', '3.img', 2)");
        db.execSQL("INSERT INTO Food_NguyenMinhPhat (Name, Type, Description, Image, ResID) VALUES " +
                "('Phở bò', 'Food', 'Đậm đà truyền thống', '4.img', 2)");
        db.execSQL("INSERT INTO Food_NguyenMinhPhat (Name, Type, Description, Image, ResID) VALUES " +
                "('Chè Thái', 'Dessert', 'Ngọt mát cho mùa hè', '5.img', 3)");
        db.execSQL("INSERT INTO Food_NguyenMinhPhat (Name, Type, Description, Image, ResID) VALUES " +
                "('Bánh xèo', 'Food', 'Vỏ giòn nhân tôm thịt', '6.img', 3)");
        db.execSQL("INSERT INTO Food_NguyenMinhPhat (Name, Type, Description, Image, ResID) VALUES " +
                "('Nước cam', 'Drink', 'Giải khát, bổ sung vitamin C', '7.img', 4)");
        db.execSQL("INSERT INTO Food_NguyenMinhPhat (Name, Type, Description, Image, ResID) VALUES " +
                "('Lẩu Thái', 'Food', 'Chua cay hấp dẫn', '8.img', 4)");
        db.execSQL("INSERT INTO Food_NguyenMinhPhat (Name, Type, Description, Image, ResID) VALUES " +
                "('Súp cua', 'Food', 'Bổ dưỡng cho sức khỏe', '9.img', 5)");
        db.execSQL("INSERT INTO Food_NguyenMinhPhat (Name, Type, Description, Image, ResID) VALUES " +
                "('Sinh tố bơ', 'Drink', 'Béo ngậy, mát lạnh', '10.img', 5)");

        // Bảng Order
        db.execSQL("CREATE TABLE IF NOT EXISTS Order_NguyenMinhPhat (" +
                "OrderID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Address TEXT, Date_order TEXT, Total_value REAL, Status TEXT, UserID INTEGER, " +
                "FOREIGN KEY (UserID) REFERENCES User_NguyenMinhPhat(UserID))");

        db.execSQL("INSERT INTO Order_NguyenMinhPhat VALUES (1, 'Phu an', '21-6-2005', 100000, 'Đã giao', 1)");
        db.execSQL("INSERT INTO Order_NguyenMinhPhat VALUES (2, 'quan 1', '20-6-2005', 75000, 'Đang giao', 2)");
        db.execSQL("INSERT INTO Order_NguyenMinhPhat VALUES (3, 'quan 12', '19-6-2005', 92000, 'Đã huỷ', 3)");

        // Bảng OrderDetail
        db.execSQL("CREATE TABLE IF NOT EXISTS OrderDetail_NguyenMinhPhat (" +
                "OrderID INTEGER, FoodID INTEGER, Size TEXT, Food TEXT, Quantity INTEGER, " +
                "PRIMARY KEY (OrderID, FoodID), " +
                "FOREIGN KEY (OrderID) REFERENCES Order_NguyenMinhPhat(OrderID), " +
                "FOREIGN KEY (FoodID) REFERENCES Food_NguyenMinhPhat(FoodID))");

        db.execSQL("INSERT INTO OrderDetail_NguyenMinhPhat VALUES (1, 1, 'M', 'Bún bò', 2)");
        db.execSQL("INSERT INTO OrderDetail_NguyenMinhPhat VALUES (1, 2, 'XL', 'Cơm tấm', 1)");
        db.execSQL("INSERT INTO OrderDetail_NguyenMinhPhat VALUES (2, 3, 'L', 'Trà sữa', 3)");
        db.execSQL("INSERT INTO OrderDetail_NguyenMinhPhat VALUES (3, 4, 'LL', 'Phở bò', 1)");
        db.execSQL("INSERT INTO OrderDetail_NguyenMinhPhat VALUES (3, 5, 'XML', 'Chè thái', 2)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS OrderDetail_NguyenMinhPhat");
        db.execSQL("DROP TABLE IF EXISTS Order_NguyenMinhPhat");
        db.execSQL("DROP TABLE IF EXISTS Food_NguyenMinhPhat");
        db.execSQL("DROP TABLE IF EXISTS Restaurant_NguyenMinhPhat");
        db.execSQL("DROP TABLE IF EXISTS User_NguyenMinhPhat");
        onCreate(db);
    }
}
