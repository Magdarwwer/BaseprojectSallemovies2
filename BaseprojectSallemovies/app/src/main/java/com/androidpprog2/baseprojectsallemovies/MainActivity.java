package com.androidpprog2.baseprojectsallemovies;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;

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
                    .replace(R.id.fragment_container, new MovieFragment())
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
                //? jak importowac obrazek?
                Movie movie = new Movie(title, year, cast, genres, length, review, language, extract,thumbnail );
                movies.add(movie);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;//czy to potrzebne?
    }
}

////OnCreate() method
//The CrimeActivity class will be the class that will be executed at the start of our application. This one alone
//        will contain the onCreate() method, which will initialize the fragment so that it displays the content that
//        Three of the classes that we can see in the schematic are going to be programmed by us: Crime,
//        CrimeFragment and CrimeActivity.
//        First of all we will focus on the CrimeActivity class:
//        Since it is a project that will be very long, it would be good for the student to get a general idea of what the
//        project will be like and, thus, not lose concentration and know what is being done at all times. . To do this,
//        the following diagram shows how the CrimeFragment that we will create will be structured.
//        The screen will be managed by a fragment that we will call CrimeFragment, which will be hosted by an
//        activity that we will call CrimeActivity. For now let's think that the layout that we will show on the screen will
//        contain the fragment, and that the activity will contain that fragment.
//
//        We can also see the layout of the CrimeActivity, to see that the only thing it has is a FrameLayout, in which
//        we will load the fragment.

