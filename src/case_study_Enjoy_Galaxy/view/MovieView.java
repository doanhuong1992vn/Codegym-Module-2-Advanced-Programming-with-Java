package case_study_Enjoy_Galaxy.view;

import case_study_Enjoy_Galaxy.model.entity.Movie;
import case_study_Enjoy_Galaxy.model.service.MovieService;
import case_study_Enjoy_Galaxy.model.utils.Input;

import java.util.List;

public class MovieView {
    public static void displayMovieList() {
        MovieService movieService = new MovieService();
        List<Movie> movieList = movieService.getMovieList();
        movieList.forEach(System.out::println);
        displayChoicesOfMovieList();
    }

    private static void displayChoicesOfMovieList() {
        MovieService movieService = new MovieService();
        do {
            System.out.println("""
                1. Sort by movie duration
                2. Sort by premiere date
                3. View movie details by movie ID
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

    private static void displayChoiceMovieById() {
        MovieService movieService = new MovieService();
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

    public static void displaySearchingMovie() {
        String title = Input.prompt("Enter the name of the movie that you want to find:");
        MovieService movieService = new MovieService();
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

    private static void displayDetailByMovie(Movie movie) {
        System.out.println(movie.toStringDetail());
        do {
            System.out.println("""
                1. Book ticket
                2. Go back""");
            int choice = Input.choiceIntegerPrompt("Enter your choice:");
            switch (choice) {
                case 1 -> {}//chưa hoàn thiện
                case 2 -> displayMovieList();
                default -> System.out.println("Invalid input!");
            }
        } while (true);
    }

    public static void displayMovieTheaterList() {
    }

    public static void displayCheckingTicket() {
    }
}
