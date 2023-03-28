package case_study_Enjoy_Galaxy.model.entity.seat;

public class StandardSeat extends Seat {
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
}
