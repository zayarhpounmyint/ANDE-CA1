package com.example.helloworld;

public class City {
    private String title;
    private int imageResource;
    private String description;
    private Class<?> destinationActivity;

    public City(String title, int imageResource, String description, Class<?> destinationActivity) {
        this.title = title;
        this.description = description;
        this.imageResource = imageResource;
        this.destinationActivity = destinationActivity;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getDescription() {
        return description;
    }

    public Class<?> getDestinationActivity() {
        return destinationActivity;
    }
}
