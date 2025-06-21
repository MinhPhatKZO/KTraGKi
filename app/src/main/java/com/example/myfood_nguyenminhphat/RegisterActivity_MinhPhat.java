package com.example.myfood_nguyenminhphat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myfood_nguyenminhphat.dao.UserDao_MinhPhat;
import com.example.myfood_nguyenminhphat.model.User_MinhPhat;

public class RegisterActivity_MinhPhat extends AppCompatActivity {

    EditText edtUsername, edtPassword, edtRepassword;
    ImageButton btnRegister;
    TextView txtLoginLink;
    UserDao_MinhPhat userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_minhphat);

        edtUsername = findViewById(R.id.edtUsername_MinhPhat);
        edtPassword = findViewById(R.id.edtPassword_MinhPhat);
        edtRepassword = findViewById(R.id.edtRepassword_MinhPhat);
        btnRegister = findViewById(R.id.btnRegister_MinhPhat);
        txtLoginLink = findViewById(R.id.txtLogin_MinhPhat);

        userDao = new UserDao_MinhPhat(this);

        btnRegister.setOnClickListener(v -> {
            String username = edtUsername.getText().toString().trim();
            String password = edtPassword.getText().toString().trim();
            String repassword = edtRepassword.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty() || repassword.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!password.equals(repassword)) {
                Toast.makeText(this, "Mật khẩu nhập lại không khớp", Toast.LENGTH_SHORT).show();
                edtRepassword.setText("");
                edtRepassword.requestFocus();
                return;
            }

            boolean result = userDao.insertUser_MinhPhat(new User_MinhPhat(username, password));
            if (result) {
                Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, LoginActivity_MinhPhat.class);
                intent.putExtra("username", username);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Tên đăng nhập đã tồn tại", Toast.LENGTH_SHORT).show();
            }
        });

        txtLoginLink.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity_MinhPhat.class));
            finish();
        });
    }
}