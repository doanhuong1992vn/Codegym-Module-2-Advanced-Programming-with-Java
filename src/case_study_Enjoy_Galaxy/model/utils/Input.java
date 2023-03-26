package case_study_Enjoy_Galaxy.model.utils;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static int choiceIntegerPrompt(String request) {
        int output;
        do {
            try {
                System.out.println(request);
                output =  Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input! Incorrect format : " + e.getMessage());
            }
        } while (true);
        return output;
    }

    public static String prompt(String request) {
        System.out.println(request);
        return scanner.nextLine();
    }
    public static String prompt(String request, String regexPattern) {
        String text;
        do {
            text = prompt(request);
            if (!Validation.validate(text, regexPattern)) {
                System.err.println("Invalid input! Incorrect format!");
            }
        } while (!Validation.validate(text, regexPattern));
        return text;
    }
}
