package com.example.helloworld;

// CardItem.java
public class Attraction {
    private int id;
    private String category;
    private int image;
    private String title;
    private String description;
    private double rating;
<<<<<<< HEAD
=======
    private String location;
>>>>>>> 6bc17592a1b04fc939256fae9370749a5eff503c
    private double distance;
    private String website;

    // Constructor without ID for new attractions
<<<<<<< HEAD
    public Attraction(String category, int image, String title, String description, double rating, double distance, String website) {
=======
    public Attraction(String category, int image, String title, String description, double rating, String location, double distance, String website) {
>>>>>>> 6bc17592a1b04fc939256fae9370749a5eff503c
        this.category = category;
        this.image = image;
        this.title = title;
        this.description = description;
        this.rating = rating;
<<<<<<< HEAD
=======
        this.location = location;
>>>>>>> 6bc17592a1b04fc939256fae9370749a5eff503c
        this.distance = distance;
        this.website = website;
    }

    // Constructor with ID for database operations
<<<<<<< HEAD
    public Attraction(int id, String category, int image, String title, String description, double rating, double distance, String website) {
=======
    public Attraction(int id, String category, int image, String title, String description, double rating, String location, double distance, String website) {
>>>>>>> 6bc17592a1b04fc939256fae9370749a5eff503c
        this.id = id;
        this.category = category;
        this.image = image;
        this.title = title;
        this.description = description;
        this.rating = rating;
<<<<<<< HEAD
=======
        this.location = location;
>>>>>>> 6bc17592a1b04fc939256fae9370749a5eff503c
        this.distance = distance;
        this.website = website;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
<<<<<<< HEAD
=======
    public String getLocation() {
        return location;
    }
>>>>>>> 6bc17592a1b04fc939256fae9370749a5eff503c

    public double getDistance() {
        return distance;
    }

    public String getWebsite() {
        return website;
    }
}

