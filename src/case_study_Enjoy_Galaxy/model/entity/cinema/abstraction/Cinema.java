package case_study_Enjoy_Galaxy.model.entity.cinema.abstraction;

import case_study_Enjoy_Galaxy.model.general_abstraction.ICapacity;
import case_study_Enjoy_Galaxy.model.general_abstraction.IPrice;
import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;
import case_study_Enjoy_Galaxy.model.entity.Movie;
import case_study_Enjoy_Galaxy.model.factory.SeatFactory;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.TreeMap;

public abstract class Cinema implements ICapacity, IPrice {
    private String name;
    private int seatColumnNumber = 4;
    private int seatRowNumber = 4;
    private Seat[][] seats;
    private TreeMap<Date, Movie> showTimeList = new TreeMap<>(Comparator.comparingLong(Date::getTime));

    protected Cinema(String name) {
        this.name = name;
        setSeats(seatRowNumber, seatColumnNumber);
    }

    protected Cinema(String name, int seatRowNumber, int seatColumnNumber) {
        this.name = name;
        setSeats(seatRowNumber, seatColumnNumber);
    }

    private void createSeats(int seatRowNumber, int seatColumnNumber) {
        seats = new Seat[seatRowNumber][seatColumnNumber];
        for (int i = 0; i < seatRowNumber; i++) {
            for (int k = 0; k < seatColumnNumber; k++) {
                SeatFactory seatFactory = SeatFactory.getInstance();
                switch (i) {
                    case 0 -> seats[i][k] = seatFactory.getSeat("standard");
                    case 1 -> seats[i][k] = seatFactory.getSeat("vipseat");
                    case 2 -> seats[i][k] = seatFactory.getSeat("deluxeseat");
                    default -> seats[i][k] = seatFactory.getSeat("sweetbox");
                }

            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatColumnNumber() {
        return seatColumnNumber;
    }

    public void setSeatColumnNumber(int seatColumnNumber) {
        this.seatColumnNumber = seatColumnNumber;
        createSeats(seatRowNumber, seatColumnNumber);
    }

    public int getSeatRowNumber() {
        return seatRowNumber;
    }

    public void setSeatRowNumber(int seatRowNumber) {
        this.seatRowNumber = seatRowNumber;
        createSeats(seatRowNumber, seatColumnNumber);
    }

    public void setSeats(int seatRowNumber, int seatColumnNumber) {
        this.seatColumnNumber = seatColumnNumber;
        this.seatRowNumber = seatRowNumber;
        createSeats(seatRowNumber, seatColumnNumber);
    }

    public TreeMap<Date, Movie> getShowTimeList() {
        return showTimeList;
    }
    public abstract String getTypeCinema();

    @Override
    public int getCapacity() {
        return seatColumnNumber * seatRowNumber;
    }

    @Override
    public String toString() {
        return "Phòng chiếu " + getName() + " có " + getCapacity() + " ghế.";
    }
}