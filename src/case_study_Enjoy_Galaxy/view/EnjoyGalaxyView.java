package case_study_Enjoy_Galaxy.view;

import case_study_Enjoy_Galaxy.model.entity.users.Admin;
import case_study_Enjoy_Galaxy.model.entity.users.Customer;
import case_study_Enjoy_Galaxy.model.entity.users.Staff;
import case_study_Enjoy_Galaxy.model.entity.users.abstraction.User;
import case_study_Enjoy_Galaxy.model.service.UserService;
import case_study_Enjoy_Galaxy.model.utils.Input;

import java.text.ParseException;

public class EnjoyGalaxyView {
    private static final EnjoyGalaxyView enjoyGalaxyView = new EnjoyGalaxyView();

    private EnjoyGalaxyView() {
    }

    public static EnjoyGalaxyView getInstance() {
        return enjoyGalaxyView;
    }

    public void displayStartMenu() throws ParseException {
        do {
            System.out.println("""
                        1. Sign up
                        2. Sign in
                        3. Search movie
                        4. Display movie list
                        5. Display movie theater list
                        6. Check ticket""");
            int choice = Input.choiceIntegerPrompt("Enter your choice:");
            switch (choice) {
                case 1 -> {
                    CustomerView.getInstance().displaySignUp();
                    displayStartMenu();
                }
                case 2 -> {
                    CustomerView.getInstance().displaySignIn();
                    displayHomePageByUser();
                }
                case 3 -> MovieView.getInstance().displaySearchingMovie();
                case 4 -> MovieView.getInstance().displayList();
                case 5 -> MovieTheaterView.getInstance().displayList();
                case 6 -> TicketView.getInstance().displayFeatureCheckingTicket();
                default -> System.err.println("Invalid input!");
            }
        } while (true);
    }

    public void displayHomePageByUser() throws ParseException {
        User user = UserService.getInstance().getCurrentUser();
        if (user == null) {
            displayStartMenu();
        }
        if (user instanceof Admin) {
            AdminView.getInstance().displayAdminHomePage();
        } else if (user instanceof Staff) {
            StaffView.getInstance().displayStaffHomePage();
        } else if (user instanceof Customer) {
            CustomerView.getInstance().displayCustomerHomePage();
        }
    }

    public void signOut() throws ParseException {
        UserService.getInstance().setCurrentUser(null);
        displayStartMenu();
    }
}
