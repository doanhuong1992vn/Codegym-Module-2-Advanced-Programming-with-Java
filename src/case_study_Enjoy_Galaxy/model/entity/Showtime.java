package case_study_Enjoy_Galaxy.model.entity;

import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;

import java.util.Date;

public class Showtime {
    private static int count = 0;
    private int id;
    private Date date;
    private Movie movie;
    private Seat[][] seats;

    public Showtime(Date date, Movie movie, Seat[][] seats) {
        this.id = ++count;
        this.date = date;
        this.movie = movie;
        this.seats = seats;
    }

    public long getTimeOfShowtime() {
        return date.getTime();
    }
}
