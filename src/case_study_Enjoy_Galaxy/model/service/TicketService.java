package case_study_Enjoy_Galaxy.model.service;

import case_study_Enjoy_Galaxy.model.builder.ticket_builder.ITicketBuilder;
import case_study_Enjoy_Galaxy.model.builder.ticket_builder.TicketConcreteBuilder;
import case_study_Enjoy_Galaxy.model.entity.Showtime;
import case_study_Enjoy_Galaxy.model.entity.Ticket;
import case_study_Enjoy_Galaxy.model.entity.cinema.abstraction.Cinema;
import case_study_Enjoy_Galaxy.model.entity.movie_theater.abstraction.MovieTheater;
import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;
import case_study_Enjoy_Galaxy.model.entity.users.Customer;
import case_study_Enjoy_Galaxy.model.utils.Converter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketService {
    private static final List<Ticket> ticketList = new ArrayList<>();
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
                                    long timeOfShowtime = showtime.getShowtime().getTime();
                                    long timeOfMovieDuration = showtime.getMovie().getMovieDuration() * 60 * 1000L;
                                    long timeOfEndTime = timeOfShowtime + timeOfMovieDuration;
                                    Date endTime = new Date(timeOfEndTime);
                                    double totalPrice = cinema.getPrice() + seat.getPrice();
                                    UserService userService = UserService.getInstance();
                                    ITicketBuilder ticketBuilder = new TicketConcreteBuilder()
                                            .setUserName(userService.getCurrentUser().getFullName())
                                            .setIdMovieTheater(showtime.getIdMovieTheater())
                                            .setMovieTheaterName(showtime.getMovieTheaterName())
                                            .setMovieTheaterAddress(showtime.getMovieTheaterAddress())
                                            .setIdCinema(showtime.getIdCinema())
                                            .setCinemaName(showtime.getCinemaName())
                                            .setMovieName(showtime.getMovie().getName())
                                            .setMovieDuration(showtime.getMovie().getMovieDuration())
                                            .setShowtime(showtime.getShowtime())
                                            .setEndTime(endTime)
                                            .setSeatCode(seatCode)
                                            .setPersonNumber(seat.getCapacity())
                                            .setPrice(totalPrice);
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
        ticket.setBookingTime(new Date());
        ticketList.add(ticket);
        UserService userService = UserService.getInstance();
        Customer user = (Customer) userService.getCurrentUser();
        user.addTicket(ticket);
    }

    public void addTicketAfterPaid(Ticket ticket) {
        ticket.setPaid(true);
        ticket.setBookingTime(new Date());
        ticket.setPaymentTime(new Date());
        ticketList.add(ticket);
        UserService userService = UserService.getInstance();
        Customer user = (Customer) userService.getCurrentUser();
        user.addTicket(ticket);
    }

    public String getSimpleInformationOfTicket(Ticket ticket) {
        String showtimeFormat = Converter.getDateFormat24H(ticket.getShowtime());
        String endTimeFormat = Converter.getDateFormat24H(ticket.getEndTime());
        String price = Converter.formatPrice(ticket.getPrice());
        return String.format("""
                ***INFORMATION OF TICKET***
                Tên phim: %s
                Thời lượng: %d phút
                Thời gian chiếu: %s
                Thời gian kết thúc: %s
                Tên rạp: %s
                Tên phòng chiếu: %s
                Mã chỗ ngồi: %s
                Số người: %d
                Tổng thiệt hại: %s""",
                ticket.getNameOfMovie(),
                ticket.getMovieDuration(),
                showtimeFormat,
                endTimeFormat,
                ticket.getNameOfMovieTheater(),
                ticket.getNameOfCinema(),
                ticket.getSeatCode(),
                ticket.getNumberOfPerson(),
                price);
    }

    public String getFullInformationOfTicket(Ticket ticket) {
        String showtimeFormat = Converter.getDateFormat24H(ticket.getShowtime());
        String endTimeFormat = Converter.getDateFormat24H(ticket.getEndTime());
        String bookingTimeFormat = Converter.getDateFormat24H(ticket.getBookingTime());
        String priceFormat = Converter.formatPrice(ticket.getPrice());
        String paidStatus = ticket.isPaid() ? "Đã thanh toán" : "Chưa thanh toán";
        String information = String.format("""
                        ENJOY GALAXY MOVIE TICKET
                        Khách hàng: %s
                        Mã vé: %s
                        Tên phim: %s
                        Thời lượng: %d phút
                        Thời gian chiếu: %s
                        Thời gian kết thúc: %s
                        Mã chỗ ngồi: %s
                        Số người: %d
                        Tên phòng chiếu: %s
                        Tên rạp: %s
                        Địa chỉ rạp: %s
                        Ngày đặt vé: %s
                        Tổng thiệt hại: %s
                        Trạng thái thanh toán: %s""",
                ticket.getUserName(),
                ticket.getTicketCode(),
                ticket.getNameOfMovie(),
                ticket.getMovieDuration(),
                showtimeFormat,
                endTimeFormat,
                ticket.getSeatCode(),
                ticket.getNumberOfPerson(),
                ticket.getNameOfCinema(),
                ticket.getNameOfMovieTheater(),
                ticket.getAddressOfMovieTheater(),
                bookingTimeFormat,
                priceFormat,
                paidStatus);
        String paymentToString
                = String.format("""
                        
                        Ngày thanh toán: %s""",
                ticket.getPaymentTime() == null
                        ? "Chưa thanh toán"
                        : Converter.getDateFormat24H(ticket.getPaymentTime()));
        if (ticket.isPaid()) {
            return information.concat(paymentToString);
        }
        return information;
    }
}