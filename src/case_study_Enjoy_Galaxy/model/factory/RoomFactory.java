package case_study_Enjoy_Galaxy.model.factory;

import case_study_Enjoy_Galaxy.model.entity.cinema.*;
import case_study_Enjoy_Galaxy.model.entity.cinema.abstraction.Room;

public class RoomFactory {
    private static final RoomFactory ROOM_FACTORY = new RoomFactory();
    private RoomFactory(){
    }
    public static RoomFactory getInstance() {
        return ROOM_FACTORY;
    }
    public Room getRoom(long id, String type, String name, int numberRowSeat, int numberColumnSeat, long idMovieTheater) {
        String typeUP = type.toUpperCase();
        switch (typeUP) {
            case "2D" -> {
                return new Room2D(id, type, name, numberRowSeat, numberColumnSeat, idMovieTheater);
            }
            case "3D" -> {
                return new Room3D(id, type, name, numberRowSeat, numberColumnSeat, idMovieTheater);
            }
            case "4DX" -> {
                return new Room4DX(id, type, name, numberRowSeat, numberColumnSeat, idMovieTheater);
            }
            case "IMAX" -> {
                return new RoomIMAX(id, type, name, numberRowSeat, numberColumnSeat, idMovieTheater);
            }
            default -> {
                return null;
            }
        }
    }
}
