package com.example.foodiesadda.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.foodiesadda.Adapter.AllFoodAdapter;
import com.example.foodiesadda.Adapter.CategoryAdapter;
import com.example.foodiesadda.Adapter.RecommendedAdapter;
import com.example.foodiesadda.Domain.AllFoodDomain;
import com.example.foodiesadda.Domain.CategoryDomain;
import com.example.foodiesadda.Domain.FoodDomain;
import com.example.foodiesadda.R;
import com.google.firebase.firestore.FirebaseFirestore;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
  private RecyclerView.Adapter adapter1 , adapter2 , adapter3;
    private RecyclerView recyclerViewPopularList , recyclerViewCategoryList , recyclerViewAllFood ;
   FirebaseFirestore fStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        recyclerViewCategory();
        recyclerViewPopular();
        recyclerViewAllFood();
        bottomNavigation();
        slider();
    }

    private void slider() {
         ImageCarousel imageCarousel;
        imageCarousel = findViewById(R.id.carousel);
        imageCarousel.addData(new CarouselItem("https://s1.1zoom.me/prev/500/499725.jpg","Food Item at 50% off"));
        imageCarousel.addData(new CarouselItem("https://thumbs.dreamstime.com/b/large-pizza-wooden-table-restaurant-65051203.jpg","Food Item at 50% off"));
        imageCarousel.addData(new CarouselItem("https://media.istockphoto.com/photos/cheese-burger-with-bacon-on-black-dark-background-picture-id1295796202?b=1&k=20&m=1295796202&s=170667a&w=0&h=jqUTXzROq4_Sw4V61-xtn0VDQtpZOXzKUgPLlZx3qs4=","Food Item at 50% off"));
        imageCarousel.addData(new CarouselItem("https://img.freepik.com/free-photo/front-view-person-near-burger-plate-holding-jar-with-butter_23-2148784521.jpg?size=626&ext=jpg","Food Item at 50% off"));

    }

    private void bottomNavigation() {
        LinearLayout cartBtn=findViewById(R.id.cartBtnMain);
        LinearLayout profile_btn = findViewById(R.id.profile_btn);
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
      profile_btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              startActivity(new Intent(MainActivity.this,ProfileActivity.class));
          }
      });

    }
    private void recyclerViewAllFood() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewAllFood = findViewById(R.id.view3);
        recyclerViewAllFood.setLayoutManager(linearLayoutManager);
        ArrayList<AllFoodDomain> arrFood = new ArrayList<>();
//        fStore = FirebaseFirestore.getInstance();
        AllFoodAdapter adapter3 = new AllFoodAdapter(this,arrFood);
        recyclerViewAllFood.setAdapter(adapter3);
//       fStore.collection("food_list").get()
//               .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                   @Override
//                   public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                       List<DocumentSnapshot> list= queryDocumentSnapshots.getDocuments();
//                       for (DocumentSnapshot d:list)
//                       {
//                           AllFoodDomain obj = d.toObject(AllFoodDomain.class);
//                           arrFood.add(obj);
//                       }
//                       adapter3.notifyDataSetChanged();
//                   }
//               });
        arrFood.add(new AllFoodDomain("pizza","250", R.drawable.pizza5));
        arrFood.add(new AllFoodDomain("Donut","150", R.drawable.donut2));
        arrFood.add(new AllFoodDomain("Burger","99", R.drawable.burger2));
        arrFood.add(new AllFoodDomain("HotDog","150", R.drawable.hotdog));
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.view2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("Pepperoni pizza", "pizza1", 150.0));
        foodlist.add(new FoodDomain("Chesse Burger", "burger", 250.0));
        foodlist.add(new FoodDomain("Vagetable pizza", "pizza3", 200.0));
        foodlist.add(new FoodDomain("Vagetable pizza", "pizza3", 200.0));
        foodlist.add(new FoodDomain("Vagetable pizza", "pizza3", 200.0));
        foodlist.add(new FoodDomain("Vagetable pizza", "pizza3", 200.0));

        adapter2 = new RecommendedAdapter(foodlist);
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerViewCategoryList = findViewById(R.id.view1);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("pizza", "cat_1"));
        categoryList.add(new CategoryDomain("burger","cat_2"));
        categoryList.add(new CategoryDomain("HotDog","cat_3"));
        categoryList.add(new CategoryDomain("Drink","cat_4"));
        categoryList.add(new CategoryDomain("Donut", "cat_5"));

        adapter1 = new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter1);

    }
}