package com.androidpprog2.baseprojectsallemovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

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
        holder.movieScore.setText(String.valueOf(movie.getScore()));
        holder.movieGenres.setText(formatListToString(movie.getGenres()));

        Glide.with(context).load(movie.getImageUrl()).into(holder.movieImage);

        holder.itemView.setOnClickListener(v -> {
            // Open fragment with additional details
            if (context instanceof MainActivity) {
                ((MainActivity) context).navigateToDetailFragment(movie);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    private String formatListToString(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String item : list) {
            stringBuilder.append(item).append(", ");
        }
        if (stringBuilder.length() > 2) {
            stringBuilder.setLength(stringBuilder.length() - 2); // Remove trailing ", "
        }
        return stringBuilder.toString();
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView movieTitle;
        TextView movieScore;
        TextView movieGenres;
        ImageView movieImage;

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            movieTitle = itemView.findViewById(R.id.movie_name);
            movieScore = itemView.findViewById(R.id.movie_rating);
            movieGenres = itemView.findViewById(R.id.movie_genres);
            movieImage = itemView.findViewById(R.id.movie_image);
        }
    }
}
