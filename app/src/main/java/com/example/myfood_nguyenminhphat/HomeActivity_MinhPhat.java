// ===============================
// HomeActivity_MinhPhat.java (Đã fix)
// ===============================
package com.example.myfood_nguyenminhphat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfood_nguyenminhphat.adapter.FoodAdapter_MinhPhat;
import com.example.myfood_nguyenminhphat.dao.FoodDao_MinhPhat;
import com.example.myfood_nguyenminhphat.model.Food_MinhPhat;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity_MinhPhat extends AppCompatActivity {

    EditText edtSearch;
    RecyclerView rcvFoodList;
    FoodAdapter_MinhPhat adapter;
    List<Food_MinhPhat> allFoodList = new ArrayList<>();
    List<Food_MinhPhat> filteredList = new ArrayList<>();
    FoodDao_MinhPhat foodDao;

    LinearLayout navHome, navFavorite, navCart, navUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_minhphat);

        edtSearch = findViewById(R.id.edtSearch_MinhPhat);
        rcvFoodList = findViewById(R.id.rcvFoodList_MinhPhat);
        navHome = findViewById(R.id.nav_home_minhphat);
        navFavorite = findViewById(R.id.nav_favorite_minhphat);
        navCart = findViewById(R.id.nav_cart_minhphat);
        navUser = findViewById(R.id.nav_user_minhphat);

        foodDao = new FoodDao_MinhPhat(this);
        try {
            allFoodList = foodDao.getAllFood_MinhPhat();
            if (allFoodList != null) {
                filteredList.addAll(allFoodList);
            }
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi load món ăn: " + e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

        adapter = new FoodAdapter_MinhPhat(this, filteredList);
        rcvFoodList.setLayoutManager(new LinearLayoutManager(this));
        rcvFoodList.setAdapter(adapter);

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void afterTextChanged(Editable s) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterFoodList(s.toString());
            }
        });

        navHome.setOnClickListener(v ->
                Toast.makeText(this, "Bạn đang ở trang chủ", Toast.LENGTH_SHORT).show()
        );

        navFavorite.setOnClickListener(v ->
                Toast.makeText(this, "Chức năng Yêu thích đang phát triển", Toast.LENGTH_SHORT).show()
        );

        navCart.setOnClickListener(v ->
                Toast.makeText(this, "Chức năng Giỏ hàng đang phát triển", Toast.LENGTH_SHORT).show()
        );

        navUser.setOnClickListener(v -> {
            startActivity(new Intent(this, RegisterActivity_MinhPhat.class));
            finish();
        });
    }

    private void filterFoodList(String keyword) {
        filteredList.clear();
        for (Food_MinhPhat food : allFoodList) {
            if (food.getName().toLowerCase().contains(keyword.toLowerCase())) {
                filteredList.add(food);
            }
        }
        adapter.notifyDataSetChanged();
    }
}
