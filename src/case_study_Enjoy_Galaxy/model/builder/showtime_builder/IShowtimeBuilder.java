package case_study_Enjoy_Galaxy.model.builder.showtime_builder;

import case_study_Enjoy_Galaxy.model.entity.Movie;
import case_study_Enjoy_Galaxy.model.entity.Showtime;
import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;

import java.util.Date;

public interface IShowtimeBuilder {
    IShowtimeBuilder setIdMovieTheater(long idMovieTheater);
    IShowtimeBuilder setIdRoom(long idCinema);
    IShowtimeBuilder setMovieTheaterName(String movieTheaterName);
    IShowtimeBuilder setMovieTheaterAddress(String movieTheaterAddress);
    IShowtimeBuilder setRoomName(String cinemaName);
    IShowtimeBuilder setShowtime(Date showtime);
    IShowtimeBuilder setEndTime(Date endTime);
    IShowtimeBuilder setMovie(Movie movie);
    IShowtimeBuilder setSeats(Seat[][] seats);
    IShowtimeBuilder setPrice(double price);
    Showtime build();
}
