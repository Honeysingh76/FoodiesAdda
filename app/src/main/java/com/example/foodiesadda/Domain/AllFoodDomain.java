package com.example.foodiesadda.Domain;

public class AllFoodDomain {
    String food_name;
    String food_price;
    int food_imageview;

    public AllFoodDomain(String food_name, String food_price, int food_imageview) {
        this.food_name = food_name;
        this.food_price = food_price;
        this.food_imageview = food_imageview;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_price() {
        return food_price;
    }

    public void setFood_price(String food_price) {
        this.food_price = food_price;
    }

    public int getFood_imageview() {
        return food_imageview;
    }

    public void setFood_imageview(int food_imageview) {
        this.food_imageview = food_imageview;
    }
}