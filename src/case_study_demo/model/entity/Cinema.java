/*
package case_study_demo.model.entity;

public class Cinema {
    private String name;
    private int seatColumnNumber;
    private int seatRowNumber;
    private Seat[][] seats;

    public Cinema(String name, int seatRowNumber, int seatColumnNumber) {
        this.name = name;
        setSeats(seatRowNumber, seatColumnNumber);
    }

    private void createSeats(int seatRowNumber, int seatColumnNumber) {
        seats = new Seat[seatRowNumber][seatColumnNumber];
        for (int i = 0; i < seatRowNumber; i++) {
            for (int k = 0; k < seatColumnNumber; k++) {
                seats[i][k] = new Seat();
            }
        }
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
        createSeats(seatRowNumber, seatColumnNumber);
    }

    public int getSeatRowNumber() {
        return seatRowNumber;
    }

    public void setSeatRowNumber(int seatRowNumber) {
        this.seatRowNumber = seatRowNumber;
        createSeats(seatRowNumber, seatColumnNumber);
    }

    public void setSeats(int seatRowNumber, int seatColumnNumber) {
        this.seatColumnNumber = seatColumnNumber;
        this.seatRowNumber = seatRowNumber;
        createSeats(seatRowNumber, seatColumnNumber);
    }

    public int getSeatsNumber() {
        return seatColumnNumber * seatRowNumber;
    }

    @Override
    public String toString() {
        return "Phòng chiếu " + getName() + " có " + getSeatsNumber() + " ghế.";
    }
}
*/
