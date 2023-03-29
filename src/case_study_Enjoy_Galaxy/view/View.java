package case_study_Enjoy_Galaxy.view;

import java.text.ParseException;

public class View {
    public static void main(String[] args) throws ParseException {
        System.out.println("*** Welcome to Enjoy Galaxy !!! ***");
        EnjoyGalaxyView enjoyGalaxyView = EnjoyGalaxyView.getInstance();
        enjoyGalaxyView.displayStartMenu();
    }
}
