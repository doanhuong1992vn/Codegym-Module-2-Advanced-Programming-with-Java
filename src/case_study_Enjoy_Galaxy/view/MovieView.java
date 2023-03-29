package case_study_Enjoy_Galaxy.view;

import case_study_Enjoy_Galaxy.model.entity.Movie;
import case_study_Enjoy_Galaxy.model.entity.users.abstraction.User;
import case_study_Enjoy_Galaxy.model.service.MovieService;
import case_study_Enjoy_Galaxy.model.service.MovieTheaterService;
import case_study_Enjoy_Galaxy.model.service.UserService;
import case_study_Enjoy_Galaxy.model.utils.Input;
import case_study_Enjoy_Galaxy.view.abstraction.IDisplayable;
import case_study_Enjoy_Galaxy.view.abstraction.UserView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
                    1. Sort by movie duration
                    2. Sort by premiere date
                    3. Display movie details by movie ID
                    4. Go back""");
            int choice = Input.choiceIntegerPrompt("Enter your choice:");
            switch (choice) {
                case 1 -> {
                    List<Movie> movieList = movieService.getMovieListSortedByDuration();
                    movieList.forEach(System.out::println);
                }
                case 2 -> {
                    List<Movie> movieList = movieService.getMovieListSortedByPremiereDate();
                    movieList.forEach(System.out::println);
                }
                case 3 -> displayChoiceMovieById();
                case 4 -> {
                    return;
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
                    1. Book ticket
                    2. Go back""");
            int choice = Input.choiceIntegerPrompt("Enter your choice:");
            switch (choice) {
                case 1 -> {
                    UserService userService = UserService.getInstance();
                    User user = userService.getCurrentUser();
                    if (user == null) {
                        System.out.println("Please sign in to book tickets");
                        UserView.displaySignIn();
                        displayDetailByMovie(movie);
                    } else {
                        displayShowtimeOfMovieAtDate(movie, new Date());
                    }
                }
                case 2 -> displayList();
                default -> System.out.println("Invalid input!");
            }
        } while (true);
    }

    public void displayShowtimeOfMovieAtDate(Movie movie, Date date) throws ParseException {
        String dateToString = new SimpleDateFormat("dd/MM/yyyy").format(date);
        MovieTheaterService movieTheaterService = MovieTheaterService.getInstance();
        List<StringBuilder> showtimeList = movieTheaterService.getShowtimeListInDayByMovie(movie, date);
        if (showtimeList.isEmpty()) {
            System.out.println("Xin lỗi, không có suất chiếu " + movie.getName() +
                    " trong ngày " + dateToString +
                    ", hãy chọn một ngày khác.");
            System.out.println("""
                    1. Select another date
                    2. Search another movie""");
            int choice = Input.choiceIntegerPrompt("Enter your choice: ");
            switch (choice) {
                case 1 -> displaySelectionDateToBookTicket(movie, dateToString);
                case 2 -> displaySearchingMovie();
                default -> System.out.println("Invalid input!");
            }
        } else {
            System.out.println("Có " + showtimeList.size() +
                    " suất chiếu " + movie.getName() +
                    " trong ngày " + dateToString +
                    ":");
            showtimeList.forEach(System.out::println);
            System.out.println("""
                    1. Book ticket
                    2. Select another date""");
            int choice = Input.choiceIntegerPrompt("Enter your choice: ");
            switch (choice) {
                case 1 -> {
                    int idMovieTheater = Input.choiceIntegerPrompt("Enter movie theater ID: ");
                    int idCinema = Input.choiceIntegerPrompt("Enter cinema ID: ");
                    String showtime = Input.prompt("Enter time of showtime with format \"hh:mm\": ");
                    String timeBooking = dateToString + " " + showtime + ":00";
                }
                case 2 -> displaySelectionDateToBookTicket(movie, dateToString);
                default -> System.out.println("Invalid input!");
            }
        }

    }

    private void displaySelectionDateToBookTicket(Movie movie, String dateToString) throws ParseException {
        MovieTheaterService movieTheaterService = MovieTheaterService.getInstance();
        Map<Date, Integer> dateList = movieTheaterService.getDateMapByMovie(movie);
        for (Map.Entry<Date, Integer> entry : dateList.entrySet()) {
            String dateInMapToString = new SimpleDateFormat("dd/MM/yyyy").format(entry.getKey());
            if (dateToString.equals(dateInMapToString)) {
                continue;
            } else {
                System.out.println("Ngày " + dateInMapToString +
                        " có " + entry.getValue() + " suất chiếu.");
            }
        }
        System.out.println("""
                1. Select date to book ticket
                2. Go back""");
        int selection = Input.choiceIntegerPrompt("Enter your choice: ");
        switch (selection) {
            case 1 -> {
                String dateInputByString = Input.prompt(
                        "Enter date with format \"dd/mm/yyyy\": ",
                        "DATE");
                Date dateInput = new SimpleDateFormat("dd/MM/yyyy").parse(dateInputByString);
                displayShowtimeOfMovieAtDate(movie, dateInput);
            }
            case 2 -> {
                return;
            }
            default -> System.out.println("Invalid input!");
        }
    }

    public void displayCheckingTicket() {
    }
}
