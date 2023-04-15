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
    protected long id;
    protected String type;
    protected String name;
    private long idMovieTheater;
    protected int columnSeat = 4;
    protected int rowSeat = 4;
    protected Seat[][] seats;
    protected List<Showtime> showtimeList = new ArrayList<>();

    public Room(long id, String type, String name, int rowSeat, int columnSeat, long idMovieTheater) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.columnSeat = columnSeat;
        this.rowSeat = rowSeat;
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

    public int getColumnSeat() {
        return columnSeat;
    }

    public int getRowSeat() {
        return rowSeat;
    }

    public List<Showtime> getShowtimeList() {
        return showtimeList;
    }

    public void setShowtimeList(List<Showtime> showtimeList) {
        this.showtimeList = showtimeList;
    }

    public void addShowtime(Showtime showtime) {
        showtimeList.add(showtime);
    }
    public abstract String getTypeCinema();

    @Override
    public int getCapacity() {
        return columnSeat * rowSeat;
    }

    @Override
    public String toString() {
        return String.format("<ID = %d> Phòng chiếu %s có %d ghế đang có %d suất chiếu.",
                getId(), getName(), getCapacity(), getShowtimeList().size());
    }
}
