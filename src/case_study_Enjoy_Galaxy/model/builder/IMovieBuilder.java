package case_study_Enjoy_Galaxy.model.builder;

import case_study_Enjoy_Galaxy.model.entity.Movie;

import java.text.ParseException;

public interface IMovieBuilder {
    IMovieBuilder setName(String name);
    IMovieBuilder setDirector(String director);
    IMovieBuilder setActors(String actors);
    IMovieBuilder setMovieGenre(String movieGenre);
    IMovieBuilder setPremiereDate(String premiereDate) throws ParseException;
    IMovieBuilder setMovieDuration(int movieDuration);
    IMovieBuilder setLanguage(String language);
    IMovieBuilder setContent(String content);
    Movie build() throws ParseException;
}
