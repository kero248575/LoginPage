package com.example.auser.loginpage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    private static final String PREF_FILE = "settings";
    private EditText etEmail;
    private EditText etPassword;
    private EditText etUserName;
    private EditText etAge;
    Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findView();
        //restore();
        setListeners();
    }
    void setListeners(){
        btnRegister.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(RegisterActivity.this, UserHomePage.class);
            Bundle bundle = new Bundle();
            bundle.putString("Email", etEmail.getText().toString());
            bundle.putString("Password", etPassword.getText().toString());
            bundle.putString("UserName", etUserName.getText().toString());
            bundle.putString("Age", etAge.getText().toString());

            intent.putExtras(bundle);
            startActivity(intent);
        }

    };
    private void findView(){
        etEmail=(EditText)findViewById(R.id.etEmail);

        etUserName=(EditText)findViewById(R.id.etUserName);
        etPassword=(EditText)findViewById(R.id.etPassword);
        etAge=(EditText)findViewById(R.id.etAge);


    }
    private void restore(){
        SharedPreferences settings=getSharedPreferences(PREF_FILE,0);
        String Email = settings.getString("etEmail","");
        String password = settings.getString("etPassword","");
        String UserName = settings.getString("etUserName","");
        String Age = settings.getString("etAge","");
        if (!Email.equals(""))
            etEmail.setText(Email);
        if (!UserName.equals(""))
            etUserName.setText(UserName);
        if (!password.equals(""))
            etPassword.setText(password);
        if (!Age.equals(""))
            etAge.setText(Age);




    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences settings=getSharedPreferences(PREF_FILE,0);
        settings.edit().putString("etEmail",etEmail.getText().toString()).commit();

        settings.edit().putString("etUserName",etUserName.getText().toString()).commit();
        settings.edit().putString("etPassword",etPassword.getText().toString()).commit();
        settings.edit().putString("etAge",etAge.getText().toString()).commit();
    }

}

