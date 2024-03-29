package com.example.helloworld;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "AttractionApp";
    private static final String TABLE_ATTRACTIONS = "attractions";
    private static final String KEY_ID = "id";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_RATING = "rating";
<<<<<<< HEAD
=======
    private static final String KEY_LOCATION = "location";
>>>>>>> 6bc17592a1b04fc939256fae9370749a5eff503c
    private static final String KEY_DISTANCE = "distance";
    private static final String KEY_WEBSITE = "website";

    // Constants for the cities table
    private static final String TABLE_CITIES = "cities";
    private static final String KEY_CITY_ID = "id";
    private static final String KEY_CITY_TITLE = "title";
    private static final String KEY_CITY_IMAGE = "imageResource";
    private static final String KEY_CITY_DESCRIPTION = "description";
    private static final String KEY_CITY_CATEGORY = "category";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ATTRACTIONS_TABLE = "CREATE TABLE " + TABLE_ATTRACTIONS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_CATEGORY + " TEXT,"
                + KEY_IMAGE + " INTEGER," + KEY_TITLE + " TEXT,"
                + KEY_DESCRIPTION + " TEXT," + KEY_RATING + " REAL,"
<<<<<<< HEAD
                + KEY_DISTANCE + " REAL," + KEY_WEBSITE + " TEXT" + ")";
=======
                + KEY_LOCATION + " REAL," + KEY_DISTANCE + " REAL,"
                + KEY_WEBSITE + " TEXT" + ")";
>>>>>>> 6bc17592a1b04fc939256fae9370749a5eff503c
        db.execSQL(CREATE_ATTRACTIONS_TABLE);


        String CREATE_CITIES_TABLE = "CREATE TABLE " + TABLE_CITIES + "("
                + KEY_CITY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_CITY_TITLE + " TEXT,"
                + KEY_CITY_IMAGE + " INTEGER,"
                + KEY_CITY_DESCRIPTION + " TEXT,"
                + KEY_CITY_CATEGORY + " TEXT" + ")";
        db.execSQL(CREATE_CITIES_TABLE);
        Log.d("test",CREATE_CITIES_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATTRACTIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CITIES);
        onCreate(db);
    }

    // code to add the new attraction
    public void addAttraction(Attraction attraction) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CATEGORY, attraction.getCategory());
        values.put(KEY_IMAGE, attraction.getImage());
        values.put(KEY_TITLE, attraction.getTitle());
        values.put(KEY_DESCRIPTION, attraction.getDescription());
        values.put(KEY_RATING, attraction.getRating());
<<<<<<< HEAD
=======
        values.put(KEY_LOCATION, attraction.getLocation());
>>>>>>> 6bc17592a1b04fc939256fae9370749a5eff503c
        values.put(KEY_DISTANCE, attraction.getDistance());
        values.put(KEY_WEBSITE, attraction.getWebsite());

        db.insert(TABLE_ATTRACTIONS, null, values);
        db.close();
    }

    // code to get the single attraction
    public Attraction getAttraction(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ATTRACTIONS, new String[] { KEY_ID,
<<<<<<< HEAD
                        KEY_CATEGORY, KEY_IMAGE, KEY_TITLE, KEY_DESCRIPTION, KEY_RATING, KEY_DISTANCE, KEY_WEBSITE }, KEY_ID + "=?",
=======
                        KEY_CATEGORY, KEY_IMAGE, KEY_TITLE, KEY_DESCRIPTION, KEY_RATING, KEY_LOCATION, KEY_DISTANCE, KEY_WEBSITE }, KEY_ID + "=?",
