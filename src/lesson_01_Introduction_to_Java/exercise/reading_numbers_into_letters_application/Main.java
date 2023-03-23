package lesson_01_Introduction_to_Java.exercise.reading_numbers_into_letters_application;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your number: ");
        int n = sc.nextInt();
        String[] from_0_to_9 = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] lessThan20 = {"ten", "eleven", "twelve", "thirteen", "fourteen",
                "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tensText = {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        if (n < 10 && n >= 0) {
            for (int i = 0; i < 10; i++) {
                if (i == n) {
                    System.out.printf(n + " is " + from_0_to_9[i]);
                }
            }
        } else if (n < 20 && n >= 10) {
            for (int i = 0; i < 10; i++) {
                if (i + 10 == n) {
                    System.out.printf(n + " is " + lessThan20[i]);
                }
            }
        } else if (n < 100 && n >= 20) {
            //dùng n chia 10 lấy phần số nguyên để lấy ra hàng chục của n
            int tens = n / 10;
            //dùng n chia lấy dư cho 10 để lấy ra hàng đơn vị của n
            int units = n % 10;
            if (units == 0) {
                for (int i = 2; i < 10; i++) {
                    if (i == tens) {
                        System.out.printf(n + " is " + tensText[i - 1]);
                    }
                }
            } else {
                for (int i = 2; i < 10; i++) {
                    for (int j = 1; j < 10; j++) {
                        if (i == tens && j == units) {
                            System.out.printf(n + " is " + tensText[i - 1] + " " + from_0_to_9[j]);
                        }
                    }
                }
            }
        } else if (n < 1000 && n >= 100) {
            //dùng n chia 100 rồi lấy phần số nguyên để lấy ra hàng trăm của n
            int hundreds = n / 100;
            /*
            tiếp tục dùng n chia lấy dư cho 100 để ra được hàng chục và đơn vị,
            chia tiếp cho 10 lấy phần số nguyên để lấy ra hàng chục của n
            hoặc chia lấy dư cho 10 để lấy ra hàng đơn vị của n
             */
            int tensAndOnes = n % 100;
            int tens = tensAndOnes / 10;
            int units = tensAndOnes % 10;
            if (tensAndOnes == 0) {
                for (int i = 0; i < 10; i++) {
                    if (i == hundreds) {
                        System.out.printf(n + " is " + from_0_to_9[i] + " hundred");
                    }
                }
            } else if (units == 0) {
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (i == hundreds && j == tens) {
                            System.out.printf(n + " is " + from_0_to_9[i] + " hundred and " + tensText[j - 1]);
                        }
                    }
                }
            } else if (tens == 0){
                for (int i = 0; i < 10; i++) {
                    for (int j = 1; j < 10; j++) {
                        if (i == hundreds && j == units) {
                            System.out.printf(n + " is " + from_0_to_9[i] + " hundred and " + from_0_to_9[j]);
                        }
                    }
                }
            } else if (tens == 1) {
                for (int i = 0; i < 10; i++) {
                    for (int j = 1; j < 10; j++) {
                        if (i == hundreds && j == units) {
                            System.out.printf(n + " is " + from_0_to_9[i] + " hundred and " + lessThan20[j]);
                        }
                    }
                }
            } else {
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        for (int k = 0; k < 10; k++) {
                            if (i == hundreds && j == tens && k == units) {
                                System.out.printf(n + " is " + from_0_to_9[i]
                                        + " hundred and " + tensText[j - 1] + "-" + from_0_to_9[k]);
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Out of ability");
        }
    }
}