package case_study_Enjoy_Galaxy.model.entity.seat;

import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;

public class DeluxeSeat extends Seat {
    public DeluxeSeat(String seatCode) {
        super(seatCode);
    }

    public DeluxeSeat(long id, String type, String code, boolean ready, long idShowtime) {
        super(id, type, code, ready, idShowtime);
    }

    public DeluxeSeat(String type, long idShowtime, String code, boolean ready) {
        super(type, idShowtime, code, ready);
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
