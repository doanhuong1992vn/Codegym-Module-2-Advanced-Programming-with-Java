package case_study_Enjoy_Galaxy.model.service;

import case_study_Enjoy_Galaxy.model.entity.movie_theater.abstraction.MovieTheater;
import case_study_Enjoy_Galaxy.model.factory.CinemaFactory;
import case_study_Enjoy_Galaxy.model.utils.FileReadingUtils;

import java.util.ArrayList;
import java.util.List;

public class MovieTheaterService {
    private static final MovieTheaterService movieTheaterService = new MovieTheaterService();
    private static final List<MovieTheater> movieTheaterList = new ArrayList<>();

    static {
        movieTheaterList.addAll(FileReadingUtils.readMovieTheaterData(
                "src\\case_study_Enjoy_Galaxy\\model\\data\\movie-theater.csv"));
        List<String> informationCinemaList = FileReadingUtils.readFile(
                "src\\case_study_Enjoy_Galaxy\\model\\data\\cinema.csv"
        );
        for (String lineOfInformation : informationCinemaList) {
            if (lineOfInformation.equals(informationCinemaList.get(0))) {
                continue;
            }
            String[] informationArray = lineOfInformation.split("; ");
            final int INDEX_OF_NAME_MOVIE_THEATER = 0;
            final int INDEX_OF_TYPE_CINEMA = 1;
            final int INDEX_OF_NAME_CINEMA = 2;
            for (MovieTheater movieTheater : movieTheaterList) {
                String nameOfMovieTheater = movieTheater.getName();
                if (nameOfMovieTheater.equals(informationArray[INDEX_OF_NAME_MOVIE_THEATER])) {
                    CinemaFactory cinemaFactory = CinemaFactory.getInstance();
                    movieTheater.addCinema(cinemaFactory.getCinema(
                            informationArray[INDEX_OF_TYPE_CINEMA],
                            informationArray[INDEX_OF_NAME_CINEMA]
                    ));
                }
            }
        }
    }

    private MovieTheaterService() {
    }

    public static MovieTheaterService getInstance() {
        return movieTheaterService;
    }

    public List<MovieTheater> getMovieTheaterList() {
        return movieTheaterList;
    }

    public MovieTheater getMovieTheaterById(int idMovieTheater) {
        for (MovieTheater movieTheater : movieTheaterList) {
            if (movieTheater.getId() == idMovieTheater) {
                return movieTheater;
            }
        }
        return null;
    }
}
