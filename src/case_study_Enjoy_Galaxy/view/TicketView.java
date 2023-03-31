package case_study_Enjoy_Galaxy.view;

public class TicketView {
    private static TicketView ticketView = new TicketView();
    private TicketView(){}
    public static TicketView getInstance() {
        return ticketView;
    }

    public void displayCheckingTicket() {
    }
}
