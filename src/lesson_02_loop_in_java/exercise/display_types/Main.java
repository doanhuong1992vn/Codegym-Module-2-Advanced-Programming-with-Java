package lesson_02_loop_in_java.exercise.display_types;

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
                case 1: {
                    System.out.print("Enter height: ");
                    int heightTriangle = input.nextInt();
                    System.out.println("Which angle do you want the right angle to be?");
                    System.out.println("1. Top-left");
                    System.out.println("2. Top-right");
                    System.out.println("3. Bottom-left");
                    System.out.println("4. Bottom-right");
                    System.out.println("0. Exit");
                    System.out.print("Enter your choice: ");
                    int choiceTriangle = input.nextInt();
                    switch (choiceTriangle) {
                        case 1: {
                            System.out.println("Draw the triangle with the right angle on the Top-left and height = "
                                    + heightTriangle);
                            for (int i = heightTriangle; i >= 1; i--) {
                                for (int j = 1; j <= i; j++) {
                                    System.out.print("* ");
                                }
                                System.out.print("\n");
                            }
                            break;
                        }
                        case 2: {
                            System.out.println("Draw the triangle with the right angle on the Top-right and height = "
                                    + heightTriangle);
                            final int DESIRED_NUMBER = 3;
                            int widthTriangle = heightTriangle * DESIRED_NUMBER;
                            for (int i = heightTriangle; i >= 1; i--) {
                                String text = "";
                                for (int j = 1; j <= i; j++) {
                                    text += " * ";
                                }
                                System.out.printf("%" + widthTriangle + "s\n", text);
                            }
                            break;
                        }
                        case 3: {
                            System.out.println("Draw the triangle with the right angle on the Bottom-left and height = "
                                    + heightTriangle);
                            for (int i = 1; i <= heightTriangle; i++) {
                                for (int j = 1; j <= i; j++) {
                                    System.out.print("* ");
                                }
                                System.out.print("\n");
                            }
                            break;
                        }
                        case 4: {
                            System.out.println("Draw the triangle with the right angle on the Bottom-right and height = "
                                    + heightTriangle);
                            final int DESIRED_NUMBER = 3;
                            int widthTriangle = heightTriangle * DESIRED_NUMBER;
                            for (int i = 1; i <= heightTriangle; i++) {
                                String text = "";
                                for (int j = 1; j <= i; j++) {
                                    text += " * ";
                                }
                                System.out.printf("%" + widthTriangle + "s\n", text);
                            }
                            break;
                        }
                        case 0:
                            System.exit(0);
                        default:
                            System.out.print("No choice!");
                    }
                    break;
                }
                case 2: {
                    System.out.print("Enter width: ");
                    int widthSquare = input.nextInt();
                    System.out.println("Draw the square with width = " + widthSquare);
                    for (int i = 1; i <= widthSquare; i++) {
                        for (int j = 1; j <= widthSquare; j++) {
                            System.out.print("*   ");
                        }
                        System.out.print("\n");
                    }
                    break;
                }
                case 3: {
                    System.out.print("Enter width: ");
                    int widthRectangle = input.nextInt();
                    System.out.print("Enter height: ");
                    int heightRectangle = input.nextInt();
                    System.out.printf("Draw the rectangle with width = %d and height = %d\n",
                            widthRectangle, heightRectangle);
                    for(int i = 1; i <= heightRectangle; i++) {
                        for(int j = 1; j <= widthRectangle; j++) {
                            System.out.print("*   ");
                        }
                        System.out.print("\n");
                    }
                    break;
                }
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}