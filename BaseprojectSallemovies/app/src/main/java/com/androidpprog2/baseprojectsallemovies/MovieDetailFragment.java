package com.androidpprog2.baseprojectsallemovies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import java.util.List;

public class MovieDetailFragment extends Fragment {

    private TextView textViewTitle;
    private TextView textViewYear;
    private TextView textViewGenres;
    private TextView textViewLength;
    private TextView textViewScore;
    private TextView textViewLanguage;
    private TextView textViewExtract;
    private ImageView imageViewThumbnail;
    private TextView textViewCast;
    private static final String ARG_MOVIE = "arg_movie";
    private Movie movie;

    public MovieDetailFragment() {
        // Required empty public constructor
    }

    public static MovieDetailFragment newInstance(Movie movie) {
        MovieDetailFragment fragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_MOVIE, movie); // Use putSerializable instead of putParcelable
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            movie = (Movie) getArguments().getSerializable(ARG_MOVIE); // Retrieve Serializable object
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_fragment, container, false);

        // Initialize views
        textViewTitle = view.findViewById(R.id.textViewTitle);
        textViewYear = view.findViewById(R.id.textViewYear);
        textViewGenres = view.findViewById(R.id.textViewGenres);
        textViewLength = view.findViewById(R.id.textViewLength);
        textViewScore = view.findViewById(R.id.textViewScore);
        textViewLanguage = view.findViewById(R.id.textViewLanguage);
        textViewExtract = view.findViewById(R.id.textViewExtract);
        imageViewThumbnail = view.findViewById(R.id.imageViewThumbnail);
        textViewCast = view.findViewById(R.id.textViewCast);

        // Populate views with movie data
        if (movie != null) {
            textViewTitle.setText(movie.getTitle());
            textViewYear.setText(String.valueOf(movie.getYear()));
            textViewGenres.setText(formatListToString(movie.getGenres()));
            textViewLength.setText(String.format("%d min", movie.getLength()));
            textViewScore.setText(String.valueOf(movie.getScore()));
            textViewLanguage.setText(movie.getLanguage());
            textViewExtract.setText(movie.getExtract());

            // Load image using Glide (replace with your preferred image loading library)
            Glide.with(requireContext())
                    .load(movie.getImageUrl())
                    .into(imageViewThumbnail);

            textViewCast.setText(formatListToString(movie.getCast()));
        }

        return view;
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
}
