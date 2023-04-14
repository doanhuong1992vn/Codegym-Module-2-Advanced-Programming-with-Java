package case_study_Enjoy_Galaxy.model.entity.cinema;

import case_study_Enjoy_Galaxy.model.entity.cinema.abstraction.Room;

public class Room3D extends Room {
    public Room3D(String name) {
        super(name);
    }

    public Room3D(String name, int seatRowNumber, int seatColumnNumber) {
        super(name, seatRowNumber, seatColumnNumber);
    }

    public Room3D(long id, String type, String name, int seatColumnNumber, int seatRowNumber, long idMovieTheater) {
        super(id, type, name, seatColumnNumber, seatRowNumber, idMovieTheater);
    }

    @Override
    public double getPrice() {
        return 10000;
    }

    @Override
    public String getTypeCinema() {
        return "3D";
    }
}
