package case_study_Enjoy_Galaxy.model.entity;

public class Cinema {
    private String name;
    private int seatColumnNumber;
    private int seatRowNumber;
    private Seat[][] seats;

    public Cinema(String name ,int seatColumnNumber, int seatRowNumber) {
        this.name = name;
        this.seatColumnNumber = seatColumnNumber;
        this.seatRowNumber = seatRowNumber;
        seats = new Seat[seatRowNumber][seatColumnNumber];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatColumnNumber() {
        return seatColumnNumber;
    }

    public void setSeatColumnNumber(int seatColumnNumber) {
        this.seatColumnNumber = seatColumnNumber;
        seats = new Seat[seatRowNumber][seatColumnNumber];
    }

    public int getSeatRowNumber() {
        return seatRowNumber;
    }

    public void setSeatRowNumber(int seatRowNumber) {
        this.seatRowNumber = seatRowNumber;
        seats = new Seat[seatRowNumber][seatColumnNumber];
    }

    public int getSeatsNumber() {
        return seatColumnNumber * seatRowNumber;
    }

    @Override
    public String toString() {
        return "Phòng chiếu " + getName() + " có " + getSeatsNumber() + " ghế.";
    }
}
