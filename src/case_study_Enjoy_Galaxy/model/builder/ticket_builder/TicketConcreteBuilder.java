package case_study_Enjoy_Galaxy.model.builder.ticket_builder;

import case_study_Enjoy_Galaxy.model.entity.Movie;
import case_study_Enjoy_Galaxy.model.entity.Ticket;
import case_study_Enjoy_Galaxy.model.entity.cinema.abstraction.Cinema;
import case_study_Enjoy_Galaxy.model.entity.movie_theater.abstraction.MovieTheater;

public class TicketConcreteBuilder implements ITicketBuilder{
    private MovieTheater movieTheater;
    private int idMovieTheater;
    private String movieTheaterName;
    private String movieTheaterAddress;
    private Cinema cinema;
    private int idCinema;
    private String cinemaName;
    private Movie movie;
    private String movieName;
    private String seatCode;
    private String showtime;
    private String startTime;
    private String endTime;
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
    public ITicketBuilder setIdMovieTheater(int idMovieTheater) {
        this.idMovieTheater = idMovieTheater;
        return this;
    }

    @Override
    public ITicketBuilder setMovieTheaterName(String movieTheaterName) {
        this.movieTheaterName = movieTheaterName;
        return this;
    }

    @Override
    public ITicketBuilder setMovieTheaterAddress(String movieTheaterAddress) {
        this.movieTheaterAddress = movieTheaterAddress;
        return this;
    }

    @Override
    public ITicketBuilder setIdCinema(int idCinema) {
        this.idCinema = idCinema;
        return this;
    }

    @Override
    public ITicketBuilder setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
        return this;
    }

    @Override
    public ITicketBuilder setMovieName(String movieName) {
        this.movieName = movieName;
        return this;
    }

    @Override
    public ITicketBuilder setStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    @Override
    public ITicketBuilder setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    @Override
    public Ticket build() {
        return new Ticket(movieTheater,
                cinema,
                movie,
                seatCode,
                showtime,
                personNumber,
                price);
    }

    @Override
    public Ticket buildFullOption() {
        return new Ticket(idMovieTheater,
                movieTheaterName,
                movieTheaterAddress,
                idCinema,
                cinemaName,
                movieName,
                seatCode,
                startTime,
                endTime,
                personNumber,
                price);
    }
}
