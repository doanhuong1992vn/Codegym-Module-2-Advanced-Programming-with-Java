package case_study_Enjoy_Galaxy.model.entity.seat;

import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;

public class VipSeat extends Seat {
    public VipSeat(String seatCode) {
        super(seatCode);
    }

    public VipSeat(String type, long idShowtime, String code, boolean ready) {
        super(type, idShowtime, code, ready);
    }

    public VipSeat(long id, String type, String code, boolean ready, long idShowtime) {
        super(id, type, code, ready, idShowtime);
    }

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

    @Override
    public String getSeatType() {
        return "Vip Seat";
    }
}
