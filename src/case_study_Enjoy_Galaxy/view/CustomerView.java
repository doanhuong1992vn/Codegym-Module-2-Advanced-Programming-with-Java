package case_study_Enjoy_Galaxy.view;

import case_study_Enjoy_Galaxy.model.entity.users.User;
import case_study_Enjoy_Galaxy.model.service.UserService;
import case_study_Enjoy_Galaxy.model.utils.Input;
import case_study_Enjoy_Galaxy.view.abstraction.UserView;

public class CustomerView extends UserView {
    private static final CustomerView customerView = new CustomerView();

    private CustomerView() {
    }

    public static CustomerView getInstance() {
        return customerView;
    }

    @Override
    public void displaySignUp() {
        String fullName = Input.prompt("Enter your full name:", FULL_NAME_PATTERN);
        String phoneNumber = Input.prompt("Enter your phone number:", PHONE_NUMBER_PATTERN);
        String email = Input.prompt("Enter your email:", EMAIL_PATTERN);
        String password = Input.prompt("Enter password:");
        UserService userService = UserService.getInstance();
        if (userService.createAccount(fullName, phoneNumber, email, password, "customer")) {
            System.out.println(userService.getNotification());
            User user = userService.getCurrentUser();
            EnjoyGalaxyView enjoyGalaxyView = EnjoyGalaxyView.getInstance();
            enjoyGalaxyView.displayCustomerHomePage(user);
        } else {
            System.out.println(userService.getNotification());
            displaySignUp();
        }
    }

    @Override
    public void displayInformation(User user) {
        do {
            System.out.println(user.toString());
            System.out.println("""
                    1. Edit full name
                    2. Edit phone number
                    3. Edit email
                    4. Edit password
                    5. Deposit money into wallet
                    6. Go back""");
            int choice = Input.choiceIntegerPrompt("Enter your choice:");
            switch (choice) {
                case 1 -> displayEditFullName(user);
                case 2 -> displayEditPhoneNumber(user);
                case 3 -> displayEditEmail(user);
                case 4 -> displayEditPassword(user);
                case 5 -> displayDepositMoney(user);
                case 6 -> {
                    return;
                }
                default -> System.err.println("Invalid input!");
            }
        } while (true);
    }

    private void displayDepositMoney(User user) {
        do {
            try {
                double money = Double.parseDouble(Input.prompt("Enter the amount you want to deposit:"));
                user.setWallet(money);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! " + e.getMessage());
            }
        } while (true);
    }

}
