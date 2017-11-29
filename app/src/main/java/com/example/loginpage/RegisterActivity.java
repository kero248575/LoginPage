package com.example.loginpage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText etEmail, etUserName, etPassword, etAge;
    Button btnRegister;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etAge = (EditText) findViewById(R.id.etAge);
        btnRegister = (Button) findViewById(R.id.btnRegister);

        pref = getSharedPreferences("account", MODE_PRIVATE);
    }

    public void clickRegister2(View view) {
        if (!etEmail.getText().toString().equals("") &&
                !etUserName.getText().toString().equals("") &&
                !etPassword.getText().toString().equals("") &&
                !etAge.getText().toString().equals("")) {
            pref.edit()
                    .putString("Email", etEmail.getText().toString())
                    .putString("UserName", etUserName.getText().toString())
                    .putString("Password", etPassword.getText().toString())
                    .putInt("Age", Integer.parseInt(etAge.getText().toString()))
                    .commit();
            Toast.makeText(this, "註冊成功", Toast.LENGTH_SHORT).show();
            Intent intent2 = new Intent(this, UserHomePage.class);
            startActivity(intent2);
        } else {
            //Log.d("Here:", etEmail.getText().toString());
            Toast.makeText(this, "欄位不可空白", Toast.LENGTH_SHORT).show();
        }
    }
}
