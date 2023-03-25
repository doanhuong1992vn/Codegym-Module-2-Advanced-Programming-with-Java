package case_study_Enjoy_Galaxy.model.entity;

public class Ticket {
    private String ticketCode;
    private double price;


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
}
