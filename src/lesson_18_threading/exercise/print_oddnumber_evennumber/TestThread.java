package lesson_18_threading.exercise.print_oddnumber_evennumber;

public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        EvenThread evenThread = new EvenThread();
        OddThread oddThread = new OddThread();
        oddThread.start();
        oddThread.join();
        evenThread.start();
    }
}
