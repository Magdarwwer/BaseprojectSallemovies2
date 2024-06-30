package com.androidpprog2.baseprojectsallemovies;//The CrimeFragment that we have created is an instance of Fragment, which inherits all of its methods.

import android.graphics.Movie;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

//want to change fragment based on DEVICE orientation OR TYPE of the DEVICE
public class MovieDetailFragment extends Fragment {
    private static final String ARG_MOVIE = "arg_movie";
    private Movie movie;

    public MovieDetailFragment() {
        // Required empty public constructor
    }

    public static MovieDetailFragment newInstance(Movie movie) {
        MovieDetailFragment fragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_MOVIE, movie);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            movie = getArguments().getParcelable(ARG_MOVIE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.movie_fragment, container, false);
    }
}




//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.movie_details_fragment, container, false);
//        TextView titleTextView = view.findViewById(R.id.movie_title_detail);
//        TextView yearTextView = view.findViewById(R.id.movie_year_detail);
//        TextView plotTextView = view.findViewById(R.id.movie_plot_detail);
//
//        if (movie != null) {
//            titleTextView.setText(movie.getTitle());
//            yearTextView.setText(String.valueOf(movie.getYear()));
//            plotTextView.setText(movie.getPlot());
//        }
//
//        return view;
//    }