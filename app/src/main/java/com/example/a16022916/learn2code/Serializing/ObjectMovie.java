package com.example.a16022916.learn2code.Serializing;

import java.io.Serializable;

public class ObjectMovie implements Serializable{
    
    private String name;
    private int rating;

    public ObjectMovie(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
