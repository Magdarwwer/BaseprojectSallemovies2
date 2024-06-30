package com.androidpprog2.baseprojectsallemovies;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Movie;
import android.media.Image;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the list to store movies
        movies = new ArrayList<>();

        // GET data from JSON file
        obtainData();

//code to replace with the Fragment - initializes fragments so we see what we want
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.movie_fragment, new MovieDetailFragment())
                    .commit();
        }
    }

    // GET data from JSON file
    private void obtainData(){
        String jsonString = "";
        try {
            InputStream inputStream = getApplicationContext().getAssets().open("movie.json");
            byte[] data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
            jsonString = new String(data,"UTF-8");

            // Parse JSON data - TO MODIFY!!!
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String title = jsonObject.getString("title");
                int year = jsonObject.getInt("year");
//                String cast = ...?
//                <List> genres = jsonArray.getArray("genres");
                // Read cast from JSON file
                List<String> cast = JsonReader.readListFromJson(this, "movie.json", "cast");
                // Read genres from JSON file
                List<String> genres = JsonReader.readListFromJson(this, "movie.json", "genres");
                int length = jsonObject.getInt("length");
                int review = jsonObject.getInt("review");
                String language = jsonString.getString("language");
                String extract = jsonString.getString("extract");
                Image thumbnail = jsonObject.getObject("thumbnail");

                Movie movie = new Movie(title, year, cast, genres, length, review, language, extract,thumbnail );
                movies.add(movie);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }
}

