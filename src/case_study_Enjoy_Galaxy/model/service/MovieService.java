package case_study_Enjoy_Galaxy.model.service;

import case_study_Enjoy_Galaxy.model.entity.Movie;
import case_study_Enjoy_Galaxy.model.utils.Converter;
import case_study_Enjoy_Galaxy.model.utils.FileReadingUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MovieService {
    private static final MovieService movieService = new MovieService();
    private static final List<Movie> movieList = new ArrayList<>();
    private static final String PATH = "src\\case_study_Enjoy_Galaxy\\model\\data\\movie.csv";

    static {
        try {
            movieList.addAll(FileReadingUtils.readMovieData(PATH));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private MovieService() {
    }

    public static MovieService getInstance() {
        return movieService;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public List<Movie> getMovieListSortedByShortestMovieDuration() {
        movieList.sort(Comparator.comparingLong(Movie::getMovieDuration));
        return movieList;
    }
    public List<Movie> getMovieListSortedByLongestMovieDuration() {
        movieList.sort(Comparator.comparingLong(Movie::getMovieDuration).reversed());
        return movieList;
    }
    public List<Movie> getMovieListSortedByOldestMovie() {
        movieList.sort(Comparator.comparingLong(Movie::getTimeOfPremiereDate));
        return movieList;
    }
    public List<Movie> getMovieListSortedByLatestMovie() {
        movieList.sort(Comparator.comparingLong(Movie::getTimeOfPremiereDate).reversed());
        return movieList;
    }

    public List<Movie> getMovieListByKeyword(String keyword) {
        List<Movie> movies = new ArrayList<>();
        for (Movie movie : movieList) {
            String movieTitleConverted = Converter.removeAccent(movie.getName()).toUpperCase();
            String keywordConverted = Converter.removeAccent(keyword).toUpperCase();
            if (movieTitleConverted.contains(keywordConverted)) {
                movies.add(movie);
            }
        }
        return movies;
    }

    public Movie getMovieById(int idMovie) {
        for (Movie movie : movieList) {
            if (movie.getId() == idMovie) {
                return movie;
            }
        }
        return null;
    }
}
