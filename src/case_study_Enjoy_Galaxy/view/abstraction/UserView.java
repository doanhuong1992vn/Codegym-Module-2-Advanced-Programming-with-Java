package case_study_Enjoy_Galaxy.view.abstraction;

import case_study_Enjoy_Galaxy.model.entity.users.abstraction.User;
import case_study_Enjoy_Galaxy.model.service.UserService;
import case_study_Enjoy_Galaxy.model.utils.Input;

import java.text.ParseException;

public abstract class UserView {
    public final String FULL_NAME_PATTERN = "FULL_NAME";
    public final String PHONE_NUMBER_PATTERN = "PHONE_NUMBER";
    public final String EMAIL_PATTERN = "EMAIL";

    public abstract void displayInformation(User user);

    public abstract void displaySignUp() throws ParseException;

    public static void displaySignIn() {
        String phoneNumberOrEmail = Input.prompt("Enter email or phone number to sign in:");
        String password = Input.prompt("Enter password");
        UserService userService = UserService.getInstance();
        if (userService.checkEmailAndPhoneNumber(phoneNumberOrEmail)) {
            User user = userService.getCurrentUser();
            if (password.equals(user.getPassword())) {
                System.out.println("Hello " + user.getFullName() + ". Thank you for coming back!");
            } else {
                userService.setCurrentUser(null);
                System.out.println("Wrong password!");
                displaySignIn();
            }
        } else {
            System.out.println("Email or phone number is not registered.");
            displaySignIn();
        }
    }

    public void displayEditFullName() {
        String fullName = Input.prompt("Enter new full name:", FULL_NAME_PATTERN);
        UserService userService = UserService.getInstance();
        userService.editFullName(fullName);
    }

    public void displayEditPhoneNumber(User user) {
        String phoneNumber = Input.prompt("Enter new phone number:", PHONE_NUMBER_PATTERN);
        user.setPhoneNumber(phoneNumber);
    }

    public void displayEditEmail(User user) {
        String email = Input.prompt("Enter new email:", EMAIL_PATTERN);
        user.setEmail(email);
    }

    public void displayEditPassword(User user) {
        String password = Input.prompt("Enter new password");
        user.setPassword(password);
    }
}
