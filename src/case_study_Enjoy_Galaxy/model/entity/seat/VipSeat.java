package case_study_Enjoy_Galaxy.model.entity.seat;

import case_study_Enjoy_Galaxy.model.abstraction.Seat;

public class VipSeat extends Seat {
    @Override
    public String howToSeat() {
        return "ngồi sang trọng";
    }

    @Override
    public double getPrice() {
        return 85000;
    }

    @Override
    public int getCapacity() {
        return 1;
    }
}
