package case_study_Enjoy_Galaxy.model.entity;

import case_study_Enjoy_Galaxy.model.utils.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {
    private static int count = 0;
    private long id;
    private String userName;
    private long idMovieTheater;
    private String nameOfMovieTheater;
    private String addressOfMovieTheater;
    private long idCinema;
    private String nameOfCinema;
    private String nameOfMovie;
    private int movieDuration;
    private String seatCode;
    private Date showtime;
    private Date endTime;
    private int numberOfPerson;
    private double price;
    private Date bookingTime;
    private boolean paid = false;
    private Date paymentTime;
    private boolean checked = false;

    public Ticket(String userName,
                  long idMovieTheater,
                  String nameOfMovieTheater,
                  String addressOfMovieTheater,
                  long idCinema,
                  String nameOfCinema,
                  String nameOfMovie,
                  int movieDuration,
                  String seatCode,
                  Date showtime,
                  Date endTime,
                  int numberOfPerson,
                  double price) {
        this.id = ++count;
        this.userName = userName;
        this.idMovieTheater = idMovieTheater;
        this.nameOfMovieTheater = nameOfMovieTheater;
        this.addressOfMovieTheater = addressOfMovieTheater;
        this.idCinema = idCinema;
        this.nameOfCinema = nameOfCinema;
        this.nameOfMovie = nameOfMovie;
        this.movieDuration = movieDuration;
        this.seatCode = seatCode;
        this.showtime = showtime;
        this.endTime = endTime;
        this.numberOfPerson = numberOfPerson;
        this.price = price;
    }


    public String getTicketCode() {
        StringBuilder codeMovieTheater = Converter.convertNameToCode(getNameOfMovieTheater());
        StringBuilder codeCinema = Converter.convertNameToCode(getNameOfCinema());
        StringBuilder codeMovie = Converter.convertNameToCode(getNameOfMovie());
        return "EG" + getId() + "-" +
                codeMovieTheater + getIdMovieTheater() + "-" +
                codeCinema + getIdCinema() + "-" +
                getSeatCode() + "-" +
                codeMovie;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
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

    public long getId() {
        return id;
    }

    public long getIdMovieTheater() {
        return idMovieTheater;
    }

    public String getNameOfMovieTheater() {
        return nameOfMovieTheater;
    }

    public String getAddressOfMovieTheater() {
        return addressOfMovieTheater;
    }

    public long getIdCinema() {
        return idCinema;
    }

    public String getNameOfCinema() {
        return nameOfCinema;
    }

    public String getNameOfMovie() {
        return nameOfMovie;
    }

    public void setSeatCode(String seatCode) {
        this.seatCode = seatCode;
    }

    public Date getShowtime() {
        return showtime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMovieDuration() {
        return movieDuration;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return String.format("Mã vé: %s. Giá: %s. Bán ngày: %s",
                getTicketCode(),
                Converter.formatPrice(getPrice()),
                new SimpleDateFormat("dd MMMM yyyy HH:mm:ss a").format(getPaymentTime()));
    }
}
