package case_study_Enjoy_Galaxy.model.service;

import case_study_Enjoy_Galaxy.model.builder.ticket_builder.ITicketBuilder;
import case_study_Enjoy_Galaxy.model.builder.ticket_builder.TicketConcreteBuilder;
import case_study_Enjoy_Galaxy.model.entity.Showtime;
import case_study_Enjoy_Galaxy.model.entity.Ticket;
import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;
import case_study_Enjoy_Galaxy.model.entity.users.Customer;
import case_study_Enjoy_Galaxy.model.entity.users.abstraction.User;
import case_study_Enjoy_Galaxy.model.utils.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TicketService {
    private static final List<Ticket> ticketList = new ArrayList<>();
    private static final TicketService ticketService = new TicketService();

    private TicketService() {
    }

    public static TicketService getInstance() {
        return ticketService;
    }


    public Ticket getTicket(int idShowtime, String seatCode) {
        Showtime showtime = MovieTheaterService.getInstance().getShowtimeById(idShowtime);
        for (Seat[] rowOfSeats : showtime.getSeats()) {
            for (Seat seat : rowOfSeats) {
                if (seatCode.equals(seat.getSeatCode())) {
                    double totalPrice = showtime.getPrice() + seat.getPrice();
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
                            .setEndTime(showtime.getEndTime())
                            .setSeatCode(seatCode)
                            .setPersonNumber(seat.getCapacity())
                            .setPrice(totalPrice);
                    return ticketBuilder.build();
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
        User user = userService.getCurrentUser();
        user.addTicket(ticket);
    }

    public void setPaidAndPaymentTime(Ticket ticket) {
        ticket.setPaid(true);
        ticket.setPaymentTime(new Date());
    }

    public String getDemoTicketAfterConfirm(Ticket ticket) {
        String showtimeFormat = Converter.getDateFormat24H(ticket.getShowtime());
        String endTimeFormat = Converter.getDateFormat24H(ticket.getEndTime());
        String price = Converter.formatPrice(ticket.getPrice());
        return String.format("""
                        ***INFORMATION OF DEMO TICKET***
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
        String checkinStatus = ticket.isChecked() ? "Đã checkin" : "Chưa checkin";
        String paymentTime = ticket.getPaymentTime() == null
                ? "Chưa thanh toán"
                : Converter.getDateFormat24H(ticket.getPaymentTime());
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
        String paymentToString = String.format("""                    
                        \nNgày thanh toán: %s
                        Trạng thái checkin: %s""",
                paymentTime,
                checkinStatus);
        if (ticket.isPaid()) {
            return information.concat(paymentToString);
        }
        final String PROMPT_ABOUT_PAYMENT = "\nVui lòng thanh toán tại quầy trước khi checkin";
        return information.concat(PROMPT_ABOUT_PAYMENT);
    }

    public Ticket getTicketByTicketCode(String ticketCode) {
        for (Ticket ticket : ticketList) {
            if (ticket.getTicketCode().equals(ticketCode.trim())) {
                return ticket;
            }
        }
        return null;
    }

    public StringBuilder getInformationOfRevenueByMonth(String monthAndYear) throws ParseException {
        StringBuilder result = new StringBuilder();
        double revenue = 0;
        Date dateInput = new SimpleDateFormat("MM/yyyy").parse(monthAndYear);
        for (Ticket ticket : ticketList) {
            if (ticket.isPaid()) {
                boolean isSameMonth = dateInput.getMonth() == ticket.getPaymentTime().getMonth();
                boolean isSameYear = dateInput.getYear() == ticket.getPaymentTime().getYear();
                if (isSameMonth && isSameYear) {
                    result.append(ticket).append("\n");
                    revenue += ticket.getPrice();
                }
            }
        }
        if (result.isEmpty()) {
            final String NOTIFICATION = "Tháng " + monthAndYear + " không bán được cái mẹ gì hết T_T";
            result.append(NOTIFICATION);
            return result;
        }
        final String NOTIFICATION_OF_TICKET_LIST = "Danh sách vé bán được trong tháng " + monthAndYear + ":\n";
        result.insert(0, NOTIFICATION_OF_TICKET_LIST);
        String revenueFormat = Converter.formatPrice(revenue);
        final String NOTIFICATION_OF_REVENUE = "Tổng doanh thu trong tháng " + monthAndYear + " là " + revenueFormat;
        result.append(NOTIFICATION_OF_REVENUE);
        return result;
    }

    public boolean isValidTimeToCheckinThisTicket(Ticket ticket) {
        final long TIME_OF_FIFTEEN_MINUTES = 15 * 60 * 1000L;
        return ticket.getShowtime().getTime() - TIME_OF_FIFTEEN_MINUTES < new Date().getTime();
    }

    public void checkinTicket(Ticket ticket) {
        ticket.setChecked(true);
    }

    public String getFormatOfCheckinTime(Ticket ticket) {
        final long TIME_OF_FIFTEEN_MINUTES = 15 * 60 * 1000L;
        long checkinTime = ticket.getShowtime().getTime() - TIME_OF_FIFTEEN_MINUTES;
        return Converter.getDateFormat24H(new Date(checkinTime));
    }
}