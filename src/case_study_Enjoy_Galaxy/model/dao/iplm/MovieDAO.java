package case_study_Enjoy_Galaxy.model.dao.iplm;

import case_study_Enjoy_Galaxy.model.builder.movie_builder.IMovieBuilder;
import case_study_Enjoy_Galaxy.model.builder.movie_builder.MovieConcreteBuilder;
import case_study_Enjoy_Galaxy.model.dao.IMovieDAO;
import case_study_Enjoy_Galaxy.model.entity.Movie;
import case_study_Enjoy_Galaxy.model.factory.MovieTheaterFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovieDAO implements IMovieDAO {
    private static final String SELECT_ALL = "SELECT * FROM MOVIE;";
    private static final IMovieDAO movieDAO = new MovieDAO();
    private MovieDAO(){}
    public static IMovieDAO getMovieDAO() {
        return movieDAO;
    }

    @Override
    public List<Movie> getAll() {
        List<Movie> movies = new ArrayList<>();
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("ID");
                String name = resultSet.getString("NAME");
                String director = resultSet.getString("DIRECTOR");
                String actors = resultSet.getString("ACTORS");
                String genre = resultSet.getString("GENRE");
                Date premiereDate = resultSet.getDate("PREMIERE_DATE");
                int duration = resultSet.getInt("DURATION");
                String language = resultSet.getString("LANGUAGE");
                String content = resultSet.getString("CONTENT");
                IMovieBuilder movieBuilder = new MovieConcreteBuilder()
                        .setMovieDuration(duration)
                        .setMovieGenre(genre)
                        .setActors(actors)
                        .setContent(content)
                        .setDirector(director)
                        .setLanguage(language)
                        .setPremiereDate(premiereDate)
                        .id(id)
                        .setName(name);
                Movie movie = movieBuilder.buildFull();
                movies.add(movie);
            }
        } catch (Exception e) {
                 e.printStackTrace();
        }
        return movies;
    }
}
