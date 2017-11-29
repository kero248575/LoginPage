package com.example.auser.loginpage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private static final String PREF_FILE = "settings";
    private EditText etPassword;
    private EditText etUserName;
    Button btnSignIn;
    TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findView();

        setListeners();

        //restore();
 }

    private void findView() {
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        tvRegister = (TextView) findViewById(R.id.tvRegister);
        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
   }

    void setListeners() {
        tvRegister.setOnClickListener(listener);
        btnSignIn.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent tvRegister = new Intent(LoginActivity.this, RegisterActivity.class);
                      startActivity(tvRegister);
        }

    };

////把喜好拿出來
    private void restore() {
        SharedPreferences settings = getSharedPreferences(PREF_FILE, MODE_PRIVATE);

        String password = settings.getString("etPassword", "");
        String UserName = settings.getString("etUserName", "");

        if (!UserName.equals(""))
            etUserName.setText(UserName);
        if (!password.equals(""))
            etPassword.setText(password);
   }
//把資料要存進去
//    @Override
//    protected void onPause() {
//        super.onPause();
//        SharedPreferences settings = getSharedPreferences(PREF_FILE, 0);
//        settings.edit().putString("etUserName", etUserName.getText().toString()).commit();
//        settings.edit().putString("etPassword", etPassword.getText().toString()).commit();
//
//    }

}
