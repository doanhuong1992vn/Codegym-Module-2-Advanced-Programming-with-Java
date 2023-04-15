package case_study_Enjoy_Galaxy.model.entity.seat;

import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;

public class SweetBox extends Seat {
    public SweetBox(String seatCode) {
        super(seatCode);
    }

    public SweetBox(String type, long idShowtime, String code, boolean ready) {
        super(type, idShowtime, code, ready);
    }

    public SweetBox(long id, String type, String code, boolean ready, long idShowtime) {
        super(id, type, code, ready, idShowtime);
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
