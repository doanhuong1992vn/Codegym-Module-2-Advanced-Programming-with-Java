package case_study_Enjoy_Galaxy.model.service;

import case_study_Enjoy_Galaxy.model.entity.Movie;
import case_study_Enjoy_Galaxy.model.entity.cinema.abstraction.Cinema;
import case_study_Enjoy_Galaxy.model.entity.movie_theater.abstraction.MovieTheater;
import case_study_Enjoy_Galaxy.model.factory.CinemaFactory;
import case_study_Enjoy_Galaxy.model.utils.FileReadingUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovieTheaterService {
    private static final MovieTheaterService movieTheaterService = new MovieTheaterService();
    private static final List<MovieTheater> movieTheaterList = new ArrayList<>();

    static {
        movieTheaterList.addAll(FileReadingUtils.readMovieTheaterData(
                "src\\case_study_Enjoy_Galaxy\\model\\data\\movie-theater.csv"));
        List<String> cinemaList = FileReadingUtils.readFile(
                "src\\case_study_Enjoy_Galaxy\\model\\data\\cinema.csv"
        );
        for (String lineOfCinemaList : cinemaList) {
            if (lineOfCinemaList.equals(cinemaList.get(0))) {
                continue;
            }
            String[] informationArray = lineOfCinemaList.split("; ");
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
        List<String> showtimeList = FileReadingUtils.readFile(
                "src\\case_study_Enjoy_Galaxy\\model\\data\\showtime.csv"
        );
        for (String lineOfShowtimeList : showtimeList) {
            if (lineOfShowtimeList.equals(showtimeList.get(0))) {
                continue;
            }
            String[] informationArray = lineOfShowtimeList.split("; ");
            final int INDEX_OF_NAME_MOVIE_THEATER = 0;
            final int INDEX_OF_NAME_CINEMA = 1;
            final int INDEX_OF_TIME = 2;
            final int INDEX_OF_NAME_MOVIE = 3;
            for (MovieTheater movieTheater : movieTheaterList) {
                String nameOfMovieTheater = movieTheater.getName();
                if (nameOfMovieTheater.equals(informationArray[INDEX_OF_NAME_MOVIE_THEATER])) {
                    List<Cinema> cinemas = movieTheater.getCinemas();
                    for (Cinema cinema : cinemas) {
                        String nameOfCinema = cinema.getName();
                        if (nameOfCinema.equals(informationArray[INDEX_OF_NAME_CINEMA])) {
                            Date date = null;
                            try {
                                date = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
                                        .parse(informationArray[INDEX_OF_TIME]);
                            } catch (ParseException e) {
                                System.out.println(e.getMessage());
                                ;
                            }
                            MovieService movieService = MovieService.getInstance();
                            List<Movie> movieList = movieService.getMovieList();
                            Movie movie = null;
                            for (Movie movieOfList : movieList) {
                                String nameOfMovie = movieOfList.getName();
                                if (nameOfMovie.equals(informationArray[INDEX_OF_NAME_MOVIE])) {
                                    movie = movieOfList;
                                }
                            }
                            cinema.addShowtime(date, movie);
                        }
                    }
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
