package case_study_Enjoy_Galaxy.model.entity.cinema;

import case_study_Enjoy_Galaxy.model.entity.cinema.abstraction.Cinema;

public class Cinema3D extends Cinema {
    public Cinema3D(String name) {
        super(name);
    }

    public Cinema3D(String name, int seatRowNumber, int seatColumnNumber) {
        super(name, seatRowNumber, seatColumnNumber);
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
