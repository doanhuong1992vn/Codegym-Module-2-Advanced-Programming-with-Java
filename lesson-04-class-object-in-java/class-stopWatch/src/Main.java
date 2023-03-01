import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StopWatch watch = new StopWatch();
        System.out.println("Now is: " + watch.getStartTime());
        Scanner input = new Scanner(System.in);
        //đo thời gian thực thi từ lúc người dùng set start time tới lúc người dùng set end time
        boolean isChoiceStart = false;
        do {
            System.out.println("Would you want to reset start time? Y/N");
            String choiceStart = input.nextLine();
            switch (choiceStart) {
                case "Y" -> {
                    isChoiceStart = true;
                    watch.start();
                    System.out.println("Start time is: " + watch.getStartTime());
                    boolean isChoiceEnd = false;
                    do {
                        System.out.println("Let's set end time now? Y/N");
                        String choiceEnd = input.nextLine();
                        switch (choiceEnd) {
                            case "Y" -> {
                                isChoiceEnd = true;
                                watch.stop();
                                System.out.println("End time is: " + watch.getEndTime());
                                System.out.println("Distance time in milli second: " + watch.getElapsedTime());
                            }
                            case "N" -> System.out.println("What happen?");
                            default -> System.out.println("Invalid input!");
                        }
                    } while (!isChoiceEnd);
                }
                case "N" -> System.out.println("What happen?");
                default -> System.out.println("Invalid input!");
            }
        } while (!isChoiceStart);
    }
}