package case_study_Enjoy_Galaxy.model.entity.seat;

import case_study_Enjoy_Galaxy.model.abstraction.ICapacity;
import case_study_Enjoy_Galaxy.model.abstraction.IPrice;

public abstract class Seat implements ISeat, IPrice, ICapacity {
    private boolean ready = true;

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public boolean isReady() {
        return ready;
    }
}
