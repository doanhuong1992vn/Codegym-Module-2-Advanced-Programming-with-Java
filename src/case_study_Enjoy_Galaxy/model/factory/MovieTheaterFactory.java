package case_study_Enjoy_Galaxy.model.factory;

import case_study_Enjoy_Galaxy.model.entity.movie_theater.abstraction.MovieTheater;
import case_study_Enjoy_Galaxy.model.entity.movie_theater.StandardMovieTheater;

public class MovieTheaterFactory {
    private static final MovieTheaterFactory movieTheaterFactory = new MovieTheaterFactory();
    private MovieTheaterFactory() {
    }
    public static MovieTheaterFactory getInstance() {
        return movieTheaterFactory;
    }
    public MovieTheater getMovieTheater(String typeMovieTheater, String name, String address) {
        String typeMovieTheaterToUpperCase = typeMovieTheater.toUpperCase();
        switch (typeMovieTheaterToUpperCase) {
            case "STANDARD" -> {
                return new StandardMovieTheater(name, address);
            }
            default -> {
                return null;
            }
        }
    }
}
