package com.example.alohcmute_v2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupEmailActivity extends AppCompatActivity {
    TextInputEditText et_email, et_password, et_confirm_password;
    Button btn_signup;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_email);
        AnhXa();
        mAuth = FirebaseAuth.getInstance();
        btn_signup.setOnClickListener(v -> {
            String strEmail = et_email.getText().toString();
            String strPassword = et_password.getText().toString();
            String strConfirmPassword = et_confirm_password.getText().toString();
            // toast email and pass
            Toast.makeText(SignupEmailActivity.this, strEmail + " " + strPassword, Toast.LENGTH_SHORT).show();
            mAuth.createUserWithEmailAndPassword(strEmail, strPassword)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(SignupEmailActivity.this, "Current user: " + user.getEmail(),
                                        Toast.LENGTH_SHORT).show();

                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(SignupEmailActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        });
    }
    public void AnhXa(){
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        et_confirm_password = findViewById(R.id.et_confirm_password);
        btn_signup = findViewById(R.id.btn_signup);
    }
}