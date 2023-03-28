package case_study_Enjoy_Galaxy.model.entity.cinema;

public class Cinema4DX extends Cinema {
    public Cinema4DX(String name) {
        super(name);
    }

    public Cinema4DX(String name, int seatRowNumber, int seatColumnNumber) {
        super(name, seatRowNumber, seatColumnNumber);
    }

    @Override
    public double getPrice() {
        return 30000;
    }
}
