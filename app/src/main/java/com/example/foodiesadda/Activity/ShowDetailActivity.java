package com.example.foodiesadda.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodiesadda.R;

public class ShowDetailActivity extends AppCompatActivity {
    ImageView foodPic;
    TextView priceTxt ,totalPriceTxt,titleTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        getSupportActionBar().hide();
        foodPic = findViewById(R.id.foodPic);
        priceTxt = findViewById(R.id.priceTxt);
        titleTxt = findViewById(R.id.titleTxt);
        totalPriceTxt = findViewById(R.id.totalPriceTxt);
        int imageid = getIntent().getIntExtra("image",0);
        foodPic.setImageResource(imageid);
         priceTxt.setText(getIntent().getExtras().getString("price"));
         totalPriceTxt.setText(getIntent().getExtras().getString("price"));
         titleTxt.setText(getIntent().getExtras().getString("name"));

    }
}