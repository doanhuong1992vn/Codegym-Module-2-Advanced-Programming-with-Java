package case_study_Enjoy_Galaxy.model.entity.cinema;

public class Cinema2D extends Cinema {
    public Cinema2D(String name) {
        super(name);
    }

    public Cinema2D(String name, int seatRowNumber, int seatColumnNumber) {
        super(name, seatRowNumber, seatColumnNumber);
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
