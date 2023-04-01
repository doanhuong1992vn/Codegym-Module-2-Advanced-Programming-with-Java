package case_study_Enjoy_Galaxy.model.builder.showtime_builder;

import case_study_Enjoy_Galaxy.model.entity.Movie;
import case_study_Enjoy_Galaxy.model.entity.Showtime;
import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;

import java.util.Date;

public class ShowtimeConcreteBuilder implements IShowtimeBuilder {
    private int idMovieTheater;
    private int idCinema;
    private String movieTheaterName;
    private String movieTheaterAddress;
    private String cinemaName;
    private Date date;
    private Movie movie;
    private double price;
    private Seat[][] seats;

    @Override
    public IShowtimeBuilder setIdMovieTheater(int idMovieTheater) {
        this.idMovieTheater = idMovieTheater;
        return this;
    }

    @Override
    public IShowtimeBuilder setIdCinema(int idCinema) {
        this.idCinema = idCinema;
        return this;
    }

    @Override
    public IShowtimeBuilder setMovieTheaterName(String movieTheaterName) {
        this.movieTheaterName = movieTheaterName;
        return this;
    }

    @Override
    public IShowtimeBuilder setMovieTheaterAddress(String movieTheaterAddress) {
        this.movieTheaterAddress = movieTheaterAddress;
        return this;
    }

    @Override
    public IShowtimeBuilder setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
        return this;
    }

    @Override
    public IShowtimeBuilder setDate(Date date) {
        this.date = date;
        return this;
    }

    @Override
    public IShowtimeBuilder setMovie(Movie movie) {
        this.movie = movie;
        return this;
    }

    @Override
    public IShowtimeBuilder setSeats(Seat[][] seats) {
        this.seats = seats;
        return this;
    }

    @Override
    public IShowtimeBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    @Override
    public Showtime build() {
        return new Showtime(
                idMovieTheater,
                idCinema,
                movieTheaterName,
                movieTheaterAddress,
                cinemaName,
                date,
                movie,
                price,
                seats);
    }
}
