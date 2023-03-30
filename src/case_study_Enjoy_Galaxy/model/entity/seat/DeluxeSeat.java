package case_study_Enjoy_Galaxy.model.entity.seat;

import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;

public class DeluxeSeat extends Seat {
    public DeluxeSeat(String seatCode) {
        super(seatCode);
    }

    @Override
    public int getCapacity() {
        return 1;
    }

    @Override
    public String howToSeat() {
        return "nằm thoải mái";
    }

    @Override
    public double getPrice() {
        return 90000;
    }

    @Override
    public String getSeatType() {
        return "Deluxe Seat";
    }
}
