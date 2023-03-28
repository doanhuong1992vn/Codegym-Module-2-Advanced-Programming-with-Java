package case_study_Enjoy_Galaxy.model.entity.users;

import case_study_Enjoy_Galaxy.model.entity.users.abstraction.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Customer extends User {
    private final List<String> ticketCodes = new ArrayList<>();

    public Customer(String phoneNumber, String email, String password) {
        super(phoneNumber, email, password);
    }

    public Customer(String fullName, String phoneNumber, String email, String password) {
        super(fullName, phoneNumber, email, password);
    }

    public String getTicketCode() {
        if (ticketCodes.isEmpty()) {
            return "Chưa mua vé";
        } else {
            return Arrays.toString(ticketCodes.toArray());
        }
    }

    public void setTicketCodesEmpty() {
        ticketCodes.clear();
    }

    public void addTicketCode(List<String> ticketCodes) {
        this.ticketCodes.addAll(ticketCodes);
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
