package case_study_Enjoy_Galaxy.model.entity.movie_theater;

import case_study_Enjoy_Galaxy.model.entity.cinema.Cinema;

import java.util.List;

public class StandardMovieTheater extends MovieTheater{
    public StandardMovieTheater(String name, String address) {
        super(name, address);
    }

    public StandardMovieTheater(String name, String address, List<Cinema> cinemas) {
        super(name, address, cinemas);
    }
    @Override
    public String toString(){
        return "Rạp " + getName() + " có " + getCinemasNumber() + " phòng chiếu. Đ/c: " + getAddress();
    }
}
