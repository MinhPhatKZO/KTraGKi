package com.example.myfood_nguyenminhphat;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfood_nguyenminhphat.adapter.FoodAdapter_MinhPhat;
import com.example.myfood_nguyenminhphat.dao.FoodDao_MinhPhat;
import com.example.myfood_nguyenminhphat.model.Food_MinhPhat;

import java.util.List;

public class FoodListActivity_MinhPhat extends AppCompatActivity {

    RecyclerView rvFoodList;
    FoodAdapter_MinhPhat adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list_minhphat);

        rvFoodList = findViewById(R.id.lvFoods_MinhPhat);
        rvFoodList.setLayoutManager(new LinearLayoutManager(this));

        FoodDao_MinhPhat dao = new FoodDao_MinhPhat(this);
        List<Food_MinhPhat> list = dao.getAllFood_MinhPhat();

        adapter = new FoodAdapter_MinhPhat(this, list);
        rvFoodList.setAdapter(adapter);
    }
}
