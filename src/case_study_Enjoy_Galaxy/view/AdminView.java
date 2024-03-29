package case_study_Enjoy_Galaxy.view;

import case_study_Enjoy_Galaxy.model.dao.iplm.ShowtimeDAO;
import case_study_Enjoy_Galaxy.model.entity.Movie;
import case_study_Enjoy_Galaxy.model.entity.Showtime;
import case_study_Enjoy_Galaxy.model.entity.cinema.abstraction.Room;
import case_study_Enjoy_Galaxy.model.entity.movie_theater.abstraction.MovieTheater;
import case_study_Enjoy_Galaxy.model.entity.users.Admin;
import case_study_Enjoy_Galaxy.model.service.MovieService;
import case_study_Enjoy_Galaxy.model.service.MovieTheaterService;
import case_study_Enjoy_Galaxy.model.service.TicketService;
import case_study_Enjoy_Galaxy.model.service.UserService;
import case_study_Enjoy_Galaxy.model.utils.Converter;
import case_study_Enjoy_Galaxy.model.utils.FileWriterUtils;
import case_study_Enjoy_Galaxy.model.utils.Input;
import case_study_Enjoy_Galaxy.model.utils.Validation;
import case_study_Enjoy_Galaxy.view.abstraction.UserView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class AdminView extends UserView {
    private static final AdminView adminView = new AdminView();

    private AdminView() {
    }

    public static AdminView getInstance() {
        return adminView;
    }

    public void displayAdminHomePage() throws ParseException {
        do {
            System.out.println("""
                    Viết tới đây thì ko kịp tính năng nộp case study nên lười viết tiếng anh rồi T_T
                    1. Sign out
                    2. Tạo tài khoản nhân viên
                    3. Thống kê doanh thu theo tháng
                    4. Thêm suất chiếu
                    5. Xem thông tin Admin
                    """);
            int choice = Input.choiceIntegerPrompt("Enter your choice: ");
            switch (choice) {
                case 1 -> EnjoyGalaxyView.getInstance().signOut();
                case 2 -> {
                    displaySignUp();
                    displayAdminHomePage();
                }
                case 3 -> displayRevenueOfMonth();
                case 4 -> displayAddingShowtimeFeature();
                case 5 -> System.out.println(Admin.getInstance());
                default -> System.out.println("Invalid input!");
            }
        } while (true);
    }

    public void displayAddingShowtimeFeature() throws ParseException {
        MovieTheaterService movieTheaterService = MovieTheaterService.getInstance();
        movieTheaterService.getMovieTheaterList().forEach(System.out::println);
        int idMovieTheater = Input.choiceIntegerPrompt("Enter movie theater ID:");
        movieTheaterService.getCinemaListByMovieTheaterId(idMovieTheater).forEach(System.out::println);
        int idCinema = Input.choiceIntegerPrompt("Enter room ID:");
        MovieService.getInstance().getMovieList().forEach(System.out::println);
        int idMovie = Input.choiceIntegerPrompt("Enter movie ID:");
        movieTheaterService.getShowtimeListByCinemaId(idMovieTheater, idCinema).forEach(System.out::println);
        String showtimeFormat = Input.prompt("Enter showtime with format \"dd/MM/yyyy hh:mm:ss\"");
        Date showtime = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(showtimeFormat);
        MovieTheater movieTheater = movieTheaterService.getMovieTheaterById(idMovieTheater);
        Room room = movieTheaterService.getCinemaById(idCinema);
        Movie movie = MovieService.getInstance().getMovieById(idMovie);
        MovieTheaterService.addShowtime(idMovieTheater, idCinema, showtime, idMovie);
        System.out.println(MovieTheaterService.getNotification());
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
        String birthdayFormat = Input.prompt("Enter birth day with format \"dd/MM/yyyy\":", DATE);
        Date birthday = new SimpleDateFormat("dd/MM/yyyy").parse(birthdayFormat);
        String address = Input.prompt("Enter address:");
        UserService userService = UserService.getInstance();
        userService.createStaff(fullName, phoneNumber, email, password, education,
                jobTitle, salary, birthday, address);
        System.out.println(userService.getNotification());
    }

    public void displayMovieManagement() {
        do {
            List<Movie> movieList = MovieService.getInstance().getMovieList();
            movieList.sort(Comparator.comparingLong(Movie::getId));
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
        System.out.println(TicketService.getInstance().getInformationOfRevenueByMonth(monthAndYear));
    }
}
