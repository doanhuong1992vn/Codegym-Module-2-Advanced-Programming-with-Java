package case_study_Enjoy_Galaxy.model.entity;

public class Ticket {
    private String ticketCode;
    private double price;
    private final String nameOfCinemaSystem = "Enjoy Galaxy";
    private String nameOfMovieTheater;
    private String addressOfMovieTheater;
    private String nameOfCinema;
    private String nameOfMovie;
    private String seatCode;
    private String showtime;
    private int personNumber;
    private boolean paid = false;
    private boolean checked = false;

    public Ticket(String ticketCode, double price) {
        this.ticketCode = ticketCode;
        this.price = price;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public double getPrice() {
        return price;
    }

    public String getNameOfCinemaSystem() {
        return nameOfCinemaSystem;
    }

    public String getNameOfMovieTheater() {
        return nameOfMovieTheater;
    }

    public String getAddressOfMovieTheater() {
        return addressOfMovieTheater;
    }

    public String getNameOfCinema() {
        return nameOfCinema;
    }

    public String getNameOfMovie() {
        return nameOfMovie;
    }

    public String getSeatCode() {
        return seatCode;
    }

    public String getShowtime() {
        return showtime;
    }

    public int getPersonNumber() {
        return personNumber;
    }

    public boolean isPaid() {
        return paid;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
