package lesson_18_threading.practice.build_number_counting_application;

public class Main {
    public static void main(String[] args) {
        Count count = new Count();
        try {
            while (count.getMyThread().isAlive()) {
                System.out.println("TestNumberGenerator thread will be alive till the child thread is live");
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            System.out.println("TestNumberGenerator thread interrupted");
        }
        System.out.println("TestNumberGenerator thread run is over");

    }
}
