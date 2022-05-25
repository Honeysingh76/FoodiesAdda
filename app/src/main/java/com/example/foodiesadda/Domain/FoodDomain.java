package com.example.foodiesadda.Domain;

import java.io.Serializable;

public class FoodDomain implements Serializable {
     String title;
     String pic;
     Double fee;

    public FoodDomain(String title, String pic, Double fee) {
        this.title = title;
        this.pic = pic;
        this.fee = fee;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }
}