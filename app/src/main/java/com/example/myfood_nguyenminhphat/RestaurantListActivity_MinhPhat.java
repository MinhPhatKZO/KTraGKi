package com.example.myfood_nguyenminhphat;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfood_nguyenminhphat.adapter.RestaurantAdapter_MinhPhat;
import com.example.myfood_nguyenminhphat.dao.RestaurantDao_MinhPhat;
import com.example.myfood_nguyenminhphat.model.Restaurant_MinhPhat;

import java.util.List;

public class RestaurantListActivity_MinhPhat extends AppCompatActivity {

    RecyclerView rvRestaurantList;
    RestaurantAdapter_MinhPhat adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list_minhphat);

        rvRestaurantList = findViewById(R.id.rvRestaurants_MinhPhat);
        rvRestaurantList.setLayoutManager(new LinearLayoutManager(this));

        RestaurantDao_MinhPhat dao = new RestaurantDao_MinhPhat(this);
        List<Restaurant_MinhPhat> list = dao.getAllRestaurants_MinhPhat();

        adapter = new RestaurantAdapter_MinhPhat(this, list);
        rvRestaurantList.setAdapter(adapter);
    }
}
