package com.example.cse471.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.cse471.R;
import com.example.cse471.databinding.ActivityRegistrationBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registration extends AppCompatActivity {

    ActivityRegistrationBinding binding_register;

    LottieAnimationView lottieAnimationView;

    private FirebaseAuth firebaseAuth;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding_register = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding_register.getRoot());
        getSupportActionBar().hide();

        //appName = findViewById(R.id.txt_splashScreen);
        lottieAnimationView = findViewById(R.id.lottie);
        lottieAnimationView.animate();

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait....");
        progressDialog.setMessage("Registering ...");

        binding_register.btnRegisterS.setOnClickListener(view -> {
            String email = binding_register.edtRegisterEmail.getText().toString();
            String password = binding_register.edtRegisterPassword.getText().toString();
            progressDialog.show();
            if (email.isEmpty() || password.isEmpty()) {
                progressDialog.dismiss();
                Toast.makeText(this, "Empty Credential", Toast.LENGTH_SHORT).show();
            }
            else{
                String domain = "bracu.ac.bd";
                if (email.endsWith("@" + domain)){
                    registerUser(email, password);
                }
                else
                {
                    Toast.makeText(this, "Email does not belong to BRAC", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void registerUser(String email, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Task Successful", Toast.LENGTH_SHORT).show();
                            startActivity( new Intent(getApplicationContext(), login.class));
                            finish();
                        }
                        else
                        {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Failed Registration", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}