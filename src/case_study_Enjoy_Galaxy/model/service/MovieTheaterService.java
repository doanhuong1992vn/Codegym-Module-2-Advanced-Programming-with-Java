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
import case_study_Enjoy_Galaxy.model.utils.FileWriterUtils;
import case_study_Enjoy_Galaxy.model.utils.Validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MovieTheaterService {
    private static final MovieTheaterService movieTheaterService = new MovieTheaterService();
    private static final List<MovieTheater> movieTheaterList = new ArrayList<>();
    private static final String PATH_MOVIE_THEATER_DATA = "src\\case_study_Enjoy_Galaxy\\model\\data\\movie-theater.csv";
    private static final String PATH_CINEMA_DATA = "src\\case_study_Enjoy_Galaxy\\model\\data\\cinema.csv";
    private static final String PATH_SHOWTIME_DATA = "src\\case_study_Enjoy_Galaxy\\model\\data\\showtime.csv";
    private static String notification;

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
            try {
                Date showtime = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(startShowtime);
                addShowtime(idMovieTheater, idCinema, showtime, idMovie);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        Date dateToCheck = new Date();
        Date sevenDaysLater = Converter.convertTo7DaysLater(new Date());
        while (dateToCheck.before(sevenDaysLater)) {
            try {
                dateToCheck = autoAddShowtimeAndReturnLastShowtime(dateToCheck);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private MovieTheaterService() {
    }

    public static MovieTheaterService getInstance() {
        return movieTheaterService;
    }

    public static String getNotification() {
        return notification;
    }


    public static boolean addShowtime(int idMovieTheater, int idCinema, Date tempShowtime, int idMovie)
            throws ParseException {
        Movie movie = MovieService.getInstance().getMovieById(idMovie);
        if (tempShowtime.before(new Date())) {
            notification = "Không thể thêm suất chiếu vào quá khứ kekeke";
            return false;
        }
        Date tempEndTime = Converter.getEndTimeBeforeCleaningTimeByShowtimeWithMovie(tempShowtime, movie);
        Date tempEndTimeAfterCleaningTime = Converter.getEndTimeAfterCleaningTime(tempEndTime);
        MovieTheater movieTheater = MovieTheaterService.getInstance().getMovieTheaterById(idMovieTheater);
        assert movieTheater != null;
        for (Cinema cinema : movieTheater.getCinemaList()) {
            if (cinema.getId() == idCinema) {
                if (!cinema.getShowtimeList().isEmpty()) {
                    for (Showtime showtime : cinema.getShowtimeList()) {
                        Date realShowtime = showtime.getShowtime();
                        Date realEndTime = Converter.getEndTimeAfterCleaningTime(showtime.getEndTime());
                        if (tempShowtime.after(realShowtime) && tempShowtime.before(realEndTime)) {
                            notification = String.format("Thêm không thành công vì suất chiếu bị trùng với " +
                                            "suất chiếu của phim %s từ %s tới %s tại phòng chiếu %s. " +
                                            "(Đã bao gồm 30 phút để vệ sinh phòng sau mỗi suất chiếu)",
                                    showtime.getMovie().getName(),
                                    Converter.getDateFormat24H(realShowtime),
                                    Converter.getDateFormat24H(realEndTime),
                                    showtime.getCinemaName());
                            return false;
                        } else if (tempShowtime.before(realShowtime) && tempEndTimeAfterCleaningTime.after(realShowtime)) {
                            notification = String.format("Thêm không thành công vì không có đủ thời gian trống. " +
                                            "Phim %s có thời lượng %s phút nhưng lúc %s có suất chiếu của phim %s rồi. " +
                                            "(Sau mỗi suất chiếu phải có 30 phút để vệ sinh phòng nữa)",
                                    movie.getName(),
                                    movie.getMovieDuration(),
                                    Converter.getDateFormat24H(realShowtime),
                                    showtime.getMovie().getName());
                            return false;
                        }
                    }
                }
                addShowtime(movieTheater, cinema, movie, tempShowtime, tempEndTime);
                notification = String.format("Thêm thành công suất chiếu cho phim %s lúc %s " +
                                "tại phòng chiếu %s ở rạp %s",
                        movie.getName(),
                        Converter.getDateFormat24H(tempShowtime),
                        cinema.getName(),
                        movieTheater.getName());
                return true;
            }
        }
        return false;
    }

    private static Date autoAddShowtimeAndReturnLastShowtime(Date startTimeOfLastShowtime) throws ParseException {
        for (MovieTheater movieTheater : movieTheaterList) {
            for (Cinema cinema : movieTheater.getCinemaList()) {
                Date showtime;
                MovieService movieService = MovieService.getInstance();
                Movie randomMovie = movieService.getRandomMovie();
                List<Showtime> showtimeList = cinema.getShowtimeList();
                if (!showtimeList.isEmpty()) {
                    Showtime lastShowtime = showtimeList.get(showtimeList.size() - 1);
                    Date endTimeOfLastShowtime = lastShowtime.getEndTime();
                    showtime = Converter.getEndTimeAfterCleaningTime(endTimeOfLastShowtime);
                } else {
                    showtime = new Date();
                }
                if (Validation.isInWorkingTimeOfMovieTheater(showtime)) {
                    Date endTime = Converter.getEndTimeBeforeCleaningTimeByShowtimeWithMovie(showtime, randomMovie);
                    addShowtime(movieTheater, cinema, randomMovie, showtime, endTime);
                    String record = Converter.convertToRecord(movieTheater, cinema, showtime, randomMovie);
                    FileWriterUtils.writeFileShowtime(record);
                } else {
                    showtime = Converter.convertTo8hAmOfDate(showtime);
                    Date endTime = Converter.getEndTimeBeforeCleaningTimeByShowtimeWithMovie(showtime, randomMovie);
                    addShowtime(movieTheater, cinema, randomMovie, showtime, endTime);
                    String record = Converter.convertToRecord(movieTheater, cinema, showtime, randomMovie);
                    FileWriterUtils.writeFileShowtime(record);
                }
                startTimeOfLastShowtime = (Date) showtime.clone();
            }
        }
        return startTimeOfLastShowtime;
    }

    private static void addShowtime(MovieTheater movieTheater, Cinema cinema, Movie movie, Date showtime, Date endTime) {
        IShowtimeBuilder showtimeBuilder = new ShowtimeConcreteBuilder()
                .setIdMovieTheater(movieTheater.getId())
                .setMovie(movie)
                .setMovieTheaterAddress(movieTheater.getAddress())
                .setMovieTheaterName(movieTheater.getName())
                .setCinemaName(cinema.getName())
                .setIdCinema(cinema.getId())
                .setShowtime(showtime)
                .setEndTime(endTime)
                .setPrice(cinema.getPrice())
                .setSeats(cinema.getSeats());
        cinema.addShowtime(showtimeBuilder.build());
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
            StringBuilder informationOfEachMovieTheater = new StringBuilder();
            int showtimeNumberOfEachMovieTheater = 0;
            for (Cinema cinema : movieTheater.getCinemaList()) {
                for (Showtime showtime : cinema.getShowtimeList()) {
                    Date nextDay = Converter.convertToBeginningOfNextDay(date);
                    if (showtime.getShowtime().after(date) && showtime.getShowtime().before(nextDay)
                            && movie.equals(showtime.getMovie())) {
                        ++showtimeNumberOfEachMovieTheater;
                        String showtimeFormat = Converter.getHourFormat24HByDate(showtime.getShowtime());
                        final String SHOWTIME =
                                String.format("\n\t\tPhòng chiếu %s có suất chiếu lúc: %s <ID SHOWTIME = %d>",
                                        cinema.getName(), showtimeFormat, showtime.getId());
                        informationOfEachMovieTheater.append(SHOWTIME);
                    }
                }
            }
            if (!informationOfEachMovieTheater.isEmpty()) {
                final String HEAD = String.format("Rạp %s (%s) có %d suất chiếu:",
                        movieTheater.getName(), movieTheater.getAddress(), showtimeNumberOfEachMovieTheater);
                informationOfEachMovieTheater.insert(0, HEAD);
                result.add(informationOfEachMovieTheater);
            }
        }
        return result;
    }

    public Map<Date, Integer> getShowtimeDateMapByMovie(Movie movie) throws ParseException {
        Map<Date, Integer> resultMap = new TreeMap<>(Comparator.comparingLong(Date::getTime));
        for (MovieTheater movieTheater : movieTheaterList) {
            for (Cinema cinema : movieTheater.getCinemaList()) {
                for (Showtime showtime : cinema.getShowtimeList()) {
                    boolean isShowtimeAfterNow = showtime.getShowtime().after(new Date());
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
        StringBuilder informationOfSeats = new StringBuilder();
        StringBuilder emptySeats = new StringBuilder();
        for (Seat[] rowOfSeats : seats) {
            informationOfSeats.append(getInformationOfRowOfSeats(rowOfSeats));
            for (Seat seat : rowOfSeats) {
                if (seat.isReady()) {
                    emptySeats.append(seat).append("  ");
                }
            }
        }
        if (emptySeats.isEmpty()) {
            final String NOTICE_OF_FULL_SEATS = "Xin lỗi, suất chiếu này đã hết ghế trống. Vui lòng chọn suất chiếu khác";
            emptySeats.append(NOTICE_OF_FULL_SEATS);
            return emptySeats;
        }
        final String HEAD = "Các mã ghế còn trống: ";
        emptySeats.insert(0, HEAD);
        return informationOfSeats.append(emptySeats);
    }

    public static String getInformationOfRowOfSeats(Seat[] rowOfSeats) {
        final int SAMPLE_INDEX = 0;
        return String.format("Hàng %s là loại ghế %s dành cho %d người. Kiểu %s. Giá chỉ %s chưa tính phụ thu\n",
                rowOfSeats[SAMPLE_INDEX].getSeatCode().charAt(SAMPLE_INDEX),
                rowOfSeats[SAMPLE_INDEX].getSeatType(),
                rowOfSeats[SAMPLE_INDEX].getCapacity(),
                rowOfSeats[SAMPLE_INDEX].howToSeat(),
                Converter.formatPrice(rowOfSeats[SAMPLE_INDEX].getPrice()));
    }

    public List<Cinema> getCinemaListByMovieTheaterId(int idMovieTheater) {
        return getMovieTheaterById(idMovieTheater).getCinemaList();
    }

    public List<Showtime> getShowtimeListByCinemaId(int idMovieTheater, int idCinema) {
        for (Cinema cinema : getCinemaListByMovieTheaterId(idMovieTheater)) {
            if (idCinema == cinema.getId()) {
                return cinema.getShowtimeList();
            }
        }
        return null;
    }

    public Cinema getCinemaById(int idCinema) {
        for (MovieTheater movieTheater : movieTheaterList) {
            for (Cinema cinema : movieTheater.getCinemaList()) {
                if (cinema.getId() == idCinema) {
                    return cinema;
                }
            }
        }
        return null;
    }
}
