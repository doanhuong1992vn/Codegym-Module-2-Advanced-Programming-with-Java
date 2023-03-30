package case_study_Enjoy_Galaxy.model.entity.seat;

import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;

public class StandardSeat extends Seat {
    public StandardSeat(String seatCode) {
        super(seatCode);
    }

    @Override
    public String howToSeat() {
        return "ngồi tiêu chuẩn";
    }

    @Override
    public double getPrice() {
        return 70000;
    }

    @Override
    public int getCapacity() {
        return 1;
    }
}
