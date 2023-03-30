package case_study_Enjoy_Galaxy.model.service;

import case_study_Enjoy_Galaxy.model.builder.ticket_builder.ITicketBuilder;
import case_study_Enjoy_Galaxy.model.builder.ticket_builder.TicketConcreteBuilder;
import case_study_Enjoy_Galaxy.model.entity.Showtime;
import case_study_Enjoy_Galaxy.model.entity.Ticket;
import case_study_Enjoy_Galaxy.model.entity.cinema.abstraction.Cinema;
import case_study_Enjoy_Galaxy.model.entity.movie_theater.abstraction.MovieTheater;
import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TicketService {
    private static final TicketService ticketService = new TicketService();
    private TicketService() {
    }
    public static TicketService getInstance() {
        return ticketService;
    }
    public Ticket getTicket(int idShowtime, String seatCode) {
        MovieTheaterService movieTheaterService = MovieTheaterService.getInstance();
        for (MovieTheater movieTheater : movieTheaterService.getMovieTheaterList()) {
            for (Cinema cinema : movieTheater.getCinemaList()) {
                for (Showtime showtime : cinema.getShowtimeList()) {
                    if (idShowtime == showtime.getId()) {
                        for (Seat[] seatRow : showtime.getSeats()) {
                            for (Seat seat : seatRow) {
                                if (seatCode.equals(seat.getSeatCode())) {
                                    final String START_TIME_FORMAT = new SimpleDateFormat("dd MMMM yyyy hh:mm")
                                            .format(showtime.getDate());
                                    final long MOVIE_DURATION = showtime.getMovie().getMovieDuration() * 60 * 1000L;
                                    final long TIME_OF_CLEANING = 1000L * 60 * 15;
                                    final long TIME_OF_END_SHOWTIME =
                                            showtime.getStartShowtime()
                                            + MOVIE_DURATION
                                            + TIME_OF_CLEANING;
                                    Date endTimeOfShowtime = new Date(TIME_OF_END_SHOWTIME);
                                    final String END_TIME_FORMAT = new SimpleDateFormat("dd MMMM yyyy hh:mm")
                                            .format(endTimeOfShowtime);
                                    final double TOTAL_PRICE = cinema.getPrice() + seat.getPrice() * seat.getCapacity();
                                    UserService userService = UserService.getInstance();
                                    ITicketBuilder ticketBuilder = new TicketConcreteBuilder()
                                            .setUserName(userService.getCurrentUser().getFullName())
                                            .setIdMovieTheater(movieTheater.getId())
                                            .setMovieTheaterName(movieTheater.getName())
                                            .setMovieTheaterAddress(movieTheater.getAddress())
                                            .setIdCinema(cinema.getId())
                                            .setCinemaName(cinema.getName())
                                            .setMovieName(showtime.getMovie().getName())
                                            .setStartTime(START_TIME_FORMAT)
                                            .setEndTime(END_TIME_FORMAT)
                                            .setSeatCode(seatCode)
                                            .setPersonNumber(seat.getCapacity())
                                            .setPrice(TOTAL_PRICE);
                                    return ticketBuilder.buildFullOption();
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}