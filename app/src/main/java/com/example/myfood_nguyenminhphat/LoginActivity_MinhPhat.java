package com.example.myfood_nguyenminhphat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myfood_nguyenminhphat.dao.UserDao_MinhPhat;

public class LoginActivity_MinhPhat extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    Button btnLogin;
    TextView txtLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_minhphat);

        edtUsername = findViewById(R.id.edtUsername_MinhPhat);
        edtPassword = findViewById(R.id.edtPassword_MinhPhat);
        btnLogin = findViewById(R.id.btnLogin_MinhPhat);
        txtLogout = findViewById(R.id.txtLogout_MinhPhat);

        UserDao_MinhPhat userDao = new UserDao_MinhPhat(this);

        btnLogin.setOnClickListener(v -> {
            String username = edtUsername.getText().toString().trim();
            String password = edtPassword.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean check = userDao.checkLogin_MinhPhat(username, password);
            if (check) {
                Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, HomeActivity_MinhPhat.class);
                i.putExtra("username", username); // gửi username qua nếu cần hiển thị ở Home
                startActivity(i);
                finish();
            } else {
                Toast.makeText(this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
            }
        });

        txtLogout.setOnClickListener(v -> {
            Toast.makeText(this, "Bạn chưa có tài khoản. Liên hệ quản trị viên!", Toast.LENGTH_SHORT).show();
        });
    }
}