>>>>>>> 6bc17592a1b04fc939256fae9370749a5eff503c
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Attraction attraction = new Attraction(
                cursor.getInt(0), // ID
                cursor.getString(1), // Category
                cursor.getInt(2), // Image
                cursor.getString(3), // Title
                cursor.getString(4), // Description
                cursor.getDouble(5), // Rating
<<<<<<< HEAD
                cursor.getDouble(6), // Distance
                cursor.getString(7)  // Website
=======
                cursor.getString(6), // Location
                cursor.getDouble(7), // Distance
                cursor.getString(8)  // Website
>>>>>>> 6bc17592a1b04fc939256fae9370749a5eff503c
        );
        cursor.close();
        return attraction;
    }

    public List<Attraction> getAttractionsByCategory(String category) {
        List<Attraction> attractionList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

<<<<<<< HEAD
        Cursor cursor = db.query(TABLE_ATTRACTIONS, new String[] { KEY_ID, KEY_CATEGORY, KEY_IMAGE, KEY_TITLE, KEY_DESCRIPTION, KEY_RATING, KEY_DISTANCE, KEY_WEBSITE },
=======
        Cursor cursor = db.query(TABLE_ATTRACTIONS, new String[] { KEY_ID, KEY_CATEGORY, KEY_IMAGE, KEY_TITLE, KEY_DESCRIPTION, KEY_RATING, KEY_LOCATION, KEY_DISTANCE, KEY_WEBSITE },
>>>>>>> 6bc17592a1b04fc939256fae9370749a5eff503c
                KEY_CATEGORY + "=?", new String[] { category }, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                Attraction attraction = new Attraction(
                        cursor.getInt(0), // ID
                        cursor.getString(1), // Category
                        cursor.getInt(2), // Image
                        cursor.getString(3), // Title
                        cursor.getString(4), // Description
                        cursor.getDouble(5), // Rating
<<<<<<< HEAD
                        cursor.getDouble(6), // Distance
                        cursor.getString(7)  // Website
=======
                        cursor.getString(6), // Location
                        cursor.getDouble(7), // Distance
                        cursor.getString(8)  // Website
>>>>>>> 6bc17592a1b04fc939256fae9370749a5eff503c
                );
                attractionList.add(attraction);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return attractionList;
    }


    // code to get all attractions in a list view
    public List<Attraction> getAllAttractions() {
        List<Attraction> attractionList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_ATTRACTIONS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Attraction attraction = new Attraction(
                        cursor.getInt(0), // ID
                        cursor.getString(1), // Category
                        cursor.getInt(2), // Image
                        cursor.getString(3), // Title
                        cursor.getString(4), // Description
                        cursor.getDouble(5), // Rating
<<<<<<< HEAD
                        cursor.getDouble(6), // Distance
                        cursor.getString(7)  // Website
=======
                        cursor.getString(6), // Location
                        cursor.getDouble(7), // Distance
                        cursor.getString(8)  // Website
>>>>>>> 6bc17592a1b04fc939256fae9370749a5eff503c
                );
                attractionList.add(attraction);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return attractionList;
    }

    // code to update the single attraction
    public int updateAttraction(Attraction attraction) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CATEGORY, attraction.getCategory());
        values.put(KEY_IMAGE, attraction.getImage());
        values.put(KEY_TITLE, attraction.getTitle());
        values.put(KEY_DESCRIPTION, attraction.getDescription());
        values.put(KEY_RATING, attraction.getRating());
<<<<<<< HEAD
=======
        values.put(KEY_DISTANCE, attraction.getLocation());
>>>>>>> 6bc17592a1b04fc939256fae9370749a5eff503c
        values.put(KEY_DISTANCE, attraction.getDistance());
        values.put(KEY_WEBSITE, attraction.getWebsite());

        return db.update(TABLE_ATTRACTIONS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(attraction.getId()) });
    }

    // Deleting single attraction
    public void deleteAttraction(Attraction attraction) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ATTRACTIONS, KEY_ID + " = ?",
                new String[] { String.valueOf(attraction.getId()) });
        db.close();
    }

    // Getting attractions count
    public int getAttractionsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_ATTRACTIONS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        return count;
    }

    public void clearAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ATTRACTIONS, null, null);
        db.close();
    }

    public List<Attraction> searchAttractionsByTitle(String title) {
        List<Attraction> attractionList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

<<<<<<< HEAD
        Cursor cursor = db.query(TABLE_ATTRACTIONS, new String[] { KEY_ID, KEY_CATEGORY, KEY_IMAGE, KEY_TITLE, KEY_DESCRIPTION, KEY_RATING, KEY_DISTANCE, KEY_WEBSITE },
=======
        Cursor cursor = db.query(TABLE_ATTRACTIONS, new String[] { KEY_ID, KEY_CATEGORY, KEY_IMAGE, KEY_TITLE, KEY_DESCRIPTION, KEY_RATING, KEY_LOCATION, KEY_DISTANCE, KEY_WEBSITE },
>>>>>>> 6bc17592a1b04fc939256fae9370749a5eff503c
                KEY_TITLE + " LIKE ?", new String[] { "%" + title + "%" }, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                // Assuming you have a constructor in your Attraction class that matches this data
                Attraction attraction = new Attraction(
                        cursor.getInt(cursor.getColumnIndex(KEY_ID)), // ID
                        cursor.getString(cursor.getColumnIndex(KEY_CATEGORY)), // Category
                        cursor.getInt(cursor.getColumnIndex(KEY_IMAGE)), // Image
                        cursor.getString(cursor.getColumnIndex(KEY_TITLE)), // Title
                        cursor.getString(cursor.getColumnIndex(KEY_DESCRIPTION)), // Description
                        cursor.getDouble(cursor.getColumnIndex(KEY_RATING)), // Rating
<<<<<<< HEAD
=======
                        cursor.getString(cursor.getColumnIndex(KEY_LOCATION)), // Location
>>>>>>> 6bc17592a1b04fc939256fae9370749a5eff503c
                        cursor.getDouble(cursor.getColumnIndex(KEY_DISTANCE)), // Distance
                        cursor.getString(cursor.getColumnIndex(KEY_WEBSITE))  // Website
                );
                attractionList.add(attraction);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return attractionList;
    }

    // Method to add a new city
    public void addCity(City city) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CITY_TITLE, city.getTitle());
        values.put(KEY_CITY_IMAGE, city.getImageResource());
        values.put(KEY_CITY_DESCRIPTION, city.getDescription());
        values.put(KEY_CITY_CATEGORY, city.getCategory());

        db.insert(TABLE_CITIES, null, values);
        db.close();
    }

    // Method to get all cities
    public List<City> getAllCities() {
        List<City> cityList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_CITIES;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                City city = new City(
                        cursor.getString(cursor.getColumnIndex(KEY_CITY_TITLE)),
                        cursor.getInt(cursor.getColumnIndex(KEY_CITY_IMAGE)),
                        cursor.getString(cursor.getColumnIndex(KEY_CITY_DESCRIPTION)),
<<<<<<< HEAD
                        null, // destinationActivity is not stored in the database
=======
>>>>>>> 6bc17592a1b04fc939256fae9370749a5eff503c
                        cursor.getString(cursor.getColumnIndex(KEY_CITY_CATEGORY))
                );
                cityList.add(city);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return cityList;
    }

    // Method to get all cities by category
    public List<City> getCitiesByCategory(String category) {
        List<City> cityList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CITIES, new String[]{
                        KEY_CITY_ID, KEY_CITY_TITLE, KEY_CITY_IMAGE, KEY_CITY_DESCRIPTION, KEY_CITY_CATEGORY},
                KEY_CITY_CATEGORY + "=?", new String[]{category}, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                City city = new City(
                        cursor.getString(cursor.getColumnIndex(KEY_CITY_TITLE)),
                        cursor.getInt(cursor.getColumnIndex(KEY_CITY_IMAGE)),
                        cursor.getString(cursor.getColumnIndex(KEY_CITY_DESCRIPTION)),
<<<<<<< HEAD
                        null, // destinationActivity is not stored in the database
=======
>>>>>>> 6bc17592a1b04fc939256fae9370749a5eff503c
                        cursor.getString(cursor.getColumnIndex(KEY_CITY_CATEGORY))
                );
                cityList.add(city);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return cityList;
    }

    public List<City> searchCityName(String searchInput) {
        List<City> cityList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = KEY_CITY_TITLE + " LIKE ?";
        String[] selectionArgs = new String[] { "%" + searchInput + "%" };

        Cursor cursor = db.query(TABLE_CITIES, new String[] {
                        KEY_CITY_ID, KEY_CITY_TITLE, KEY_CITY_IMAGE, KEY_CITY_DESCRIPTION, KEY_CITY_CATEGORY},
                selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                City city = new City(
                        cursor.getString(cursor.getColumnIndex(KEY_CITY_TITLE)),
                        cursor.getInt(cursor.getColumnIndex(KEY_CITY_IMAGE)),
                        cursor.getString(cursor.getColumnIndex(KEY_CITY_DESCRIPTION)),
<<<<<<< HEAD
                        null, // destinationActivity is not stored in the database
=======
>>>>>>> 6bc17592a1b04fc939256fae9370749a5eff503c
                        cursor.getString(cursor.getColumnIndex(KEY_CITY_CATEGORY))
                );
                cityList.add(city);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return cityList;
    }


    public int getCityCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CITIES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        return count;
    }

}
