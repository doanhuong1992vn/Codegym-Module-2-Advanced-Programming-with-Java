package case_study_Enjoy_Galaxy.model.entity.movie_theater.abstraction;

import case_study_Enjoy_Galaxy.model.entity.cinema.abstraction.Room;

import java.util.ArrayList;
import java.util.List;

public abstract class MovieTheater {
    private static int count = 0;
    private long id;
    private String type;
    private String name;
    private String address;
    private List<Room> rooms;

    protected MovieTheater(String name, String address) {
        this.id = ++count;
        this.name = name;
        this.address = address;
        rooms = new ArrayList<>();
    }

    public MovieTheater(long id, String type, String name, String address) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.address = address;
        rooms = new ArrayList<>();
    }

    public void addCinema(Room room) {
        rooms.add(room);
    }
    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Room> getCinemaList() {
        return rooms;
    }

    public void setCinemas(List<Room> rooms) {
        this.rooms = rooms;
    }

    public int getCinemasNumber() {
        return getCinemaList().size();
    }

    public int getShowtimeNumber() {
        int number = 0;
        for (Room room : getCinemaList()) {
            number += room.getShowtimeList().size();
        }
        return number;
    }

    public abstract String getTypeMovieTheater();

    public abstract String getDetail();

    @Override
    public abstract String toString();
}
