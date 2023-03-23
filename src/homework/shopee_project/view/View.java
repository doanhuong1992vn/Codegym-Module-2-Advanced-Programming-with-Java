package homework.shopee_project.view;

import java.util.Scanner;

public class View {
    public static final Scanner input = new Scanner(System.in);

    private static final ShopeeView shopee = new ShopeeView();

    public static void main(String[] args) {
        do {
            try {
                shopee.displayHomePage();
            } catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static String prompt(String request) {
        System.out.println(request);
        return input.nextLine();
    }
}
