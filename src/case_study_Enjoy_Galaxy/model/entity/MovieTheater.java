package case_study_Enjoy_Galaxy.model.entity;

import java.util.HashMap;

public class MovieTheater {
    private String name;
    private String address;
    private HashMap<String, Cinema> cinemas;

    public MovieTheater(String name, String address, HashMap<String, Cinema> cinemas) {
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

    public HashMap<String, Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(HashMap<String, Cinema> cinemas) {
        this.cinemas = cinemas;
    }

    public int getCinemasNumber() {
        return getCinemas().size();
    }

    @Override
    public String toString() {
        return "Rạp " + getName() + " có " + getCinemasNumber() + " phòng chiếu. Đ/c: " + getAddress();
    }
}
