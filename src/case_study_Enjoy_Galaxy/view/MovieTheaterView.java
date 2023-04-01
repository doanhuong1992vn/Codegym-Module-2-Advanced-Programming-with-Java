package case_study_Enjoy_Galaxy.view;

import case_study_Enjoy_Galaxy.model.entity.movie_theater.abstraction.MovieTheater;
import case_study_Enjoy_Galaxy.model.service.MovieTheaterService;
import case_study_Enjoy_Galaxy.model.utils.Input;
import case_study_Enjoy_Galaxy.view.abstraction.IDisplayable;

import java.text.ParseException;
import java.util.List;

public class MovieTheaterView implements IDisplayable {
    private static final MovieTheaterView movieTheaterView = new MovieTheaterView();
    private MovieTheaterView(){
    }
    public static MovieTheaterView getInstance() {
        return movieTheaterView;
    }
    @Override
    public void displayList() throws ParseException {
        MovieTheaterService movieTheaterService = MovieTheaterService.getInstance();
        List<MovieTheater> movieTheaterList = movieTheaterService.getMovieTheaterList();
        movieTheaterList.forEach(System.out::println);
        displayChoicesOfList();
    }

    @Override
    public void displayChoicesOfList() throws ParseException {
        do {
            System.out.println("""
                    1. Display movie theater details by movie theater ID
                    2. Go back""");
            int choice = Input.choiceIntegerPrompt("Enter your choice: ");
            switch (choice) {
                case 1 -> displayChoiceMovieTheaterById();
                case 2 -> EnjoyGalaxyView.getInstance().displayHomePageByUser();
                default -> System.out.println("Invalid input!!!");
            }
        } while (true);
    }

    private void displayChoiceMovieTheaterById() throws ParseException {
        MovieTheaterService movieTheaterService = MovieTheaterService.getInstance();
        do {
            int idMovieTheater = Input.choiceIntegerPrompt("Enter movie theater ID:");
             MovieTheater movieTheater = movieTheaterService.getMovieTheaterById(idMovieTheater);
             if (movieTheater == null) {
                 System.out.println("Invalid input!!!");
             } else {
                 displayDetailByMovieTheater(movieTheater);
             }
        } while (true);
    }

    private void displayDetailByMovieTheater(MovieTheater movieTheater) throws ParseException {
        System.out.println(movieTheater.getDetail());
        displayChoicesOfList();
    }
}
