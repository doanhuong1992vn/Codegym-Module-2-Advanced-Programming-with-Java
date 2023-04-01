package case_study_Enjoy_Galaxy.model.entity.users.abstraction;

import case_study_Enjoy_Galaxy.model.entity.Ticket;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private final List<Ticket> ticketList = new ArrayList<>();
    private String fullName;
    private String phoneNumber;
    private String email;
    private String password;
    private double wallet;

    protected User(String phoneNumber, String email, String password) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    protected User(String fullName, String phoneNumber, String email, String password) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public String getTicketCode() {
        if (ticketList.isEmpty()) {
            return "Chưa mua vé";
        } else {
            StringBuilder ticketCodes = new StringBuilder();
            for (Ticket ticket : ticketList) {
                ticketCodes.append(ticket.getTicketCode()).append("\t");
            }
            return ticketCodes.toString();
        }
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void addTicket(Ticket ticket) {
        this.ticketList.add(ticket);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public abstract String toString();
}
