package com.example.myfood_nguyenminhphat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LogoutActivity_MinhPhat extends AppCompatActivity {

    ImageButton btnBackLogin;
    TextView txtBackLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout_minhphat);

        btnBackLogin = findViewById(R.id.btnLogout_MinhPhat); // Nút hình mũi tên
        txtBackLogin = findViewById(R.id.txtLogout_MinhPhat); // Text quay về đăng nhập

        btnBackLogin.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity_MinhPhat.class));
            finish();
        });

        txtBackLogin.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity_MinhPhat.class));
            finish();
        });
    }
}
