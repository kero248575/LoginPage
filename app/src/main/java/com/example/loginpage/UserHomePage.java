package com.example.loginpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserHomePage extends AppCompatActivity {

    TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_page);

        tvWelcome = (TextView) findViewById(R.id.tvWelcome);

        tvWelcome.setText("Welcome, "+ getSharedPreferences("account", MODE_PRIVATE).getString("UserName", ""));
    }
}
