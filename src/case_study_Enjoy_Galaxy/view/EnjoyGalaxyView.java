package case_study_Enjoy_Galaxy.view;

public class EnjoyGalaxyView {
    public static void displayStartMenu() {
        do {
            System.out.println("""
                    *** Welcome to Enjoy Galaxy !!! ***
                    1. Sign up
                    2. Sign in
                    3. Display movie list
                    4. Display movie theater list
                    5. Check ticket""");
            int choice = Input.choicePrompt();
            switch (choice) {
                case 1 -> UserView.displaySignUp();
                case 2 -> UserView.displaySignIn();
                case 3 -> MovieTheaterView.displayMovieList();
                case 4 -> MovieTheaterView.displayMovieTheaterList();
                case 5 -> MovieTheaterView.displayCheckingTicket();
                default -> System.err.println("Invalid input!");
            }
        } while (true);
    }

    public static void displayCustomerHomePage() {
        do {
            System.out.println("""
                    1. Display movie list
                    2. Display movie theater list
                    3. Check ticket
                    4. Update personal information
                    5. Sign out""");
            int choice = Input.choicePrompt();
            switch (choice) {
                case 1 -> MovieTheaterView.displayMovieList();
                case 2 -> MovieTheaterView.displayMovieTheaterList();
                case 3 -> MovieTheaterView.displayCheckingTicket();
                case 4 -> UserView.displayCustomerInformation();
                default -> System.err.println("Invalid input!");
            }
        } while (true);
    }

    public static void displayAdminHomePage() {
    }
    public static void displayStaffHomePage() {
    }
}
