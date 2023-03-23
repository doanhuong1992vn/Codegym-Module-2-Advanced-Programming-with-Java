package lesson_18_threading.practice.racing_cars;

import java.util.Random;

import static lesson_18_threading.practice.racing_cars.Main.*;

public class Car implements Runnable{
    private final String name;
    public Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int runDistance = 0;
        long startTime = System.currentTimeMillis();
        while (runDistance < DISTANCE) {
            try {
                int speed = new Random().nextInt(20) + 1;
                runDistance += speed;
                StringBuilder log = new StringBuilder("|");
                int percentTravel = (runDistance * 100) / DISTANCE;
                for (int i = 0; i < DISTANCE; i += STEP) {
                    if (percentTravel >= i + STEP) {
                        log.append("=");
                    } else if (percentTravel >= i && percentTravel < i + STEP) {
                        log.append("o");
                    } else {
                        log.append("-");
                    }
                }
                log.append("|");
                System.out.println(name + ": " + log + " " + Math.min(DISTANCE, runDistance) + "KM");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(name + " broken...");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        long timeTravel = (endTime - startTime) / 1000;
        System.out.println(name + " finish in " + timeTravel + "s");
    }
}
