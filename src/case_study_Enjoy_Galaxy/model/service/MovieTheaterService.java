package case_study_Enjoy_Galaxy.model.service;

import case_study_Enjoy_Galaxy.model.builder.showtime_builder.IShowtimeBuilder;
import case_study_Enjoy_Galaxy.model.builder.showtime_builder.ShowtimeConcreteBuilder;
import case_study_Enjoy_Galaxy.model.entity.Movie;
import case_study_Enjoy_Galaxy.model.entity.Showtime;
import case_study_Enjoy_Galaxy.model.entity.Ticket;
import case_study_Enjoy_Galaxy.model.entity.cinema.abstraction.Cinema;
import case_study_Enjoy_Galaxy.model.entity.movie_theater.abstraction.MovieTheater;
import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;
import case_study_Enjoy_Galaxy.model.factory.CinemaFactory;
import case_study_Enjoy_Galaxy.model.utils.Converter;
import case_study_Enjoy_Galaxy.model.utils.FileReaderUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MovieTheaterService {
    private static final MovieTheaterService movieTheaterService = new MovieTheaterService();
    private static final List<MovieTheater> movieTheaterList = new ArrayList<>();
    private static final String PATH_MOVIE_THEATER_DATA = "src\\case_study_Enjoy_Galaxy\\model\\data\\movie-theater.csv";
    private static final String PATH_CINEMA_DATA = "src\\case_study_Enjoy_Galaxy\\model\\data\\cinema.csv";
    private static final String PATH_SHOWTIME_DATA = "src\\case_study_Enjoy_Galaxy\\model\\data\\showtime.csv";

    static {
        movieTheaterList.addAll(FileReaderUtils.readMovieTheaterData(PATH_MOVIE_THEATER_DATA));
        List<String> cinemaList = FileReaderUtils.readFile(PATH_CINEMA_DATA);
        for (String lineOfCinemaList : cinemaList) {
            if (lineOfCinemaList.equals(cinemaList.get(0))) {
                continue;
            }
            String[] informationArray = lineOfCinemaList.split(";");
            final int INDEX_OF_MOVIE_THEATER_ID = 0;
            final int INDEX_OF_TYPE_CINEMA = 1;
            final int INDEX_OF_NAME_CINEMA = 2;
            int idMovieTheater = Integer.parseInt(informationArray[INDEX_OF_MOVIE_THEATER_ID]);
            for (MovieTheater movieTheater : movieTheaterList) {
                if (movieTheater.getId() == idMovieTheater) {
                    CinemaFactory cinemaFactory = CinemaFactory.getInstance();
                    movieTheater.addCinema(cinemaFactory.getCinema(
                            informationArray[INDEX_OF_TYPE_CINEMA],
                            informationArray[INDEX_OF_NAME_CINEMA]
                    ));
                }
            }
        }
        List<String> showtimeList = FileReaderUtils.readFile(PATH_SHOWTIME_DATA);
        for (String lineOfShowtimeList : showtimeList) {
            if (lineOfShowtimeList.equals(showtimeList.get(0))) {
                continue;
            }
            String[] informationArray = lineOfShowtimeList.split(";");
            final int INDEX_OF_MOVIE_THEATER_ID = 0;
            final int INDEX_OF_CINEMA_ID = 1;
            final int INDEX_OF_TIME = 2;
            final int INDEX_OF_MOVIE_ID = 3;
            int idMovieTheater = Integer.parseInt(informationArray[INDEX_OF_MOVIE_THEATER_ID]);
            int idCinema = Integer.parseInt(informationArray[INDEX_OF_CINEMA_ID]);
            String startShowtime = informationArray[INDEX_OF_TIME];
            int idMovie = Integer.parseInt(informationArray[INDEX_OF_MOVIE_ID]);
            addShowtime(idMovieTheater, idCinema, startShowtime, idMovie);
        }
    }

    private MovieTheaterService() {
    }

    public static MovieTheaterService getInstance() {
        return movieTheaterService;
    }

    public static void addShowtime(int idMovieTheater, int idCinema, String startShowtime, int idMovie) {
        for (MovieTheater movieTheater : movieTheaterList) {
            if (movieTheater.getId() == idMovieTheater) {
                for (Cinema cinema : movieTheater.getCinemaList()) {
                    if (cinema.getId() == idCinema) {
                        Date date = null;
                        try {
                            date = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
                                    .parse(startShowtime);
                        } catch (ParseException e) {
                            System.out.println(e.getMessage());
                        }
                        MovieService movieService = MovieService.getInstance();
                        Movie movie = null;
                        for (Movie movieOfList : movieService.getMovieList()) {
                            if (movieOfList.getId() == idMovie) {
                                movie = movieOfList;
                            }
                        }
                        IShowtimeBuilder showtimeBuilder = new ShowtimeConcreteBuilder()
                                .setIdMovieTheater(movieTheater.getId())
                                .setMovie(movie)
                                .setMovieTheaterAddress(movieTheater.getAddress())
                                .setMovieTheaterName(movieTheater.getName())
                                .setCinemaName(cinema.getName())
                                .setIdCinema(cinema.getId())
                                .setDate(date)
                                .setPrice(cinema.getPrice())
                                .setSeats(cinema.getSeats());
                        cinema.addShowtime(showtimeBuilder.build());
                    }
                }
            }
        }
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

    public List<StringBuilder> getShowtimeListInDayByMovie(Movie movie, Date date) throws ParseException {
        List<StringBuilder> result = new ArrayList<>();
        for (MovieTheater movieTheater : movieTheaterList) {
            StringBuilder elementOfResult = new StringBuilder();
            final String ID_AND_NAME_OF_MOVIE_THEATER =
                    "Rạp " + movieTheater.getName() +
                            " (" + movieTheater.getAddress() + ") ";
            elementOfResult.append(ID_AND_NAME_OF_MOVIE_THEATER);
            StringBuilder showtimeInMovieTheater = new StringBuilder();
            int showtimeNumber = 0;
            for (Cinema cinema : movieTheater.getCinemaList()) {
                for (Showtime showtime : cinema.getShowtimeList()) {
                    Date today = Converter.convertToBeginningOfDate(date);
                    final long TIME_OF_TODAY = today.getTime();
                    final long TIME_OF_ONE_DAY = 1000L * 60 * 60 * 24;
                    final long TIME_OF_TOMORROW = TIME_OF_TODAY + TIME_OF_ONE_DAY;
                    final long TIME_OF_SHOWTIME = showtime.getStartShowtime();
                    final long TIME_OF_NOW = date.getTime();
                    if (TIME_OF_SHOWTIME > TIME_OF_NOW
                            && TIME_OF_SHOWTIME < TIME_OF_TOMORROW
                            && movie.equals(showtime.getMovie())) {
                        ++showtimeNumber;
                        String showtimeFormat = Converter.getHourFormat24HByDate(showtime.getShowtime());
                        final String INFORMATION_OF_SHOWTIME =
                                "\n\t\tPhòng chiếu " + cinema.getName() +
                                        " có suất chiếu lúc: " + showtimeFormat +
                                        " <ID SHOWTIME = " + showtime.getId() + ">";
                        showtimeInMovieTheater.append(INFORMATION_OF_SHOWTIME);
                    }
                }
            }
            if (!showtimeInMovieTheater.isEmpty()) {
                final String NOTIFICATION_ABOUT_SHOWTIME_NUMBER = "có " + showtimeNumber + " suất chiếu:";
                elementOfResult.append(NOTIFICATION_ABOUT_SHOWTIME_NUMBER);
                elementOfResult.append(showtimeInMovieTheater);
                result.add(elementOfResult);
            }
        }
        return result;
    }

    public Map<Date, Integer> getShowtimeDateMapByMovie(Movie movie) throws ParseException {
        Map<Date, Integer> resultMap = new TreeMap<>(Comparator.comparingLong(Date::getTime));
        for (MovieTheater movieTheater : movieTheaterList) {
            for (Cinema cinema : movieTheater.getCinemaList()) {
                for (Showtime showtime : cinema.getShowtimeList()) {
                    boolean isShowtimeAfterNow = showtime.getShowtime().getTime() > new Date().getTime();
                    if (movie.equals(showtime.getMovie()) && isShowtimeAfterNow) {
                        Date showtimeDate = Converter.convertToBeginningOfDate(showtime.getShowtime());
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


    public Showtime getShowtimeById(int idShowtime) {
        for (MovieTheater movieTheater : movieTheaterList) {
            for (Cinema cinema : movieTheater.getCinemaList()) {
                for (Showtime showtime : cinema.getShowtimeList()) {
                    if (showtime.getId() == idShowtime) {
                        return showtime;
                    }
                }
            }
        }
        return null;
    }
    public void reservationsSeat(int idShowtime, Ticket ticket) {
        Showtime showtime = getShowtimeById(idShowtime);
        String seatCode = ticket.getSeatCode();
        for (Seat[] rowOfSeats : showtime.getSeats()) {
            for (Seat seat : rowOfSeats) {
                if (seat.getSeatCode().equals(seatCode)) {
                    seat.setReady(false);
                }
            }
        }
    }

    public StringBuilder getEmptySeats(Seat[][] seats) {
        StringBuilder result = new StringBuilder();
        StringBuilder emptySeats = new StringBuilder();
        for (Seat[] rowSeat : seats) {
            for (Seat seat : rowSeat) {
                if (seat.isReady()) {
                    emptySeats.append(seat);
                    emptySeats.append(" ");
                }
            }
        }
        if (emptySeats.isEmpty()) {
            String NOTICE_OF_FULL_SEATS = "Xin lỗi, suất chiếu này đã hết ghế trống. Vui lòng chọn suất chiếu khác";
            result.append(NOTICE_OF_FULL_SEATS);
        } else {
            String NOTICE_EMPTY_SEATS = "Các mã ghế còn trống: ";
            result.append(NOTICE_EMPTY_SEATS);
            result.append(emptySeats);
        }
        return result;
    }

    public StringBuilder getInformationInSeats(Seat[][] seats) {
        StringBuilder result = new StringBuilder();
        for (Seat[] rowSeat : seats) {
            for (Seat seat : rowSeat) {
                String priceFormat = Converter.formatPrice(seat.getPrice());
                final String NOTIFICATION = "Hàng %s là loại ghế %s dành cho %d người. " +
                        "Kiểu %s. Giá chỉ %s chưa tính phụ thu\n";
                String informationEachRow = String.format(NOTIFICATION,
                        seat.getSeatCode().charAt(0),
                        seat.getSeatType(),
                        seat.getCapacity(),
                        seat.howToSeat(),
                        priceFormat);
                result.append(informationEachRow);
                break;
            }
        }
        final int START_INDEX_OF_NEWLINE_SYMBOL = result.lastIndexOf("\n");
        final int LAST_INDEX_OF_RESULT = result.length();
        result.delete(START_INDEX_OF_NEWLINE_SYMBOL, LAST_INDEX_OF_RESULT);
        return result;
    }
}
