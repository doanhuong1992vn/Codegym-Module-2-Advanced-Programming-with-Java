package lesson_04_class_object_in_java.class_stopWatch;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StopWatch watch = new StopWatch();
        System.out.println("Now is: " + watch.getStartTime());
        Scanner input = new Scanner(System.in);
        //game nhỏ: đo thời gian thực thi từ lúc người dùng set start time tới lúc người dùng set end time
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
        //bài tập: đo thời gian thực thi của thuật toán sắp xếp chọn (selection sort) cho 100,000 số:
        long[] array = new long[100000];
        for(int i = 0; i<100000; i++) {
            array[i] = Math.round(Math.random()*100000);
        }
        System.out.println("Now, I have an array with 100,000 long elements. But it's not yet sort.");
        boolean isChoiceSort = false;
        do {
            System.out.println("Would you like to sort that now? Y/N");
            String choiceSort = input.next();
            switch (choiceSort) {
                case "Y" -> {
                    isChoiceSort = true;
                    watch.start();
                    System.out.println("Start time is: " + watch.getStartTime());
                    Arrays.sort(array);
                    watch.stop();
                    System.out.println("End time is: " + watch.getEndTime());
                    System.out.println("Distance time in milli second: " + watch.getElapsedTime());
                }
                case "N" -> System.out.println("What happen?");
                default -> System.out.println("Invalid input!");
            }
        } while (!isChoiceSort);
    }
}