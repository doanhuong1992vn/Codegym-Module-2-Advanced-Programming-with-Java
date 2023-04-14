package case_study_Enjoy_Galaxy.model.entity.movie_theater;

import case_study_Enjoy_Galaxy.model.entity.movie_theater.abstraction.MovieTheater;

public class StandardMovieTheater extends MovieTheater {
    public StandardMovieTheater(String name, String address) {
        super(name, address);
    }

    public StandardMovieTheater(long id, String type, String name, String address) {
        super(id, type, name, address);
    }

    @Override
    public String toString(){
        return "ID = " + getId() +
                ": Rạp " + getName() +
                " có " + getCinemasNumber() + " phòng chiếu. " +
                "Đang có " + getShowtimeNumber() + " suất chiếu. " +
                "Địa chỉ: " + getAddress();
    }

    @Override
    public String getTypeMovieTheater() {
        return "STANDARD";
    }

    @Override
    public String getDetail() {
        return String.format("""
                ID rạp: %d
                Tên rạp: %s
                Loại rạp: %s
                Số phòng chiếu: %d
                Địa chỉ: %s
                """,
                getId(),
                getName(),
                getTypeMovieTheater(),
                getCinemasNumber(),
                getAddress());
    }
}
