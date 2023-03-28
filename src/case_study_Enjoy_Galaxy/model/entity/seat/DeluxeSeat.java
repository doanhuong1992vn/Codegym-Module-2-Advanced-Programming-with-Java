package case_study_Enjoy_Galaxy.model.entity.seat;

public class DeluxeSeat extends Seat {
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
}
