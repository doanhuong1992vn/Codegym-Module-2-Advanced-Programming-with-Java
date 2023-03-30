package case_study_Enjoy_Galaxy.model.entity;

import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;

import java.util.Date;

public class Showtime {
    private static int count = 0;
    private int id;
    private int idMovieTheater;
    private int idCinema;
    private String movieTheaterName;
    private String movieTheaterAddress;
    private String cinemaName;
    private Date date;
    private Movie movie;
    private Seat[][] seats;

    public Showtime(int idMovieTheater,
                    int idCinema,
                    String movieTheaterName,
                    String movieTheaterAddress,
                    String cinemaName,
                    Date date,
                    Movie movie,
                    Seat[][] seats) {
        this.id = ++count;
        this.idMovieTheater = idMovieTheater;
        this.idCinema = idCinema;
        this.movieTheaterName = movieTheaterName;
        this.movieTheaterAddress = movieTheaterAddress;
        this.cinemaName = cinemaName;
        this.date = date;
        this.movie = movie;
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMovieTheater() {
        return idMovieTheater;
    }

    public void setIdMovieTheater(int idMovieTheater) {
        this.idMovieTheater = idMovieTheater;
    }

    public int getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(int idCinema) {
        this.idCinema = idCinema;
    }

    public String getMovieTheaterName() {
        return movieTheaterName;
    }

    public void setMovieTheaterName(String movieTheaterName) {
        this.movieTheaterName = movieTheaterName;
    }

    public String getMovieTheaterAddress() {
        return movieTheaterAddress;
    }

    public void setMovieTheaterAddress(String movieTheaterAddress) {
        this.movieTheaterAddress = movieTheaterAddress;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        return date.getTime();
    }
}
