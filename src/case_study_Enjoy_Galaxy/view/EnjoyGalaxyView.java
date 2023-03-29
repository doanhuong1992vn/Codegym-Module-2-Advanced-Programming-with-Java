package case_study_Enjoy_Galaxy.view;

import case_study_Enjoy_Galaxy.model.entity.users.abstraction.User;
import case_study_Enjoy_Galaxy.model.utils.Input;
import case_study_Enjoy_Galaxy.view.abstraction.UserView;

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
            CustomerView customerView = CustomerView.getInstance();
            MovieView movieView = MovieView.getInstance();
            MovieTheaterView movieTheaterView = MovieTheaterView.getInstance();
            switch (choice) {
                case 1 -> customerView.displaySignUp();
                case 2 -> UserView.displaySignIn();
                case 3 -> movieView.displaySearchingMovie();
                case 4 -> movieView.displayList();
                case 5 -> movieTheaterView.displayList();
                case 6 -> movieView.displayCheckingTicket();
                default -> System.err.println("Invalid input!");
            }
        } while (true);
    }

    public void displayCustomerHomePage(User user) throws ParseException {
        do {
            System.out.println("""
                    1. Search movie
                    2. Display movie list
                    3. Display movie theater list
                    4. Check ticket
                    5. Update personal information
                    6. Sign out""");
            int choice = Input.choiceIntegerPrompt("Enter your choice:");
            CustomerView customerView = CustomerView.getInstance();
            MovieView movieView = MovieView.getInstance();
            MovieTheaterView movieTheaterView = MovieTheaterView.getInstance();
            switch (choice) {
                case 1 -> movieView.displaySearchingMovie();
                case 2 -> movieView.displayList();
                case 3 -> movieTheaterView.displayList();
                case 4 -> movieView.displayCheckingTicket();
                case 5 -> customerView.displayInformation(user);
                default -> System.err.println("Invalid input!");
            }
        } while (true);
    }

    public void displayAdminHomePage(User user) {
    }

    public void displayStaffHomePage(User user) {
    }
}
