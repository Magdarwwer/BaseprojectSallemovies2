//stores all movies created on the app locally
//s - static class variable

import java.util.ArrayList;
import java.util.List;

public class MovieLab {
    private static MovieLab instance;
    private List<Movie> movies;

    private MovieLab() {
        movies = new ArrayList<>();
    }

    public static MovieLab getInstance() {
        if (instance == null) {
            instance = new MovieLab();
        }
        return instance;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void removeMovie(Movie movie) {
        movies.remove(movie);
    }
}
