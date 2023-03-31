package case_study_Enjoy_Galaxy.model.service;

import case_study_Enjoy_Galaxy.model.builder.ticket_builder.ITicketBuilder;
import case_study_Enjoy_Galaxy.model.builder.ticket_builder.TicketConcreteBuilder;
import case_study_Enjoy_Galaxy.model.entity.Showtime;
import case_study_Enjoy_Galaxy.model.entity.Ticket;
import case_study_Enjoy_Galaxy.model.entity.cinema.abstraction.Cinema;
import case_study_Enjoy_Galaxy.model.entity.movie_theater.abstraction.MovieTheater;
import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;
import case_study_Enjoy_Galaxy.model.entity.users.Customer;
import case_study_Enjoy_Galaxy.model.entity.users.abstraction.User;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketService {
    private static final List<Ticket> TICKET_LIST = new ArrayList<>();
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
                                    final String START_TIME_FORMAT = DateFormat.getTimeInstance(DateFormat.SHORT)
                                            .format(showtime.getDate());
                                    final long MOVIE_DURATION = showtime.getMovie().getMovieDuration() * 60 * 1000L;
                                    final long TIME_OF_END_SHOWTIME =
                                            showtime.getStartShowtime()
                                            + MOVIE_DURATION;
                                    Date endTimeOfShowtime = new Date(TIME_OF_END_SHOWTIME);
                                    final String END_TIME_FORMAT = DateFormat.getTimeInstance(DateFormat.SHORT)
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
                                            .setMovieDuration(showtime.getMovie().getMovieDuration())
                                            .setStartTime(START_TIME_FORMAT)
                                            .setEndTime(END_TIME_FORMAT)
                                            .setSeatCode(seatCode)
                                            .setPersonNumber(seat.getCapacity())
                                            .setPrice(TOTAL_PRICE);
                                    return ticketBuilder.build();
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public void addTicketWithoutPayment(Ticket ticket) {
        ticket.setDateOfBooking(new Date());
        TICKET_LIST.add(ticket);
        UserService userService = UserService.getInstance();
        Customer user = (Customer) userService.getCurrentUser();
        user.addTicket(ticket);
    }

    public void addTicketAfterPaid(Ticket ticket) {
        ticket.setPaid(true);
        ticket.setDateOfBooking(new Date());
        ticket.setDateOfPayment(new Date());
        TICKET_LIST.add(ticket);
        UserService userService = UserService.getInstance();
        Customer user = (Customer) userService.getCurrentUser();
        user.addTicket(ticket);
    }


}