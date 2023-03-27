/*
package case_study_demo.model.service;

import case_study_demo.model.utils.FileReadingUtils;
import case_study_demo.model.entity.Movie;
import case_study_demo.model.utils.NormalizerUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MovieService {
    private static final List<Movie> movieList = new ArrayList<>();

    static {
        try {
            movieList.addAll(FileReadingUtils.readMovieData(
                    "src\\case_study_Enjoy_Galaxy\\model\\data\\movie.csv"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

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

    public List<Movie> getMovieListByKeyword(String keyword) {
        List<Movie> movies = new ArrayList<>();
        for (Movie movie : movieList) {
            String movieTitleConverted = NormalizerUtils.removeAccent(movie.getTitle()).toUpperCase();
            String keywordConverted = NormalizerUtils.removeAccent(keyword).toUpperCase();
            if (movieTitleConverted.contains(keywordConverted)) {
                movies.add(movie);
            }
        }
        return movies;
    }
    public Movie getMovieById(int idMovie) {
        for (Movie movie: movieList) {
            if (movie.getId() == idMovie) {
                return movie;
            }
        }
        return null;
    }
}
*/
