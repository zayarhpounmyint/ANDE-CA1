package com.example.helloworld;

public class City {
    private String title;
    private int imageResource;
    private String description;
<<<<<<< HEAD
    private Class<?> destinationActivity;
    private String category;

    public City(String title, int imageResource, String description, Class<?> destinationActivity, String category) {
        this.title = title;
        this.description = description;
        this.imageResource = imageResource;
        this.destinationActivity = destinationActivity;
=======
    private String category;

    public City(String title, int imageResource, String description, String category) {
        this.title = title;
        this.description = description;
        this.imageResource = imageResource;
>>>>>>> 6bc17592a1b04fc939256fae9370749a5eff503c
        this.category = category;
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

<<<<<<< HEAD
    public Class<?> getDestinationActivity() {
        return destinationActivity;
    }

=======
>>>>>>> 6bc17592a1b04fc939256fae9370749a5eff503c
    public String getCategory() {
        return category;
    }
}
