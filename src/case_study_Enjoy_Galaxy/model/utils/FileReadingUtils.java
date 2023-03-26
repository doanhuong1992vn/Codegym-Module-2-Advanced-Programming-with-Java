package case_study_Enjoy_Galaxy.model.utils;

import case_study_Enjoy_Galaxy.model.entity.Movie;
import case_study_Enjoy_Galaxy.model.entity.users.Customer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FileReadingUtils {
    private static List<String> readFile(String path) {
        List<String> objectList = new ArrayList<>();
        File file = new File(path);
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                objectList.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return objectList;
    }
    public static List<Customer> readCustomerData(String path) {
        List<String> propertiesOfCustomerList = readFile(path);
        List<Customer> customerList = new LinkedList<>();
        final int INDEX_OF_FULL_NAME = 0;
        final int INDEX_OF_PHONE_NUMBER = 1;
        final int INDEX_OF_EMAIL = 2;
        final int INDEX_OF_PASSWORD = 3;

        for (String propertiesOfCustomer: propertiesOfCustomerList) {
            if (propertiesOfCustomer.equals(propertiesOfCustomerList.get(0))) { //it's header
                continue;
            }
            String[] properties = propertiesOfCustomer.split("; ");
            customerList.add(new Customer(
                    properties[INDEX_OF_FULL_NAME],
                    properties[INDEX_OF_PHONE_NUMBER],
                    properties[INDEX_OF_EMAIL],
                    properties[INDEX_OF_PASSWORD]));
        }
        return customerList;
    }
    public static List<Movie> readMovieData(String path) throws ParseException {
        List<String> propertiesOfMovieList = readFile(path);
        List<Movie> movieList = new ArrayList<>();
        final int INDEX_OF_MOVIE_TITLE = 0;
        final int INDEX_OF_DIRECTOR = 1;
        final int INDEX_OF_ACTORS = 2;
        final int INDEX_OF_MOVIE_GENRE = 3;
        final int INDEX_OF_PREMIERE_DATE = 4;
        final int INDEX_OF_MOVIE_DURATION = 5;
        final int INDEX_OF_LANGUAGE = 6;
        final int INDEX_OF_CONTENT = 7;

        for (String propertiesOfMovie: propertiesOfMovieList) {
            if (propertiesOfMovie.equals(propertiesOfMovieList.get(0))) {
                continue;
            }
            String[] properties = propertiesOfMovie.split("; ");
            movieList.add(new Movie(
                    properties[INDEX_OF_MOVIE_TITLE],
                    properties[INDEX_OF_DIRECTOR],
                    properties[INDEX_OF_ACTORS],
                    properties[INDEX_OF_MOVIE_GENRE],
                    properties[INDEX_OF_PREMIERE_DATE],
                    Integer.parseInt(properties[INDEX_OF_MOVIE_DURATION]),
                    properties[INDEX_OF_LANGUAGE],
                    properties[INDEX_OF_CONTENT]
            ));
        }
        return movieList;
    }
}
