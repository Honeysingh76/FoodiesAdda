package com.example.foodiesadda.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodiesadda.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
   EditText emailBox , passBox;
   ImageView submit;
   TextView signBtn , signup;
   FirebaseAuth auth ;
   FirebaseFirestore database;
  ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Objects.requireNonNull(getSupportActionBar()).hide();
        auth = FirebaseAuth.getInstance();
        database = FirebaseFirestore.getInstance();
        emailBox = findViewById(R.id.emailBox);
        passBox = findViewById(R.id.pass);
        submit = findViewById(R.id.submit);
        signBtn = findViewById(R.id.signBtn);
        signup = findViewById(R.id.signup);
        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignupActivity.class));
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignupActivity.class));
            }
        });

           submit.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   try {
                       String email, pass;
                       email = emailBox.getText().toString();
                       pass = passBox.getText().toString();

                       progressDialog = new ProgressDialog(LoginActivity.this);
                       progressDialog.show();
                       progressDialog.setContentView(R.layout.progress_dialog);
                       progressDialog.getWindow().setBackgroundDrawableResource(
                               android.R.color.transparent
                       );

                       auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                           @Override
                           public void onComplete(@NonNull Task<AuthResult> task) {
                               if (task.isSuccessful()) {
                                   // Success
                                   startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                   finish();
                               } else {
                                   Toast.makeText(LoginActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                   progressDialog.dismiss();
                               }
                           }
                       });
                   }
                   catch (Exception e){
                       Toast.makeText(LoginActivity.this, "Enter Email and Password ", Toast.LENGTH_SHORT).show();
                       progressDialog.dismiss();
                   }

               }
           });
    }
}