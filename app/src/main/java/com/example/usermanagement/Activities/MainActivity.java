package com.example.usermanagement.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.usermanagement.ModelResponse.RegisterResponse;
import com.example.usermanagement.R;
import com.example.usermanagement.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView loginlink;
    EditText name;
    EditText email;
    EditText password;
    Button register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hide action bar
        getSupportActionBar().hide();
        //hide status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        name = findViewById(R.id.etName);
        name = findViewById(R.id.etName);
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        register = findViewById(R.id.btnRegister);
        loginlink = findViewById(R.id.loginLink);

        loginlink.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRegister:
                //Toast.makeText(this,"register",Toast.LENGTH_SHORT).show();

                registerUser();
                break;
            case R.id.loginLink:
                //Toast.makeText(this,"login",Toast.LENGTH_SHORT).show();
                switchOnLogin();
                break;
        }

    }

    private void registerUser() {
        String userName=name.getText().toString();
        String userEmail=email.getText().toString();
        String userPassword=password.getText().toString();

        if (userName.isEmpty()){
            name.requestFocus();
            name.setError("Please Enter Your User Name");
            return;
        }
        if (userEmail.isEmpty()){
            email.requestFocus();
            email.setError("Please Enter Your Email");
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
            email.requestFocus();
            email.setError("Please Enter valid Email");
            return;
        }
        if (userPassword.isEmpty()){
            password.requestFocus();
            password.setError("Please Enter Your Password");
            return;
        }
        if (userPassword.length()<5){
            password.requestFocus();
            password.setError("Password should be more than 5 characters");
            return;
        }

        //Call<RegisterResponse> call = RetrofitClient.getInstance().getApi().registerUser()
        Call<RegisterResponse> call =RetrofitClient.getInstance().getApi().registeruser(userName,userEmail,userPassword);

        call.enqueue(new Callback<RegisterResponse>() {

            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                RegisterResponse registerResponse=response.body();
                if (response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "fail" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void switchOnLogin() {
        Intent i = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(i);
    }

}

