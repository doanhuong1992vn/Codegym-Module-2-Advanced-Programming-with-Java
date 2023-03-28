package case_study_Enjoy_Galaxy.model.entity.movie_theater;

import case_study_Enjoy_Galaxy.model.entity.cinema.Cinema;

import java.util.List;

public abstract class MovieTheater {
    private String name;
    private String address;
    private List<Cinema> cinemas;

    protected MovieTheater(String name, String address) {
        this.name = name;
        this.address = address;
    }

    protected MovieTheater(String name, String address, List<Cinema> cinemas) {
        this.name = name;
        this.address = address;
        this.cinemas = cinemas;
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

    @Override
    public abstract String toString();
}
