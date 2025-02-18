package com.example.wintertest.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.wintertest.R;


public class RegisterActivity extends AppCompatActivity {
    private EditText mEtUserName;
    private EditText mEtPassword;
    private Button mButtonRegister;
    private Button mButtonBack;
    LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mButtonBack = findViewById(R.id.button_back);
        mButtonRegister = findViewById(R.id.button_conserve);
        mEtUserName=findViewById(R.id.et_register_username);
        mEtPassword=findViewById(R.id.et_register_password);
        linearLayoutManager = new LinearLayoutManager(this);
        initClick();
    }

    private void initClick() {
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = mEtUserName.getText().toString();
                String passWord = mEtPassword.getText().toString();
                if (userName.isEmpty() || passWord.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "请输入用户名或密码", Toast.LENGTH_SHORT).show();
                }
                else {
                    SharedPreferences.Editor editor = getSharedPreferences("user", MODE_PRIVATE).edit();
                    editor.putString("userName", userName);
                    editor.putString("passWord", passWord);
                    editor.apply();
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                 }
             }
         });
        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}