package case_study_Enjoy_Galaxy.view;

import case_study_Enjoy_Galaxy.model.utils.Input;

public class EnjoyGalaxyView {
    public static void displayStartMenu() {
        do {
            System.out.println("""
                    *** Welcome to Enjoy Galaxy !!! ***
                    1. Sign up
                    2. Sign in
                    3. Search movie
                    4. Display movie list
                    5. Display movie theater list
                    6. Check ticket""");
            int choice = Input.choiceIntegerPrompt("Enter your choice:");
            switch (choice) {
                case 1 -> UserView.displaySignUp();
                case 2 -> UserView.displaySignIn();
                case 3 -> MovieView.displaySearchingMovie();
                case 4 -> MovieView.displayMovieList();
                case 5 -> MovieView.displayMovieTheaterList();
                case 6 -> MovieView.displayCheckingTicket();
                default -> System.err.println("Invalid input!");
            }
        } while (true);
    }

    public static void displayCustomerHomePage() {
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
                case 1 -> MovieView.displaySearchingMovie();
                case 2 -> MovieView.displayMovieList();
                case 3 -> MovieView.displayMovieTheaterList();
                case 4 -> MovieView.displayCheckingTicket();
                case 5 -> UserView.displayCustomerInformation();
                default -> System.err.println("Invalid input!");
            }
        } while (true);
    }

    public static void displayAdminHomePage() {
    }
    public static void displayStaffHomePage() {
    }
}
