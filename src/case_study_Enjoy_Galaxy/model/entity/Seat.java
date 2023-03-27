package case_study_Enjoy_Galaxy.model.entity;

public class Seat {
    private boolean ready = true;

    public Seat() {
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public boolean isReady() {
        return ready;
    }
}
