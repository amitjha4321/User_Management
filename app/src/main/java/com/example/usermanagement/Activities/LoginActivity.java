package com.example.usermanagement.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.usermanagement.R;

import eu.inmite.android.lib.validations.form.annotations.NotEmpty;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    EditText email;
    EditText password;
    Button login;
    TextView registerlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //hide action bar
        getSupportActionBar().hide();
        //hide status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        email=findViewById(R.id.etEmail);
        password=findViewById(R.id.etPassword);
        login=findViewById(R.id.btnLogin);
        registerlink=findViewById(R.id.registerLink);

        registerlink.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btnLogin:
                //startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent);

            case R.id.registerLink:
                switchOnRegister();
                break;
        }

    }

    private void switchOnRegister() {
        Intent i=new Intent(LoginActivity.this, MainActivity.class);
        startActivity(i);
    }
}