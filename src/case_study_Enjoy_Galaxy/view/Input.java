package case_study_Enjoy_Galaxy.view;

import case_study_Enjoy_Galaxy.model.service.ValidationService;

import java.util.Objects;
import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static int choicePrompt() {
        int output;
        do {
            try {
                System.out.println("Enter your choice:");
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
            if (!ValidationService.validate(text, regexPattern)) {
                System.err.println("Invalid input! Incorrect format!");
            }
        } while (!ValidationService.validate(text, regexPattern));
        return text;
    }
}
