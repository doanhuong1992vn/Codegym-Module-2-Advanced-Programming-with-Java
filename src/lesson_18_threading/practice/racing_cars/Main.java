package lesson_18_threading.practice.racing_cars;

public class Main {
    public static final int DISTANCE = 200;
    public static final int STEP = 1;

    public static void main(String[] args) {
        Car firstCar = new Car("The first car");
        Car secondCar = new Car("The second car");
        Car thirdCar = new Car("The third car");

        Thread firstThread = new Thread(firstCar);
        Thread secondThread = new Thread(secondCar);
        Thread thirdThread = new Thread(thirdCar);

        System.out.println("Distance: 200KM");
        firstThread.start();
        secondThread.start();
        thirdThread.start();
    }
}
