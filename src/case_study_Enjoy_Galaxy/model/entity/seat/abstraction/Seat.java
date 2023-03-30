package case_study_Enjoy_Galaxy.model.entity.seat.abstraction;

import case_study_Enjoy_Galaxy.model.general_abstraction.ICapacity;
import case_study_Enjoy_Galaxy.model.general_abstraction.IPrice;

public abstract class Seat implements ISeat, IPrice, ICapacity {
    private String seatCode;
    private boolean ready = true;

    public Seat(String seatCode) {
        this.seatCode = seatCode;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public boolean isReady() {
        return ready;
    }

    @Override
    public String toString() {
        return seatCode;
    }
}
