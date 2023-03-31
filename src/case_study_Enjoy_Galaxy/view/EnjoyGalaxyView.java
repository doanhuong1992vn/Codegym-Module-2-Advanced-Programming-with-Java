package case_study_Enjoy_Galaxy.view;

import case_study_Enjoy_Galaxy.model.entity.users.Admin;
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
                    User user = UserService.getInstance().getCurrentUser();
                    if (user instanceof Admin) {
                        displayAdminHomePage();
                    } else if (user instanceof Staff) {
                        displayStaffHomePage();
                    } else {
                        displayCustomerHomePage();
                    }
                }
                case 3 -> MovieView.getInstance().displaySearchingMovie();
                case 4 -> MovieView.getInstance().displayList();
                case 5 -> MovieTheaterView.getInstance().displayList();
                case 6 -> TicketView.getInstance().displayCheckingTicket();
                default -> System.err.println("Invalid input!");
            }
        } while (true);
    }

    public void displayCustomerHomePage() throws ParseException {
        do {
            System.out.println("""
                    1. Search movie
                    2. Display movie list
                    3. Display movie theater list
                    4. Check ticket
                    5. Update personal information
                    6. Sign out""");
            int choice = Input.choiceIntegerPrompt("Enter your choice:");
            switch (choice) {
                case 1 -> MovieView.getInstance().displaySearchingMovie();
                case 2 -> MovieView.getInstance().displayList();
                case 3 -> MovieTheaterView.getInstance().displayList();
                case 4 -> TicketView.getInstance().displayCheckingTicket();
                case 5 -> CustomerView.getInstance().displayInformation();
                case 6 -> {
                    UserService.getInstance().setCurrentUser(null);
                    displayStartMenu();
                }
                default -> System.err.println("Invalid input!");
            }
        } while (true);
    }

    public void displayAdminHomePage() {
    }

    public void displayStaffHomePage() {
    }
}
