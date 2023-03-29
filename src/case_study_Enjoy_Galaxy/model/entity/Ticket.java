package case_study_Enjoy_Galaxy.model.entity;

import case_study_Enjoy_Galaxy.model.entity.cinema.abstraction.Cinema;
import case_study_Enjoy_Galaxy.model.entity.movie_theater.abstraction.MovieTheater;

public class Ticket {
    private static int count = 0;
    private int id;
    private String ticketCode;
    private MovieTheater movieTheater;
    private Cinema cinema;
    private Movie movie;
    private String seatCode;
    private String showtime;
    private int personNumber;
    private double price;
    private boolean paid = false;
    private boolean checked = false;

    public Ticket(MovieTheater movieTheater, Cinema cinema, Movie movie, String seatCode, String showtime, int personNumber, double price) {
        this.id = ++count;
        this.movieTheater = movieTheater;
        this.cinema = cinema;
        this.movie = movie;
        this.seatCode = seatCode;
        this.showtime = showtime;
        this.personNumber = personNumber;
        this.price = price;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public double getPrice() {
        return price;
    }

    public String getStringENJOYGALAXY() {
        return "ENJOY GALAXY";
    }

    public String getSeatCode() {
        return seatCode;
    }

    public String getShowtime() {
        return showtime;
    }

    public int getPersonNumber() {
        return personNumber;
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
}
