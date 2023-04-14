package case_study_Enjoy_Galaxy.model.entity.cinema.abstraction;

import case_study_Enjoy_Galaxy.model.entity.Showtime;
import case_study_Enjoy_Galaxy.model.general_abstraction.ICapacity;
import case_study_Enjoy_Galaxy.model.general_abstraction.IPrice;
import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;
import case_study_Enjoy_Galaxy.model.factory.SeatFactory;

import java.util.*;

public abstract class Room implements ICapacity, IPrice {
    private static final String[] seatCodes =
            {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P"};
    protected static int count = 0;
    protected long id;
    protected String type;
    protected String name;
    private long idMovieTheater;
    protected int seatColumnNumber = 4;
    protected int seatRowNumber = 4;
    protected Seat[][] seats;
    protected List<Showtime> showtimeList = new ArrayList<>();

    protected Room(String name) {
        this.id = ++count;
        this.name = name;
        setSeats(seatRowNumber, seatColumnNumber);
    }

    protected Room(String name, int seatRowNumber, int seatColumnNumber) {
        this.id = ++count;
        this.name = name;
        setSeats(seatRowNumber, seatColumnNumber);
    }

    public Room(long id, String type, String name, int seatRowNumber, int seatColumnNumber, long idMovieTheater) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.seatColumnNumber = seatColumnNumber;
        this.seatRowNumber = seatRowNumber;
        this.idMovieTheater = idMovieTheater;
    }

    public long getIdMovieTheater() {
        return idMovieTheater;
    }

    public void setIdMovieTheater(long idMovieTheater) {
        this.idMovieTheater = idMovieTheater;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private void createSeats(int seatRowNumber, int seatColumnNumber) {
        seats = new Seat[seatRowNumber][seatColumnNumber];
        for (int i = 0; i < seatRowNumber; i++) {
            for (int k = 0; k < seatColumnNumber; k++) {
                SeatFactory seatFactory = SeatFactory.getInstance();
                String seatCode = seatCodes[i] + String.valueOf(k + 1);
                switch (i) {
                    case 0 -> seats[i][k] = seatFactory.getSeat("standard", seatCode);
                    case 1 -> seats[i][k] = seatFactory.getSeat("vipseat", seatCode);
                    case 2 -> seats[i][k] = seatFactory.getSeat("deluxeseat", seatCode);
                    default -> seats[i][k] = seatFactory.getSeat("sweetbox", seatCode);
                }
            }
        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Seat[][] getSeats() {
        return seats;
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

    public List<Showtime> getShowtimeList() {
        return showtimeList;
    }

    public void addShowtime(Showtime showtime) {
        showtimeList.add(showtime);
    }
    public abstract String getTypeCinema();

    @Override
    public int getCapacity() {
        return seatColumnNumber * seatRowNumber;
    }

    @Override
    public String toString() {
        return String.format("<ID = %d> Phòng chiếu %s có %d ghế đang có %d suất chiếu.",
                getId(), getName(), getCapacity(), getShowtimeList().size());
    }
}
