package com.example.usermanagement.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.usermanagement.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView loginlink;
    EditText name, email, password;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hide action bar
        getSupportActionBar().hide();
        //hide status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        name=findViewById(R.id.etName);
        email=findViewById(R.id.etEmail);
        password=findViewById(R.id.etPassword);
        register=findViewById(R.id.btnRegister);
        loginlink=findViewById(R.id.loginLink);

        loginlink.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRegister:
                Toast.makeText(this,"register",Toast.LENGTH_SHORT).show();
                break;
            case R.id.loginLink:
                //Toast.makeText(this,"login",Toast.LENGTH_SHORT).show();
                switchOnLogin();
                break;

        }

    }

    private void switchOnLogin() {
        Intent i = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(i);
    }
}