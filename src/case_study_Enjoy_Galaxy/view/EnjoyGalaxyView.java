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
            displayAdminHomePage();
        } else if (user instanceof Staff) {
            displayStaffHomePage();
        } else if (user instanceof Customer) {
            displayCustomerHomePage();
        }
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
                case 4 -> TicketView.getInstance().displayFeatureCheckingTicket();
                case 5 -> CustomerView.getInstance().displayInformation();
                case 6 -> signOut();
                default -> System.err.println("Invalid input!");
            }
        } while (true);
    }

    public void displayAdminHomePage() throws ParseException {
        do {
            System.out.println("""
                    Viết tới đây thì ko kịp tính năng nộp case study nên lười viết tiếng anh rồi T_T
                    1. Thống kê doanh thu theo tháng
                    2. Tạo tài khoản nhân viên
                    3. Sign out""");
            int choice = Input.choiceIntegerPrompt("Enter your choice: ");
            switch (choice) {
                case 1 -> AdminView.getInstance().displayRevenueOfMonth();
                case 2 -> {
                    AdminView.getInstance().displaySignUp();
                    displayHomePageByUser();
                }
                case 3 -> signOut();
                default -> System.out.println("Invalid input!");
            }
        } while (true);
    }

    public void displayStaffHomePage() throws ParseException {
        System.out.println("Tôi là nhân viên nhưng chưa có tính năng nào");
        System.out.println(UserService.getInstance().getCurrentUser());
        System.out.println("""
                1. Sign out""");
        do {
            int choice = Input.choiceIntegerPrompt("Enter your choice: ");
            switch (choice) {
                case 1 ->  signOut();
                default -> System.out.println("Invalid input!");
            }
        } while (true);
    }
    public void signOut() throws ParseException {
        UserService.getInstance().setCurrentUser(null);
        displayStartMenu();
    }
}
