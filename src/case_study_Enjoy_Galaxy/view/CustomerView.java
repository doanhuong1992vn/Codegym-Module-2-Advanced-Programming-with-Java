package case_study_Enjoy_Galaxy.view;

import case_study_Enjoy_Galaxy.model.service.UserService;
import case_study_Enjoy_Galaxy.model.utils.Input;
import case_study_Enjoy_Galaxy.view.abstraction.UserView;

import java.text.ParseException;

public class CustomerView extends UserView {
    private static final CustomerView customerView = new CustomerView();

    private CustomerView() {
    }

    public static CustomerView getInstance() {
        return customerView;
    }

    public void displayCustomerHomePage() throws ParseException {
        do {
            System.out.println("""
                        1. Search movie
                        2. Display movie list
                        3. Display movie theater list
                        4. Check ticket
                        5. View personal information
                        6. Sign out""");
            int choice = Input.choiceIntegerPrompt("Enter your choice:");
            switch (choice) {
                case 1 -> MovieView.getInstance().displaySearchingMovie();
                case 2 -> MovieView.getInstance().displayList();
                case 3 -> MovieTheaterView.getInstance().displayList();
                case 4 -> TicketView.getInstance().displayFeatureCheckingTicket();
                case 5 -> displayInformation();
                case 6 -> EnjoyGalaxyView.getInstance().signOut();
                default -> System.err.println("Invalid input!");
            }
        } while (true);
    }

    @Override
    public void displaySignUp() {
        String fullName = Input.prompt("Enter your full name:", FULL_NAME_PATTERN);
        String phoneNumber = Input.prompt("Enter your phone number:", PHONE_NUMBER_PATTERN);
        String email = Input.prompt("Enter your email:", EMAIL_PATTERN);
        String password = Input.prompt("Enter password:", PASSWORD);
        UserService userService = UserService.getInstance();
        userService.createCustomer(fullName, phoneNumber, email, password);
        System.out.println(userService.getNotification());
    }

    @Override
    public void displayInformation() {
        do {
            System.out.println(UserService.getInstance().getCurrentUser().toString());
            System.out.println("""
                    1. Edit full name
                    2. Edit phone number
                    3. Edit email
                    4. Edit password
                    5. Deposit money into wallet
                    6. Go back""");
            int choice = Input.choiceIntegerPrompt("Enter your choice:");
            switch (choice) {
                case 1 -> displayEditFullName();
                case 2 -> displayEditPhoneNumber();
                case 3 -> displayEditEmail();
                case 4 -> displayEditPassword();
                case 5 -> displayDepositMoney();
                case 6 -> {
                    return;
                }
                default -> System.err.println("Invalid input!");
            }
        } while (true);
    }
}
