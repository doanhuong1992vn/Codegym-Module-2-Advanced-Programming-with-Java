package case_study_Enjoy_Galaxy.view;

import case_study_Enjoy_Galaxy.model.entity.Ticket;
import case_study_Enjoy_Galaxy.model.service.AdminService;
import case_study_Enjoy_Galaxy.model.service.TicketService;
import case_study_Enjoy_Galaxy.model.service.UserService;
import case_study_Enjoy_Galaxy.model.utils.Converter;
import case_study_Enjoy_Galaxy.model.utils.Input;
import case_study_Enjoy_Galaxy.view.abstraction.UserView;

import java.text.ParseException;

public class StaffView extends UserView {
    private static final StaffView staffView = new StaffView();
    private StaffView() {
    }
    public static StaffView getInstance() {
        return staffView;
    }

    public void displayStaffHomePage() throws ParseException {
        System.out.println("""
                1. Sign out
                2. Checkin vé cho khách
                3. Thanh toán vé cho khách
                4. Xem thông tin bản thân""");
        do {
            int choice = Input.choiceIntegerPrompt("Enter your choice: ");
            switch (choice) {
                case 1 -> EnjoyGalaxyView.getInstance().signOut();
                case 2 -> displayCheckingTicketFeature();
                case 3 -> displayPaymentFeature();
                case 4 -> displayInformation();
                default -> System.out.println("Invalid input!");
            }
        } while (true);
    }

    @Override
    public void displayInformation() throws ParseException {
        System.out.println(UserService.getInstance().getCurrentUser());
        displayStaffHomePage();
    }

    @Override
    public void displaySignUp() {
    }

    public void displayCheckingTicketFeature() throws ParseException {
        String ticketCode = Input.prompt("Nhập mã vé: ");
        TicketService ticketService = TicketService.getInstance();
        Ticket ticket = ticketService.getTicketByTicketCode(ticketCode);
        if (ticket == null) {
            System.out.println("Mã vé " + ticketCode + " không tồn tại.");
        } else if (ticket.isChecked()){
            System.out.println("Mã vé " + ticketCode + " đã được checkin trước đó rồi.");
        } else if (ticket.isPaid()) {
            if (ticketService.isValidTimeToCheckinThisTicket(ticket)) {
                ticketService.checkinTicket(ticket);
                System.out.println("Checkin thành công cho khách hàng " + ticket.getUserName() +
                        " với mã vé " + ticketCode);
            } else {
                String checkinTime = ticketService.getFormatOfCheckinTime(ticket);
                System.out.println("Chưa đến giờ checkin. Báo khách quay lại lúc " + checkinTime);
            }
        } else {
            System.out.println("Mã vé " + ticketCode + " chưa được thanh toán. Báo khách qua quầy thanh toán.");
        }
        displayStaffHomePage();
    }

    public void displayPaymentFeature() throws ParseException {
        String ticketCode = Input.prompt("Nhập mã vé: ");
        TicketService ticketService = TicketService.getInstance();
        Ticket ticket = ticketService.getTicketByTicketCode(ticketCode);
        if (ticket == null) {
            System.out.println("Mã vé " + ticketCode + " không tồn tại.");
        } else if (ticket.isPaid()) {
            System.out.println("Mã vé " + ticketCode + " đã được thanh toán trước đó rôi.");
        } else {
            String amount = Converter.formatPrice(ticket.getPrice());
            System.out.println("Thông báo với khách số tiền cần thu là: " + amount);
            System.out.println("Đang thu tiền...............");
            AdminService.getInstance().depositMoney(ticket.getPrice());
            ticketService.setPaidAndPaymentTime(ticket);
            System.out.println("Nói lời cảm ơn với khách");
            String checkinTime = ticketService.getFormatOfCheckinTime(ticket);
            System.out.println("Báo với khách có thể checkin lúc " + checkinTime +
                    " tại phòng chiếu " + ticket.getNameOfCinema());
        }
        displayStaffHomePage();
    }
}
