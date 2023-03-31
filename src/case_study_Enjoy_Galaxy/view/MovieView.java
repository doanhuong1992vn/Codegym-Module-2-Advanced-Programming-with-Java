package case_study_Enjoy_Galaxy.view;

import case_study_Enjoy_Galaxy.model.entity.Movie;
import case_study_Enjoy_Galaxy.model.entity.Ticket;
import case_study_Enjoy_Galaxy.model.entity.seat.abstraction.Seat;
import case_study_Enjoy_Galaxy.model.entity.users.Admin;
import case_study_Enjoy_Galaxy.model.entity.users.Staff;
import case_study_Enjoy_Galaxy.model.entity.users.abstraction.User;
import case_study_Enjoy_Galaxy.model.service.MovieService;
import case_study_Enjoy_Galaxy.model.service.MovieTheaterService;
import case_study_Enjoy_Galaxy.model.service.TicketService;
import case_study_Enjoy_Galaxy.model.service.UserService;
import case_study_Enjoy_Galaxy.model.utils.DateFormatConverter;
import case_study_Enjoy_Galaxy.model.utils.Input;
import case_study_Enjoy_Galaxy.view.abstraction.IDisplayable;
import case_study_Enjoy_Galaxy.view.abstraction.UserView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MovieView implements IDisplayable {
    private static final MovieView movieView = new MovieView();

    private MovieView() {
    }

    public static MovieView getInstance() {
        return movieView;
    }

    @Override
    public void displayList() throws ParseException {
        MovieService movieService = MovieService.getInstance();
        List<Movie> movieList = movieService.getMovieList();
        movieList.forEach(System.out::println);
        displayChoicesOfList();
    }

    @Override
    public void displayChoicesOfList() throws ParseException {
        MovieService movieService = MovieService.getInstance();
        do {
            System.out.println("""
                    1. Display movie details by movie ID
                    2. Sort by latest movie
                    3. Sort by oldest movie
                    4. Sort by shortest movie duration
                    5. Sort by longest movie duration
                    6. Back to home page""");
            int choice = Input.choiceIntegerPrompt("Enter your choice:");
            switch (choice) {
                case 1 -> displayChoiceMovieById();
                case 2 -> {
                    List<Movie> movieList = movieService.getMovieListSortedByLatestMovie();
                    movieList.forEach(System.out::println);
                }
                case 3 -> {
                    List<Movie> movieList = movieService.getMovieListSortedByOldestMovie();
                    movieList.forEach(System.out::println);
                }
                case 4 -> {
                    List<Movie> movieList = movieService.getMovieListSortedByShortestMovieDuration();
                    movieList.forEach(System.out::println);
                }
                case 5 -> {
                    List<Movie> movieList = movieService.getMovieListSortedByLongestMovieDuration();
                    movieList.forEach(System.out::println);
                }
                case 6 -> {
                    EnjoyGalaxyView enjoyGalaxyView = EnjoyGalaxyView.getInstance();
                    UserService userService = UserService.getInstance();
                    User user = userService.getCurrentUser();
                    if (user == null) {
                        enjoyGalaxyView.displayStartMenu();
                    } else if (user instanceof Admin) {
                        enjoyGalaxyView.displayAdminHomePage(user);
                    } else if (user instanceof Staff) {
                        enjoyGalaxyView.displayStaffHomePage(user);
                    } else {
                        enjoyGalaxyView.displayCustomerHomePage(user);
                    }
                }
                default -> System.out.println("Invalid input!");
            }
        } while (true);
    }

    public void displayChoiceMovieById() throws ParseException {
        MovieService movieService = MovieService.getInstance();
        do {
            int idMovie = Input.choiceIntegerPrompt("Enter movie ID:");
            Movie movie = movieService.getMovieById(idMovie);
            if (movie != null) {
                displayDetailByMovie(movie);
            } else {
                System.out.println("Invalid input!");
            }
        } while (true);
    }

    public void displaySearchingMovie() throws ParseException {
        String title = Input.prompt("Enter the name of the movie that you want to find:");
        MovieService movieService = MovieService.getInstance();
        List<Movie> movieList = movieService.getMovieListByKeyword(title);
        if (!movieList.isEmpty()) {
            movieList.forEach(System.out::println);
            do {
                System.out.println("""
                        1. View movie details by movie ID
                        2. Go back""");
                int choice = Input.choiceIntegerPrompt("Enter your choice:");
                switch (choice) {
                    case 1 -> displayChoiceMovieById();
                    case 2 -> {
                        return;
                    }
                    default -> System.out.println("Invalid input!");
                }
            } while (true);
        } else {
            System.out.println("Movie not found!");
            displaySearchingMovie();
        }
    }

    public void displayDetailByMovie(Movie movie) throws ParseException {
        System.out.println(movie.getDetail());
        do {
            System.out.println("""
                    1. Display showtime list
                    2. Go back""");
            int choice = Input.choiceIntegerPrompt("Enter your choice:");
            switch (choice) {
                case 1 -> {
                    displayShowtimeListOfMovieAtDate(movie, new Date());
                }
                case 2 -> displayList();
                default -> System.out.println("Invalid input!");
            }
        } while (true);
    }

    public void displayShowtimeListOfMovieAtDate(Movie movie, Date date) throws ParseException {
        String dateFormat = new SimpleDateFormat("dd/MM/yyyy").format(date);
        MovieTheaterService movieTheaterService = MovieTheaterService.getInstance();
        List<StringBuilder> showtimeList = movieTheaterService.getShowtimeListInDayByMovie(movie, date);
        if (showtimeList.isEmpty()) {
            System.err.println("Xin lỗi, không có suất chiếu " + movie.getName() +
                    " trong ngày " + dateFormat +
                    ", hãy chọn một ngày khác.");
            displayAnotherDateSelectionScreenByMovieAndDateFormat(movie, dateFormat);
        } else {
            System.out.println("Có " + showtimeList.size() +
                    " suất chiếu " + movie.getName() +
                    " trong ngày " + dateFormat +
                    ":");
            showtimeList.forEach(System.out::println);
            System.out.println("""
                    1. Select showtime by ID
                    2. Select another date""");
            int choice = Input.choiceIntegerPrompt("Enter your choice: ");
            switch (choice) {
                case 1 -> {
                    int idShowtime;
                    boolean isShowtimeListNotContainShowtimeIdInput = true;
                    do {
                        idShowtime = Input.choiceIntegerPrompt("Enter showtime ID: ");
                        String showtimeIdFormatConverted = "<ID SHOWTIME = " + idShowtime + ">";
                        for (StringBuilder element : showtimeList) {
                            if (element.toString().contains(showtimeIdFormatConverted)) {
                                isShowtimeListNotContainShowtimeIdInput = false;
                                break;
                            }
                        }
                        if (isShowtimeListNotContainShowtimeIdInput) {
                            System.out.println("Showtime ID " + idShowtime + " does not exist in above list. " +
                                    "Please re-enter");
                        }
                    } while (isShowtimeListNotContainShowtimeIdInput);
                    displayDiagramOfCinemaByShowtimeId(movie, idShowtime);
                }
                case 2 -> displaySelectionDateToBookTicket(movie);
                default -> System.out.println("Invalid input!");
            }
        }

    }

    private void displayDiagramOfCinemaByShowtimeId(Movie movie, int idShowtime) throws ParseException {
        MovieTheaterService movieTheaterService = MovieTheaterService.getInstance();
        Seat[][] seats = movieTheaterService.getSeatsByShowtimeId(idShowtime);
        System.out.println("\t[SCREEN]");
        for (Seat[] seat : seats) {
            System.out.println(Arrays.toString(seat));
        }
        StringBuilder informationInSeats = movieTheaterService.getInformationInSeats(seats);
        System.out.println(informationInSeats);
        StringBuilder emptySeats = movieTheaterService.getEmptySeats(seats);
        System.out.println(emptySeats);
        System.out.println("""
                1. Select seat code to book ticket
                2. Go back""");
        int select = Input.choiceIntegerPrompt("Enter your choice: ");
        switch (select) {
            case 1 -> {
                UserService userService = UserService.getInstance();
                User user = userService.getCurrentUser();
                if (user == null) {
                    System.out.println("Please sign in to book tickets");
                    UserView.displaySignIn();
                    displayDiagramOfCinemaByShowtimeId(movie, idShowtime);
                } else {
                    displayTicketAfterSelectSeatCode(idShowtime, emptySeats);
                }
            }
        }
    }

    private static void displayTicketAfterSelectSeatCode(int idShowtime, StringBuilder emptySeats) {
        String seatCode;
        boolean isEmptySeatsNotContainSeatCodeInput;
        do {
            seatCode = Input.prompt("Enter seat code: ");
            seatCode = seatCode.trim().toUpperCase();
            isEmptySeatsNotContainSeatCodeInput =
                    !emptySeats.toString().contains(seatCode);
            if (isEmptySeatsNotContainSeatCodeInput) {
                System.out.println("Seat code " + seatCode + " has been booked or does not exist");
            }
        } while (isEmptySeatsNotContainSeatCodeInput);
        TicketService ticketService = TicketService.getInstance();
        Ticket ticket = ticketService.getTicket(idShowtime, seatCode);
        System.out.println("Vui lòng kiểm tra kỹ thông tin trước khi xác nhận!");
        System.out.println(ticket);
        String confirm = Input.prompt("Xác nhận đặt vé: Y/N");
    }

    private void displayAnotherDateSelectionScreenByMovieAndDateFormat(Movie movie, String dateToString) throws ParseException {
        do {
            System.out.println("""
                    1. Select another date
                    2. Search another movie""");
            int choice = Input.choiceIntegerPrompt("Enter your choice: ");
            switch (choice) {
                case 1 -> displaySelectionDateToBookTicket(movie);
                case 2 -> displaySearchingMovie();
                default -> System.out.println("Invalid input!");
            }
        } while (true);

    }

    private void displaySelectionDateToBookTicket(Movie movie) throws ParseException {
        MovieTheaterService movieTheaterService = MovieTheaterService.getInstance();
        Map<Date, Integer> dateList = movieTheaterService.getDateMapByMovie(movie);
        if (dateList.isEmpty()) {
            System.err.println("Xin lỗi, hiện tại chưa có suất chiếu của phim " + movie.getName() +
                    ". Vui lòng chọn phim khác");
            displayList();
        } else {
            List<String> dateFormatList = new ArrayList<>();
            for (Map.Entry<Date, Integer> entry : dateList.entrySet()) {
                String dateFormat = new SimpleDateFormat("dd/MM/yyyy").format(entry.getKey());
                dateFormatList.add(dateFormat);
                System.out.println("Ngày " + dateFormat + " có " + entry.getValue() + " suất chiếu.");
            }
            System.out.println("""
                1. Select date to book ticket
                2. Go back""");
            int selection = Input.choiceIntegerPrompt("Enter your choice: ");
            switch (selection) {
                case 1 -> {
                    String dateFormatConverted;
                    do {
                        String dateFormatInput = Input.prompt(
                                "Enter date with format \"dd/mm/yyyy\": ",
                                "DATE");
                        dateFormatConverted = DateFormatConverter.convertDateFormat(dateFormatInput);
                        if (!dateFormatList.contains(dateFormatConverted)) {
                            System.out.println("Xin lỗi, không có suất chiếu " + movie.getName() +
                                    " trong ngày " + dateFormatConverted +
                                    ", hãy chọn một ngày khác.");
                        }
                    } while (!dateFormatList.contains(dateFormatConverted));
                    Date dateInput = new SimpleDateFormat("dd/MM/yyyy").parse(dateFormatConverted);
                    displayShowtimeListOfMovieAtDate(movie, dateInput);
                }
                case 2 -> {
                    return;
                }
                default -> System.out.println("Invalid input!");
            }
        }
    }

    public void displayCheckingTicket() {
    }
}
