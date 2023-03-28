package case_study_Enjoy_Galaxy.model.service;

import case_study_Enjoy_Galaxy.model.entity.movie_theater.MovieTheater;

import java.util.ArrayList;
import java.util.List;

public class MovieTheaterService {
    private static final MovieTheaterService movieTheaterService = new MovieTheaterService();
    private static final List<MovieTheater> movieTheaterList = new ArrayList<>();

    private MovieTheaterService(){
    }
    public static MovieTheaterService getInstance() {
        return movieTheaterService;
    }

}
