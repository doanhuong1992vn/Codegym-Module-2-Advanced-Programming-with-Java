package case_study_Enjoy_Galaxy.model.factory;

import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;
import case_study_Enjoy_Galaxy.model.entity.seat.DeluxeSeat;
import case_study_Enjoy_Galaxy.model.entity.seat.StandardSeat;
import case_study_Enjoy_Galaxy.model.entity.seat.SweetBox;
import case_study_Enjoy_Galaxy.model.entity.seat.VipSeat;

public class SeatFactory {
    private static final SeatFactory seatFactory = new SeatFactory();
    private SeatFactory(){
    }
    public static SeatFactory getInstance() {
        return seatFactory;
    }
    public Seat getSeat(String typeSeat, String seatCode) {
        String typeSeatToUpperCase = typeSeat.toUpperCase();
        switch (typeSeatToUpperCase) {
            case "SWEETBOX" -> {
                return new SweetBox(seatCode);
            }
            case "DELUXESEAT" -> {
                return new DeluxeSeat(seatCode);
            }
            case "VIPSEAT" -> {
                return new VipSeat(seatCode);
            }
            default -> {
                return new StandardSeat(seatCode);
            }
        }
    }
}
