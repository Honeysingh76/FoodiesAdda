package com.example.foodiesadda.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodiesadda.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignupActivity extends AppCompatActivity {
   TextView loginBtn , loginBtn1;
   EditText nameBox , emailBox , passBox,address;
   ImageView submit;
   FirebaseFirestore database;
   FirebaseAuth auth;
   String userID;
   ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();
        loginBtn = findViewById(R.id.loginBtn);
        loginBtn1 = findViewById(R.id.loginBtn1);
        auth = FirebaseAuth.getInstance();
        database = FirebaseFirestore.getInstance();
        nameBox = findViewById(R.id.name);
        emailBox = findViewById(R.id.emailBox);
        passBox = findViewById(R.id.pass);
        address = findViewById(R.id.address);
        submit = findViewById(R.id.submit);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this , LoginActivity.class));
            }
        });
        loginBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this , LoginActivity.class));
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String name, email, pass,add;
                    email = emailBox.getText().toString();
                    name = nameBox.getText().toString();
                    pass = passBox.getText().toString();
                    add = address.getText().toString();

                    progressDialog = new ProgressDialog(SignupActivity.this);
                    progressDialog.show();
                    progressDialog.setContentView(R.layout.progress_dialog);
                    progressDialog.getWindow().setBackgroundDrawableResource(
                            android.R.color.transparent
                    );

                    user user = new user();
                    user.setEmail(email);
                    user.setName(name);
                    user.setPass(pass);
                   user.setAdd(add);
                    auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                progressDialog.dismiss();
                                // Success
                                userID = auth.getCurrentUser().getUid();
                              Task<Void> documentReference = database.collection("users")
                                        .document(userID).set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(SignupActivity.this, "Account is Created", Toast.LENGTH_SHORT).show();
                                    }
                                });

                            } else {
                                Toast.makeText(SignupActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }

                        }
                    });
                }
                catch(Exception e){
                    Toast.makeText(SignupActivity.this, "Enter Your name , Email and Password  ", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
        });
    }
}