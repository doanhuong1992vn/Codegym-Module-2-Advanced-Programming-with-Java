package case_study_Enjoy_Galaxy.model.entity.movie_theater.abstraction;

import case_study_Enjoy_Galaxy.model.entity.cinema.abstraction.Cinema;

import java.util.ArrayList;
import java.util.List;

public abstract class MovieTheater {
    private static int count = 0;
    private int id;
    private String name;
    private String address;
    private List<Cinema> cinemas;

    protected MovieTheater(String name, String address) {
        this.id = ++count;
        this.name = name;
        this.address = address;
        cinemas = new ArrayList<>();
    }
    public void addCinema(Cinema cinema) {
        cinemas.add(cinema);
    }
    public int getId() {
        return id;
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

    public List<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(List<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

    public int getCinemasNumber() {
        return getCinemas().size();
    }

    public abstract String getTypeMovieTheater();

    public abstract String getDetail();

    @Override
    public abstract String toString();
}
