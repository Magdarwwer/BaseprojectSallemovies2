package com.androidpprog2.baseprojectsallemovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecycleViewerAdapter recycleViewerAdapter;
    private List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the list to store movies
        movies = new ArrayList<>();

        // Setup RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recycleViewerAdapter = new RecycleViewerAdapter(this, movies);
        recyclerView.setAdapter(recycleViewerAdapter);

        // GET data from JSON file
        obtainData();

        // Notify adapter to update the UI
        recycleViewerAdapter.notifyDataSetChanged();
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

            // Parse JSON data
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String title = jsonObject.getString("title");
                int year = jsonObject.getInt("year");

                // Read cast from JSON file
                List<String> cast = new ArrayList<>();
                JSONArray castArray = jsonObject.getJSONArray("cast");
                for (int j = 0; j < castArray.length(); j++) {
                    cast.add(castArray.getString(j));
                }

                // Read genres from JSON file
                List<String> genres = new ArrayList<>();
                JSONArray genresArray = jsonObject.getJSONArray("genres");
                for (int j = 0; j < genresArray.length(); j++) {
                    genres.add(genresArray.getString(j));
                }

                int length = jsonObject.getInt("length");
                int score = jsonObject.getInt("score");
                String language = jsonObject.getString("language");
                String extract = jsonObject.getString("extract");

                // Handle the image
                // Assuming image is a URL or a drawable resource name
                String imageUrl = jsonObject.getString("image");

                Movie movie = new Movie(title, year, cast, genres, length, score, language, extract, imageUrl);
                movies.add(movie);
            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    public void navigateToDetailFragment(Movie movie) {
        // Create a bundle to pass movie data
        Bundle bundle = new Bundle();
        bundle.putSerializable("movie", (Serializable) movie);

        // Create and show fragment transaction
        MovieDetailFragment fragment = new MovieDetailFragment();
        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment) // R.id.fragment_container is your container in activity_main.xml
                .addToBackStack(null)
                .commit();
    }
}
