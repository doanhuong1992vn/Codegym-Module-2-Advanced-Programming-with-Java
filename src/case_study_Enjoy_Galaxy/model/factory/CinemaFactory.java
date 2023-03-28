package case_study_Enjoy_Galaxy.model.factory;

import case_study_Enjoy_Galaxy.model.entity.cinema.*;
import case_study_Enjoy_Galaxy.model.entity.cinema.abstraction.Cinema;

public class CinemaFactory {
    private static final CinemaFactory cinemaFactory = new CinemaFactory();
    private CinemaFactory(){
    }
    public static CinemaFactory getInstance() {
        return cinemaFactory;
    }
    public Cinema getCinema(String typeCinema, String name) {
        String typeCinemaToUpperCase = typeCinema.toUpperCase();
        switch (typeCinemaToUpperCase) {
            case "2D" -> {
                return new Cinema2D(name);
            }
            case "3D" -> {
                return new Cinema3D(name);
            }
            case "4DX" -> {
                return new Cinema4DX(name);
            }
            case "IMAX" -> {
                return new CinemaIMAX(name);
            }
            default -> {
                return null;
            }
        }
    }
}
