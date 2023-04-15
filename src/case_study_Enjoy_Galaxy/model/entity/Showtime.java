package case_study_Enjoy_Galaxy.model.entity;

import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;
import case_study_Enjoy_Galaxy.model.utils.Converter;

import java.util.Date;

public class Showtime {
    private static long count = 0;
    private long id;
    private long idMovieTheater;
    private long idRoom;
    private String movieTheaterName;
    private String movieTheaterAddress;
    private String nameOfRoom;
    private Date showtime;
    private Date endTime;
    private long idMovie;
    private Movie movie;
    private double price;
    private Seat[][] seats;

    public Showtime(long id,
                    long idMovieTheater,
                    long idRoom,
                    String movieTheaterName,
                    String movieTheaterAddress,
                    String nameOfRoom,
                    Date showtime,
                    Date endTime,
                    Movie movie,
                    double price) {
        count++;
        this.id = id;
        this.idMovieTheater = idMovieTheater;
        this.idRoom = idRoom;
        this.movieTheaterName = movieTheaterName;
        this.movieTheaterAddress = movieTheaterAddress;
        this.nameOfRoom = nameOfRoom;
        this.showtime = showtime;
        this.endTime = endTime;
        this.movie = movie;
        this.idMovie = movie.getId();
        this.price = price;
    }

    public Showtime(long id, Date showtime, Date endTime, long idRoom, long idMovie) {
        this.id = id;
        this.idRoom = idRoom;
        this.showtime = showtime;
        this.endTime = endTime;
        this.idMovie = idMovie;
    }

    public static long getNewId() {
        return count + 1;
    }

    public void setIdRoom(long idRoom) {
        this.idRoom = idRoom;
    }

    public long getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(long idMovie) {
        this.idMovie = idMovie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdMovieTheater() {
        return idMovieTheater;
    }

    public void setIdMovieTheater(int idMovieTheater) {
        this.idMovieTheater = idMovieTheater;
    }

    public long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getMovieTheaterName() {
        return movieTheaterName;
    }


    public String getMovieTheaterAddress() {
        return movieTheaterAddress;
    }


    public String getNameOfRoom() {
        return nameOfRoom;
    }


    public Date getShowtime() {
        return showtime;
    }

    public void setShowtime(Date showtime) {
        this.showtime = showtime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Seat[][] getSeats() {
        return seats;
    }

    public void setSeats(Seat[][] seats) {
        this.seats = seats;
    }

    public long getStartShowtime() {
        return showtime.getTime();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return String.format("Suất chiếu %s từ %s tới %s tại phòng %s",
                getMovie().getName(),
                Converter.getDateFormat24H(getShowtime()),
                Converter.getDateFormat24H(getEndTime()),
                getNameOfRoom());
    }
}
