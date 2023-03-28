package case_study_Enjoy_Galaxy.model.entity.cinema;

import case_study_Enjoy_Galaxy.model.entity.cinema.abstraction.Cinema;

public class CinemaIMAX extends Cinema {
    public CinemaIMAX(String name) {
        super(name);
    }

    public CinemaIMAX(String name, int seatRowNumber, int seatColumnNumber) {
        super(name, seatRowNumber, seatColumnNumber);
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
