package com.example.alohcmute_v2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    EditText email, password;
    Button loginButton, googleButton, forgetPasswordButton;
    TextView signupText;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AnhXa();
        mAuth = FirebaseAuth.getInstance();
        loginButton.setOnClickListener(v -> {
            progressBar.setVisibility(ProgressBar.VISIBLE);
            String strEmail = email.getText().toString();
            String strPassword = password.getText().toString();
            if (strEmail.isEmpty() || strPassword.isEmpty()) {
                Log.d("LoginActivity", "Email or Password is empty");
            } else {
                mAuth.signInWithEmailAndPassword(strEmail, strPassword).addOnCompleteListener(task -> {
                    progressBar.setVisibility(ProgressBar.GONE);
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        if (user.isEmailVerified()) {
                            Log.d("LoginActivity", "Login Successful");
                        } else {
                            Log.d("LoginActivity", "Email is not verified");
                        }
                    } else {
                        Log.d("LoginActivity", "Login Failed");
                    }
                });
            }
        });


    }

    public void AnhXa() {
        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        loginButton = findViewById(R.id.btn_login);
        googleButton = findViewById(R.id.btn_google);
        forgetPasswordButton = findViewById(R.id.btn_forget_password);
        signupText = findViewById(R.id.txt_signup);
        progressBar = findViewById(R.id.progressBar);

    }
}