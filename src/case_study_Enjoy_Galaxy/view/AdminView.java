package case_study_Enjoy_Galaxy.view;

import case_study_Enjoy_Galaxy.model.entity.Movie;
import case_study_Enjoy_Galaxy.model.entity.Ticket;
import case_study_Enjoy_Galaxy.model.service.MovieService;
import case_study_Enjoy_Galaxy.model.service.TicketService;
import case_study_Enjoy_Galaxy.model.service.UserService;
import case_study_Enjoy_Galaxy.model.utils.Converter;
import case_study_Enjoy_Galaxy.model.utils.Input;
import case_study_Enjoy_Galaxy.model.utils.Validation;
import case_study_Enjoy_Galaxy.view.abstraction.UserView;

import java.text.ParseException;
import java.util.Comparator;
import java.util.List;

public class AdminView extends UserView {
    private static final AdminView adminView = new AdminView();

    private AdminView() {
    }

    public static AdminView getInstance() {
        return adminView;
    }

    @Override
    public void displayInformation() {

    }

    @Override
    public void displaySignUp() throws ParseException {
        String fullName = Input.prompt("Enter your full name:", FULL_NAME_PATTERN);
        String phoneNumber = Input.prompt("Enter your phone number:", PHONE_NUMBER_PATTERN);
        String email = Input.prompt("Enter your email:", EMAIL_PATTERN);
        String password = Input.prompt("Enter password:", PASSWORD);
        String education = Input.prompt("Enter education:");
        String jobTitle = Input.prompt("Enter job title:");
        double salary = Input.choiceIntegerPrompt("Enter salary: ");
        String birthday = Input.prompt("Enter birth day:", DATE);
        String address = Input.prompt("Enter address:");
        UserService userService = UserService.getInstance();
        userService.createAccount(fullName, phoneNumber, email, password, education,
                jobTitle, salary, birthday, address);
        System.out.println(userService.getNotification());
    }

    public void displayMovieManagement() {
        do {
            List<Movie> movieList = MovieService.getInstance().getMovieList();
            movieList.sort(Comparator.comparingInt(Movie::getId));
            movieList.forEach(System.out::println);
            System.out.println("""
                    1. Xem chi tiết phim theo ID""");
            int choice = Input.choiceIntegerPrompt("Enter your choice: ");
            switch (choice) {
//                case 1 ->
            }
        } while (true);
    }

    public void displayRevenueOfMonth() throws ParseException {
        String monthAndYear = Input.prompt("Nhập số tháng/năm muốn kiểm tra theo định dạng \"MM/yyyy\": ",
                "month");
        while (Validation.isBeyondNow(monthAndYear)) {
            System.err.println("Tháng " + monthAndYear + " chưa tới má ơi!");
            monthAndYear = Input.prompt("Nhập lại số tháng/năm muốn kiểm tra theo định dạng \"MM/yyyy\": ",
                    "month");
        }
        List<Ticket> ticketList = TicketService.getInstance().getTicketListByMonth(monthAndYear);
        if (ticketList.isEmpty()) {
            System.out.println("Tháng " + monthAndYear + " không bán được cái mẹ gì hết T_T");
        } else {
            System.out.println("Danh sách vé bán được trong tháng " + monthAndYear + ":");
            double revenue = 0;
            for (Ticket ticket : ticketList) {
                System.out.println(ticket);
                revenue += ticket.getPrice();
            }
            String revenueFormat = Converter.formatPrice(revenue);
            System.out.println("Tổng doanh thu trong tháng " + monthAndYear + " là " + revenueFormat);
        }
    }
}
