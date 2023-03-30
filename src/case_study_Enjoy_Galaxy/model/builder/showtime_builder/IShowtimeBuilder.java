package case_study_Enjoy_Galaxy.model.builder.showtime_builder;

import case_study_Enjoy_Galaxy.model.entity.Movie;
import case_study_Enjoy_Galaxy.model.entity.Showtime;
import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;

import java.util.Date;

public interface IShowtimeBuilder {
    IShowtimeBuilder setIdMovieTheater(int idMovieTheater);
    IShowtimeBuilder setIdCinema(int idCinema);
    IShowtimeBuilder setMovieTheaterName(String movieTheaterName);
    IShowtimeBuilder setMovieTheaterAddress(String movieTheaterAddress);
    IShowtimeBuilder setCinemaName(String cinemaName);
    IShowtimeBuilder setDate(Date date);
    IShowtimeBuilder setMovie(Movie movie);
    IShowtimeBuilder setSeats(Seat[][] seats);
    Showtime build();
}
