package case_study_Enjoy_Galaxy.view;

import case_study_Enjoy_Galaxy.model.entity.Movie;
import case_study_Enjoy_Galaxy.model.service.MovieService;

import java.util.List;

public class MovieTheaterView {
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
                3. View movie details by movie title
                4. Go back""");
            int choice = Input.choicePrompt();
            switch (choice) {
                case 1 -> {
                    List<Movie> movieList = movieService.getMovieListSortedByDuration();
                    movieList.forEach(System.out::println);
                }
                case 2 -> {
                    List<Movie> movieList = movieService.getMovieListSortedByPremiereDate();
                    movieList.forEach(System.out::println);
                }
                case 3 -> displaySearchingByMovieTitle();
                case 4 -> {
                    return;
                }
                default -> System.out.println("Invalid input!");
            }
        } while (true);
    }

    private static void displaySearchingByMovieTitle() {
        String title = Input.prompt("Enter movie title that you want to see detail:");
        MovieService movieService = new MovieService();
        Movie movie = movieService.getMovieByTitle(title);
        if (movie != null) {
            String choice = Input.prompt("Do you mean " + movie.getTitle() + " movie? Y/N");
            switch (choice) {
                case "Y", "y", "YES", "yes", "Yes" -> displayDetailByMovie(movie);
                case "N", "n", "NO", "No", "no" -> {
                    System.out.println("Sorry. Please enter more details!");
                    displaySearchingByMovieTitle();
                }
            }
        } else {
            System.out.println("Movie not found!");
            displayChoicesOfMovieList();
        }
    }

    private static void displayDetailByMovie(Movie movie) {
        System.out.println(movie.toString());
        do {
            System.out.println("""
                1. Book ticket
                2. Go back""");
            int choice = Input.choicePrompt();
            switch (choice) {
                case 1 -> {}
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
