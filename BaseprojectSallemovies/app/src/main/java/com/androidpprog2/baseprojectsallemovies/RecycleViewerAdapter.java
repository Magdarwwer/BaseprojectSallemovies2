package com.androidpprog2.baseprojectsallemovies;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// MovieAdapter.java
public class RecycleViewerAdapter extends RecyclerView.Adapter<RecycleViewerAdapter.MovieViewHolder> {
    private List<Movie> movies;
    private Context context;

    public RecycleViewerAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_unit, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.movieTitle.setText(movie.getTitle());
        holder.itemView.setOnClickListener(v -> {
            // Open fragment with additional details
            FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
            MovieDetailFragment fragment = MovieDetailFragment.newInstance(movie);
            fragmentManager.beginTransaction()
                    .replace(R.id.movie_fragment, fragment)
                    .addToBackStack(null)
                    .commit();
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView movieTitle;

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            movieTitle = itemView.findViewById(R.id.movie_title);
        }
    }
}

