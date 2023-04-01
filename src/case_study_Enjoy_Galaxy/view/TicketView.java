package case_study_Enjoy_Galaxy.view;

import case_study_Enjoy_Galaxy.model.entity.Ticket;
import case_study_Enjoy_Galaxy.model.entity.users.abstraction.User;
import case_study_Enjoy_Galaxy.model.service.TicketService;
import case_study_Enjoy_Galaxy.model.service.UserService;
import case_study_Enjoy_Galaxy.model.utils.Input;

import java.text.ParseException;

public class TicketView {
    private static TicketView ticketView = new TicketView();

    private TicketView() {
    }

    public static TicketView getInstance() {
        return ticketView;
    }

    public void displayFeatureCheckingTicket() throws ParseException {
        User user = UserService.getInstance().getCurrentUser();
        if (user == null) {
            displayProcessCheckingTicket();
        } else {
            displayProcessCheckingTicketForUserSignedIn(user);
        }
    }

    private void displayProcessCheckingTicketForUserSignedIn(User user) throws ParseException {
        if (user.getTicketList().isEmpty()) {
            System.out.println("You don't have any tickets at the moment");
        } else {
            System.out.println("Here is your ticket code list:");
            for (Ticket ticket : user.getTicketList()) {
                System.out.println(ticket.getTicketCode());
            }
        }
        displayMenuCheckingTicket();
    }

    private void displayProcessCheckingTicket() throws ParseException {
        String ticketCode = Input.prompt("Enter your ticket code to checking: ");
        Ticket ticket = TicketService.getInstance().getTicketByTicketCode(ticketCode.trim());
        if (ticket == null) {
            System.out.println("Ticket code does not exist");
        } else {
            System.out.println(TicketService.getInstance().getFullInformationOfTicket(ticket));
        }
        displayMenuCheckingTicket();
    }

    private void displayMenuCheckingTicket() throws ParseException {
        System.out.println("""
                1. Checking ticket code
                2. Go back to home page""");
        do {
            int choice = Input.choiceIntegerPrompt("Enter your choice: ");
            switch (choice) {
                case 1 -> displayProcessCheckingTicket();
                case 2 -> EnjoyGalaxyView.getInstance().displayHomePageByUser();
                default -> System.out.println("Invalid input!");
            }
        } while (true);
    }

}
