package com.example.helloworld;

// CardItem.java
public class Attraction {
    private int image;
    private String title;
    private String description;
    private double rating;
    private double distance;
    private String website;

    public Attraction(int image, String title, String description, double stars, double distance, String website ) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.rating = stars;
        this.distance = distance;
        this.website = website;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getRating() {
        return rating;
    }

    public double getDistance() {
        return distance;
    }

    public String getWebsite() {
        return website;
    }
}

