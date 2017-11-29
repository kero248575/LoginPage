package com.example.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etUserName, etPassword;
    Button btnSignIn;
    TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        tvRegister = (TextView) findViewById(R.id.tvRegister);
    }

    public void clickSignIn(View view) {
        if (!etUserName.getText().toString().equals("") && !etPassword.getText().toString().equals("")) {
            String name = getSharedPreferences("account", MODE_PRIVATE).getString("UserName", "");
            String pwd = getSharedPreferences("account", MODE_PRIVATE).getString("Password", "");
            if (etUserName.getText().toString().equals(name) && etPassword.getText().toString().equals(pwd)) {
                Toast.makeText(this, "帳號驗證成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, UserHomePage.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "帳號驗證失敗", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "欄位不可空白", Toast.LENGTH_SHORT).show();
        }
    }

    public void clickRegister1(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
