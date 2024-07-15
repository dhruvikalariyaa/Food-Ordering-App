package com.example.thefoodieszone.Domain;

import android.os.Parcelable;

import java.io.Serializable;

public class FoodDomain implements Serializable {
    private String title;
    private String pic;
    private String description;
    private Double fee;
    private int numberIncart;

    public FoodDomain(String title, String pic, String description, Double fee) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.fee = fee;
    }

    public FoodDomain(String title, String pic, String description, Double fee, int numberIncart) {
        this.title = title;
        this.pic = pic;
       this.description = description;
       this.fee = fee;
        this.numberIncart = numberIncart;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public int getNumberIncart() {
        return numberIncart;
    }

    public void setNumberIncart(int numberIncart) {
        this.numberIncart = numberIncart;
    }
}



