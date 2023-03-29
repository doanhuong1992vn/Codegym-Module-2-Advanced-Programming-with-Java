package case_study_Enjoy_Galaxy.model.service;

import case_study_Enjoy_Galaxy.model.entity.Movie;
import case_study_Enjoy_Galaxy.model.entity.cinema.abstraction.Cinema;
import case_study_Enjoy_Galaxy.model.entity.movie_theater.abstraction.MovieTheater;
import case_study_Enjoy_Galaxy.model.factory.CinemaFactory;
import case_study_Enjoy_Galaxy.model.utils.FileReadingUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
                    List<Cinema> cinemas = movieTheater.getCinemaList();
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

    public String getTodayToString() {
        Date date = new Date();
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

    public List<StringBuilder> getShowtimeListInDayByMovie(Movie movie, Date date) throws ParseException {
        List<StringBuilder> result = new ArrayList<>();
        for (MovieTheater movieTheater : movieTheaterList) {
            StringBuilder elementOfResult = new StringBuilder();
            elementOfResult.append("<ID: ")
                    .append(movieTheater.getId())
                    .append("> Rạp ")
                    .append(movieTheater.getName())
                    .append(": ");
            StringBuilder showtimeInMovieTheater = new StringBuilder();
            for (Cinema cinema : movieTheater.getCinemaList()) {
                TreeMap<Date, Movie> showtimeList = cinema.getShowTimeList();
                for (Map.Entry<Date, Movie> entry : showtimeList.entrySet()) {
                    Date today = getBeginningOfDate(date);
                    final long TIME_OF_TODAY = today.getTime();
                    final long TIME_OF_ONE_DAY = 1000L * 60 * 60 * 24;
                    final long TIME_OF_TOMORROW = TIME_OF_TODAY + TIME_OF_ONE_DAY;
                    final long TIME_OF_SHOWTIME = entry.getKey().getTime();
                    final long TIME_OF_NOW = date.getTime();
                    if (TIME_OF_SHOWTIME > TIME_OF_NOW
                            && TIME_OF_SHOWTIME < TIME_OF_TOMORROW
                            && movie.equals(entry.getValue())) {
                        String showtime = DateFormat.getTimeInstance(DateFormat.SHORT).format(entry.getKey());
                        showtimeInMovieTheater.append(showtime).append("\t");
                    }
                }
            }
            if (!showtimeInMovieTheater.isEmpty()) {
                elementOfResult.append(showtimeInMovieTheater);
                result.add(elementOfResult);
            }
        }
        return result;
    }

    private static Date getBeginningOfDate(Date date) throws ParseException {
        String todayFormat = new SimpleDateFormat("dd/MM/yyyy").format(date);
        return new SimpleDateFormat("dd/MM/yyyy").parse(todayFormat);
    }

    public Map<Date, Integer> getDateMapByMovie(Movie movie) throws ParseException {
        Map<Date, Integer> resultMap = new TreeMap<>(Comparator.comparingLong(Date::getTime));
        for (MovieTheater movieTheater : movieTheaterList) {
            for (Cinema cinema : movieTheater.getCinemaList()) {
                TreeMap<Date, Movie> showtimeList = cinema.getShowTimeList();
                for (Map.Entry<Date, Movie> entry : showtimeList.entrySet()) {
                    if (movie.equals(entry.getValue())) {
                        Date showtimeDate = getBeginningOfDate(entry.getKey());
                        if (resultMap.isEmpty()) {
                            resultMap.put(showtimeDate, 1);
                        } else if (resultMap.containsKey(showtimeDate)) {
                            int showtimeNumber = resultMap.get(showtimeDate);
                            int newShowtimeNumber = showtimeNumber + 1;
                            resultMap.replace(showtimeDate, newShowtimeNumber);
                        } else {
                            resultMap.put(showtimeDate, 1);
                        }
                    }
                }
            }
        }
        return resultMap;
    }
}
