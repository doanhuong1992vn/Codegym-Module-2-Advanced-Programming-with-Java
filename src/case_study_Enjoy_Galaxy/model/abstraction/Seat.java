package case_study_Enjoy_Galaxy.model.abstraction;

public abstract class Seat implements ISeat, IPrice, ICapacity {
    private boolean ready = true;

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public boolean isReady() {
        return ready;
    }
}
