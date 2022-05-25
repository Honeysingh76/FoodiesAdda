package com.example.foodiesadda.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.foodiesadda.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.Objects;

public class ProfileActivity extends AppCompatActivity {
   TextView name , password , email , address;
   FirebaseAuth fAuth ;
   FirebaseFirestore fStore ;
   String userId ;
   LinearLayout cartBtn , homeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
     getSupportActionBar().hide();
        name = findViewById(R.id.userName);
        password = findViewById(R.id.userPass);
        email = findViewById(R.id.userEmail);
        address = findViewById(R.id.userAddress);
        cartBtn=findViewById(R.id.cartBtnPro);
        homeBtn = findViewById(R.id.homeBtnPro);

            cartBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            homeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(ProfileActivity.this,MainActivity.class  ));
                }
            });

//        firebase instance()
        fStore = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();
//        Geting userId form firebase store
        userId = Objects.requireNonNull(fAuth.getCurrentUser()).getUid();

        DocumentReference documentReference = fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, (value, error) -> {
           name.setText(value.getString("name"));
           email.setText(value.getString("email"));
           password.setText(value.getString("pass"));
           address.setText(value.getString("add"));
        });
    }
}