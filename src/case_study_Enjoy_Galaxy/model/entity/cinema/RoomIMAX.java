package case_study_Enjoy_Galaxy.model.entity.cinema;

import case_study_Enjoy_Galaxy.model.entity.cinema.abstraction.Room;

public class RoomIMAX extends Room {
    public RoomIMAX(long id, String type, String name, int seatColumnNumber, int seatRowNumber, long idMovieTheater) {
        super(id, type, name, seatColumnNumber, seatRowNumber, idMovieTheater);
    }

    @Override
    public double getPrice() {
        return 50000;
    }

    @Override
    public String getTypeCinema() {
        return "IMAX";
    }
}
