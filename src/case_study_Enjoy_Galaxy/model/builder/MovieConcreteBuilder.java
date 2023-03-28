package case_study_Enjoy_Galaxy.model.builder;

import case_study_Enjoy_Galaxy.model.entity.Movie;

import java.text.ParseException;

public class MovieConcreteBuilder implements IMovieBuilder{
    private String name;
    private String director;
    private String actors;
    private String movieGenre;
    private String premiereDate;
    private int movieDuration;
    private String language;
    private String content;
    @Override
    public IMovieBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public IMovieBuilder setDirector(String director) {
        this.director = director;
        return this;
    }

    @Override
    public IMovieBuilder setActors(String actors) {
        this.actors = actors;
        return this;
    }

    @Override
    public IMovieBuilder setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
        return this;
    }

    @Override
    public IMovieBuilder setPremiereDate(String premiereDate) throws ParseException {
        this.premiereDate = premiereDate;
        return this;
    }

    @Override
    public IMovieBuilder setMovieDuration(int movieDuration) {
        this.movieDuration = movieDuration;
        return this;
    }

    @Override
    public IMovieBuilder setLanguage(String language) {
        this.language = language;
        return this;
    }

    @Override
    public IMovieBuilder setContent(String content) {
        this.content = content;
        return this;
    }

    @Override
    public Movie build() throws ParseException {
        return new Movie(name, director, actors, movieGenre,
                premiereDate, movieDuration, language, content);
    }
}
