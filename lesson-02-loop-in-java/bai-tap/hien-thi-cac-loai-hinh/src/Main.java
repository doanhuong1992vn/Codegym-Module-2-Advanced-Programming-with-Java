import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while(choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Draw the triangle");
            System.out.println("2. Draw the square");
            System.out.println("3. Draw the rectangle");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    int choiceTriangle;
                    System.out.println("Which angle do you want the right angle to be?");
                    System.out.println("1. Top-left");
                    System.out.println("2. Top-right");
                    System.out.println("3. Bottom-left");
                    System.out.println("4. Bottom-right");
                    System.out.println("0. Exit");
                    System.out.print("Enter your choice: ");
                    choiceTriangle = input.nextInt();
                    System.out.print("Enter height: ");
                    int height = input.nextInt();
                    switch (choiceTriangle) {
                        case 1:
                            for(int i = height; i >= 1; i--) {
                                for(int j = 1; j <= i; j++) {
                                    System.out.print("* ");
                                }
                                System.out.print("\n");
                            }
                            break;
                        case 2:
                            for(int i = height; i >= 1; i--) {
                                String text = "";
                                for(int j = 1; j <= i; j++) {
                                    text += " * ";
                                }
                                System.out.printf("%" + height * 3 + "s\n", text);
                            }
                            break;
                        case 3:
                            for(int i = 1; i <= height; i++) {
                                for(int j = 1; j <= i; j++) {
                                    System.out.print("* ");
                                }
                                System.out.print("\n");
                            }
                            break;
                        case 4:
                            for(int i = 1; i <= height; i++) {
                                
                            }

                    }
                    break;
                case 2:
                    System.out.println("Draw the square");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    break;
                case 3:
                    System.out.println("Draw the rectangle");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}