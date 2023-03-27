package case_study_Enjoy_Galaxy.model.entity.seat;

import case_study_Enjoy_Galaxy.model.abstraction.Seat;

public class SweetBox extends Seat {
    @Override
    public String howToSeat() {
        return "ngồi ngọt ngào theo cặp đôi";
    }

    @Override
    public double getPrice() {
        return 100000;
    }

    @Override
    public int getCapacity() {
        return 2;
    }
}
