//The CrimeFragment that we have created is an instance of Fragment, which inherits all of its methods.
// These methods are related to the life cycle of a fragment, since a Fragment has its own life cycle, which
// we can see in the following diagram

//As we can see, the life cycle of a Fragment is very similar to the life cycle of an Activity and they are related
//        to each other
//
//Android Fragment is the part of activity, it is also known as sub-activity.
//        There can be more than one fragment in an activity.
//        Fragments represent multiple screen inside one activity.

//mothods called by the activity that contains them.
//OnCreate(): The method that creates the crime instance.
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

//OnCreateView(): Function that returns the View that we have injected into the fragment based on its layout
// MovieDetailsFragment.java
//want to change fragment based on DEVICE orientation OR TYPE of the DEVICE
public class MovieFragment extends Fragment {
    private static final String ARG_MOVIE = "arg_movie";
    private Movie movie;

    public MovieFragment() {
        // Required empty public constructor
    }

    public static MovieFragment newInstance(Movie movie) {
        MovieFragment fragment = new MovieFragment();
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
        return inflater.inflate(R.layout.fragment_my, container, false);
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