package case_study_Enjoy_Galaxy.model.entity;

import case_study_Enjoy_Galaxy.model.utils.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {
    private static int count = 0;
    private int id;
    private String userName;
    private int idMovieTheater;
    private String movieTheaterName;
    private String movieTheaterAddress;
    private int idCinema;
    private String cinemaName;
    private String movieName;
    private int movieDuration;
    private String seatCode;
    private String startTime;
    private String endTime;
    private int numberOfPerson;
    private double price;
    private Date dateOfBooking;
    private boolean paid = false;
    private Date dateOfPayment;
    private boolean checked = false;

    public Ticket(String userName,
                  int idMovieTheater,
                  String movieTheaterName,
                  String movieTheaterAddress,
                  int idCinema,
                  String cinemaName,
                  String movieName,
                  int movieDuration,
                  String seatCode,
                  String startTime,
                  String endTime,
                  int numberOfPerson,
                  double price) {
        this.id = ++count;
        this.userName = userName;
        this.idMovieTheater = idMovieTheater;
        this.movieTheaterName = movieTheaterName;
        this.movieTheaterAddress = movieTheaterAddress;
        this.idCinema = idCinema;
        this.cinemaName = cinemaName;
        this.movieName = movieName;
        this.movieDuration = movieDuration;
        this.seatCode = seatCode;
        this.startTime = startTime;
        this.endTime = endTime;
        this.numberOfPerson = numberOfPerson;
        this.price = price;
    }


    public String getTicketCode() {
        StringBuilder codeMovieTheater = Converter.convertToCodeByName(getMovieTheaterName());
        StringBuilder codeCinema = Converter.convertToCodeByName(getCinemaName());
        StringBuilder codeMovie = Converter.convertToCodeByName(getMovieName());
        return "EG" + getId() + "-" +
                codeMovieTheater + getIdMovieTheater() + "-" +
                codeCinema + getIdCinema() + "-" +
                getSeatCode() + "-" +
                codeMovie;
    }

    public Date getDateOfBooking() {
        return dateOfBooking;
    }

    public void setDateOfBooking(Date dateOfBooking) {
        this.dateOfBooking = dateOfBooking;
    }

    public Date getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(Date dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public double getPrice() {
        return price;
    }


    public String getSeatCode() {
        return seatCode;
    }


    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public boolean isPaid() {
        return paid;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Ticket.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMovieTheater() {
        return idMovieTheater;
    }

    public void setIdMovieTheater(int idMovieTheater) {
        this.idMovieTheater = idMovieTheater;
    }

    public String getMovieTheaterName() {
        return movieTheaterName;
    }

    public void setMovieTheaterName(String movieTheaterName) {
        this.movieTheaterName = movieTheaterName;
    }

    public String getMovieTheaterAddress() {
        return movieTheaterAddress;
    }

    public void setMovieTheaterAddress(String movieTheaterAddress) {
        this.movieTheaterAddress = movieTheaterAddress;
    }

    public int getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(int idCinema) {
        this.idCinema = idCinema;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setSeatCode(String seatCode) {
        this.seatCode = seatCode;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setNumberOfPerson(int numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(int movieDuration) {
        this.movieDuration = movieDuration;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        final String DATE_OF_PAYMENT =
                getDateOfPayment() == null ?
                        "Chưa thanh toán" :
                        new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(getDateOfPayment());
        String paidStatus = String.format("""
                        Trạng thái thanh toán: Đã thanh toán
                        Ngày thanh toán: %s""",
                DATE_OF_PAYMENT);
        final String PRICE_FORMAT = Converter.formatPrice(getPrice());
        final String DATE_OF_BOOKING =
                getDateOfBooking() == null ?
                        "Chưa xác nhận" :
                        new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(getDateOfBooking());
        String simpleResult = String.format("""
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
                        Tổng thiệt hại: %s""",
                getUserName(),
                getTicketCode(),
                getMovieName(),
                getMovieDuration(),
                getStartTime(),
                getEndTime(),
                getSeatCode(),
                getNumberOfPerson(),
                getCinemaName(),
                getMovieTheaterName(),
                getMovieTheaterAddress(),
                DATE_OF_BOOKING,
                PRICE_FORMAT);
        if (isPaid()) {
            return simpleResult.concat(paidStatus);
        }
        return simpleResult;
    }
}
