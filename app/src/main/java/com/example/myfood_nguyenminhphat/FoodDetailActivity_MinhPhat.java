package com.example.myfood_nguyenminhphat;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myfood_nguyenminhphat.dao.FoodDao_MinhPhat;
import com.example.myfood_nguyenminhphat.dao.RestaurantDao_MinhPhat;
import com.example.myfood_nguyenminhphat.model.Food_MinhPhat;
import com.example.myfood_nguyenminhphat.model.Restaurant_MinhPhat;

public class FoodDetailActivity_MinhPhat extends AppCompatActivity {

    TextView txtName, txtType, txtDesc, txtRestaurant;
    ImageView imgFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail_minhphat);

        // Ánh xạ View
        txtName = findViewById(R.id.txtFoodNameDetail_MinhPhat);
        txtType = findViewById(R.id.txtFoodTypeDetail_MinhPhat);
        txtDesc = findViewById(R.id.txtFoodDescDetail_MinhPhat);
        txtRestaurant = findViewById(R.id.txtRestaurantDetail_MinhPhat);
        imgFood = findViewById(R.id.imgFoodDetail_MinhPhat);

        // Nhận dữ liệu từ Intent
        int foodId = getIntent().getIntExtra("food_id", -1);
        if (foodId == -1) {
            Toast.makeText(this, "Không có thông tin món ăn!", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // Lấy thông tin món ăn từ DAO
        FoodDao_MinhPhat foodDao = new FoodDao_MinhPhat(this);
        Food_MinhPhat food = foodDao.getFoodById_MinhPhat(foodId);

        if (food != null) {
            txtName.setText(food.getName());
            txtType.setText("Loại: " + food.getType());
            txtDesc.setText("Mô tả: " + food.getDescription());

            // Lấy thông tin nhà hàng từ DAO
            RestaurantDao_MinhPhat resDao = new RestaurantDao_MinhPhat(this);
            Restaurant_MinhPhat res = resDao.getRestaurantById_MinhPhat(food.getResID());
            txtRestaurant.setText("Nhà hàng: " + (res != null ? res.getName() : "Không rõ"));

            // Nếu có thư viện ảnh thì thêm: Glide.with(this).load(food.getImage()).into(imgFood);
        } else {
            Toast.makeText(this, "Không tìm thấy món ăn", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
