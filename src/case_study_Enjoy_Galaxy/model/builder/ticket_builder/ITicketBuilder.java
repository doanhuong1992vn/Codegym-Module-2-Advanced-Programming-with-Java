package case_study_Enjoy_Galaxy.model.builder.ticket_builder;

import case_study_Enjoy_Galaxy.model.entity.Movie;
import case_study_Enjoy_Galaxy.model.entity.Ticket;
import case_study_Enjoy_Galaxy.model.entity.cinema.abstraction.Cinema;
import case_study_Enjoy_Galaxy.model.entity.movie_theater.abstraction.MovieTheater;

public interface ITicketBuilder {
    ITicketBuilder setSeatCode(String seatCode);
    ITicketBuilder setPersonNumber(int personNumber);
    ITicketBuilder setPrice(double price);
    ITicketBuilder setUserName(String userName);
    ITicketBuilder setIdMovieTheater(int idMovieTheater);
    ITicketBuilder setMovieTheaterName(String movieTheaterName);
    ITicketBuilder setMovieTheaterAddress(String movieTheaterAddress);
    ITicketBuilder setIdCinema(int idCinema);
    ITicketBuilder setCinemaName(String cinemaName);
    ITicketBuilder setMovieName(String movieName);
    ITicketBuilder setMovieDuration(int movieDuration);
    ITicketBuilder setStartTime(String startTime);
    ITicketBuilder setEndTime(String endTime);
    Ticket build();
}
