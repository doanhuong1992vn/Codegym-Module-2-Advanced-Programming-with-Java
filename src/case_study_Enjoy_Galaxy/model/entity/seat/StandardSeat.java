package case_study_Enjoy_Galaxy.model.entity.seat;

import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;

public class StandardSeat extends Seat {
    public StandardSeat(String seatCode) {
        super(seatCode);
    }

    public StandardSeat(String type, long idShowtime, String code, boolean ready) {
        super(type, idShowtime, code, ready);
    }

    public StandardSeat(long id, String type, String code, boolean ready, long idShowtime) {
        super(id, type, code, ready, idShowtime);
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

    @Override
    public String getSeatType() {
        return "Standard Seat";
    }
}
