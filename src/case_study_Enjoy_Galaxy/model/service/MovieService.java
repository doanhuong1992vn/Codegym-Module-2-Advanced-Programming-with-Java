package case_study_Enjoy_Galaxy.model.service;

import case_study_Enjoy_Galaxy.model.entity.Movie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MovieService {
    private static final List<Movie> movieList = new ArrayList<>();

    public List<Movie> getMovieList() {
        return movieList;
    }
    public List<Movie> getMovieListSortedByDuration() {
        movieList.sort(Comparator.comparingLong(Movie::getMovieDuration));
        return movieList;
    }
    public List<Movie> getMovieListSortedByPremiereDate() {
        movieList.sort(Comparator.comparingLong(Movie::getTimeOfPremiereDate));
        return movieList;
    }
    public Movie getMovieByTitle(String title) {
        for (Movie movie: movieList) {
            if (movie.getTitle().toUpperCase().contains(title.toUpperCase())) {
                return movie;
            }
        }
        return null;
    }
}
