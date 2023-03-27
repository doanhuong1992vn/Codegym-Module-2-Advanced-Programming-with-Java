/*
package case_study_demo.view;

import case_study_demo.model.entity.users.Admin;
import case_study_demo.model.entity.users.Staff;
import case_study_demo.model.entity.users.User;
import case_study_demo.model.service.UserService;
import case_study_demo.model.utils.Input;

public class CustomerView {
    private static User currentUser;
    private static final String FULL_NAME_PATTERN = "FULL_NAME";
    private static final String PHONE_NUMBER_PATTERN = "PHONE_NUMBER";
    private static final String EMAIL_PATTERN = "EMAIL";
    public static void displaySignUp() {
        String fullName = Input.prompt("Enter your full name:", FULL_NAME_PATTERN);
        String phoneNumber = Input.prompt("Enter your phone number:", PHONE_NUMBER_PATTERN);
        String email = Input.prompt("Enter your email:", EMAIL_PATTERN);
        String password = Input.prompt("Enter password:");
        UserService userService = new UserService();
        if (userService.createCustomerAccount(fullName, phoneNumber, email, password)) {
            System.out.println(userService.getNotification());
            currentUser = userService.getCurrentUser();
            EnjoyGalaxyView.displayCustomerHomePage();
        } else {
            System.out.println(userService.getNotification());
            displaySignUp();
        }
    }

    public static void displaySignIn() {
        String username = Input.prompt("Enter email or phone number to sign in:");
        String password = Input.prompt("Enter password");
        UserService userService = new UserService();
        if (userService.checkEmailAndPhoneNumber(username, username)) {
            currentUser = userService.getCurrentUser();
            if (password.equals(currentUser.getPassword())) {
                System.out.println("Hello " + currentUser.getFullName() + ". Thank you for coming back!");
                if (currentUser instanceof Admin) {
                    EnjoyGalaxyView.displayAdminHomePage();
                } else if (currentUser instanceof Staff) {
                    EnjoyGalaxyView.displayStaffHomePage();
                } else {
                    EnjoyGalaxyView.displayCustomerHomePage();
                }
            } else {
                System.out.println("Wrong password!");
            }
        } else {
            System.out.println("Email or phone number is not registered.");
            displaySignIn();
        }
    }

    public static void displayCustomerInformation() {
        do {
            System.out.println(currentUser.toString());
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

    private static void displayEditFullName() {
        String fullName = Input.prompt("Enter new full name:", FULL_NAME_PATTERN);
        currentUser.setFullName(fullName);
    }

    private static void displayEditPhoneNumber() {
        String phoneNumber = Input.prompt("Enter new phone number:", PHONE_NUMBER_PATTERN);
        currentUser.setPhoneNumber(phoneNumber);
    }

    private static void displayEditEmail() {
        String email = Input.prompt("Enter new email:", EMAIL_PATTERN);
        currentUser.setEmail(email);
    }

    private static void displayEditPassword() {
        String password = Input.prompt("Enter new password");
        currentUser.setPassword(password);
    }

    private static void displayDepositMoney() {
        do {
            try {
                double money = Double.parseDouble(Input.prompt("Enter the amount you want to deposit:"));
                currentUser.setWallet(money);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! " + e.getMessage());
            }
        } while (true);
    }

}
*/
