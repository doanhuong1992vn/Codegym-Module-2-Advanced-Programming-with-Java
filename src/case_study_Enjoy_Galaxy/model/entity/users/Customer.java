package case_study_Enjoy_Galaxy.model.entity.users;

import case_study_Enjoy_Galaxy.model.entity.Ticket;
import case_study_Enjoy_Galaxy.model.entity.users.abstraction.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Customer extends User {
    private final List<Ticket> ticketList = new ArrayList<>();

    public Customer(String phoneNumber, String email, String password) {
        super(phoneNumber, email, password);
    }

    public Customer(String fullName, String phoneNumber, String email, String password) {
        super(fullName, phoneNumber, email, password);
    }

    public String getTicketCode() {
        if (ticketList.isEmpty()) {
            return "Chưa mua vé";
        } else {
            StringBuilder ticketCodes = new StringBuilder();
            for (Ticket ticket : ticketList) {
                ticketCodes.append(ticket.getTicketCode()).append(" ");
            }
            return ticketCodes.toString();
        }
    }
    public void setTicketCodesEmpty() {
        ticketList.clear();
    }

    public void addTicket(Ticket ticket) {
        this.ticketList.add(ticket);
    }

    @Override
    public String toString() {
        return "Khách hàng " + getFullName() + " {"
                + "SĐT: " + getPhoneNumber() + ", "
                + "Email: " + getEmail() + ", "
                + "Tài khoản: " + getWallet() + " VNĐ, "
                + "Mã vé: " + getTicketCode() + "}";
    }
}
