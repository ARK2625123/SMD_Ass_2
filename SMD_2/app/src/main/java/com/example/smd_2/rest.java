package com.example.smd_2;

public class rest {
    private String name,location,decription,number,rating;


    public rest() {}
    public rest( String rating ,String name, String location, String decription, String number) {
        this.rating=rating;
        this.name = name;
        this.location = location;
        this.decription = decription;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

