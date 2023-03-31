package case_study_Enjoy_Galaxy.model.builder.ticket_builder;

import case_study_Enjoy_Galaxy.model.entity.Ticket;

import java.util.Date;

public class TicketConcreteBuilder implements ITicketBuilder {
    private String userName;
    private int idMovieTheater;
    private String movieTheaterName;
    private String movieTheaterAddress;
    private int idCinema;
    private String cinemaName;
    private String movieName;
    private int movieDuration;
    private String seatCode;
    private Date showtime;
    private Date endTime;
    private int personNumber;
    private double price;

    @Override
    public ITicketBuilder setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    @Override
    public ITicketBuilder setSeatCode(String seatCode) {
        this.seatCode = seatCode;
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
    public ITicketBuilder setMovieDuration(int movieDuration) {
        this.movieDuration = movieDuration;
        return this;
    }

    @Override
    public ITicketBuilder setShowtime(Date startTime) {
        this.showtime = startTime;
        return this;
    }

    @Override
    public ITicketBuilder setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    @Override
    public Ticket build() {
        return new Ticket(userName,
                idMovieTheater,
                movieTheaterName,
                movieTheaterAddress,
                idCinema,
                cinemaName,
                movieName,
                movieDuration,
                seatCode,
                showtime,
                endTime,
                personNumber,
                price);
    }
}
