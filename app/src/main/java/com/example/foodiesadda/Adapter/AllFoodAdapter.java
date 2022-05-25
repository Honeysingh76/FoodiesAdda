package com.example.foodiesadda.Adapter;
import com.example.foodiesadda.Domain.AllFoodDomain;
import com.example.foodiesadda.Activity.ShowDetailActivity;
import com.example.foodiesadda.R;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AllFoodAdapter extends RecyclerView.Adapter<AllFoodAdapter.viewholder> {

    Context context;
    ArrayList<AllFoodDomain> arrFood;
    public AllFoodAdapter(Context context, ArrayList<AllFoodDomain> arrFood) {
        this.context = context;
        this.arrFood = arrFood;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewholder_all_food,parent,false);
        viewholder viewholder = new viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
     AllFoodDomain temp = arrFood.get(position);
   holder.food_name.setText(arrFood.get(position).getFood_name());
   holder.food_price.setText(arrFood.get(position).getFood_price());
   holder.foodImage.setImageResource(arrFood.get(position).getFood_imageview());
   holder.itemView.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           Intent intent = new Intent(view.getContext() , ShowDetailActivity.class);
           intent.putExtra("image",temp.getFood_imageview());
           intent.putExtra("price",temp.getFood_price());
           intent.putExtra("name",temp.getFood_name());
           intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
           view.getContext().startActivity(intent);
       }
   });
    }

    @Override
    public int getItemCount() {
        return arrFood.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView food_name , food_price;
        ImageView foodImage;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            food_name = itemView.findViewById(R.id.foodname);
            food_price = itemView.findViewById(R.id.foodprice);
            foodImage = itemView.findViewById(R.id.foodImg);

        }
    }
}
