package case_study_Enjoy_Galaxy.model.entity.seat;

import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;

public class SweetBox extends Seat {
    public SweetBox(String seatCode) {
        super(seatCode);
    }

    @Override
    public String howToSeat() {
        return "cho cặp đôi chim chuột nhau";
    }

    @Override
    public double getPrice() {
        return 200000;
    }

    @Override
    public int getCapacity() {
        return 2;
    }

    @Override
    public String getSeatType() {
        return "Sweet Box";
    }
}
