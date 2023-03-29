package case_study_Enjoy_Galaxy.model.builder.ticket_builder;

import case_study_Enjoy_Galaxy.model.entity.Movie;
import case_study_Enjoy_Galaxy.model.entity.Ticket;
import case_study_Enjoy_Galaxy.model.entity.cinema.abstraction.Cinema;
import case_study_Enjoy_Galaxy.model.entity.movie_theater.abstraction.MovieTheater;

public class TicketConcreteBuilder implements ITicketBuilder{
    private MovieTheater movieTheater;
    private Cinema cinema;
    private Movie movie;
    private String seatCode;
    private String showtime;
    private int personNumber;
    private double price;
    @Override
    public ITicketBuilder setMovieTheater(MovieTheater movieTheater) {
        this.movieTheater = movieTheater;
        return this;
    }

    @Override
    public ITicketBuilder setCinema(Cinema cinema) {
        this.cinema = cinema;
        return this;
    }

    @Override
    public ITicketBuilder setMovie(Movie movie) {
        this.movie = movie;
        return this;
    }

    @Override
    public ITicketBuilder setSeatCode(String seatCode) {
        this.seatCode = seatCode;
        return this;
    }

    @Override
    public ITicketBuilder setShowtime(String showtime) {
        this.showtime = showtime;
        return this;
    }

    @Override
    public ITicketBuilder setPersonNumber(int personNumber) {
        this.personNumber = personNumber;
        return this;
    }

    @Override
    public ITicketBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    @Override
    public Ticket build() {
        return new Ticket(movieTheater, cinema, movie, seatCode, showtime, personNumber, price);
    }
}
