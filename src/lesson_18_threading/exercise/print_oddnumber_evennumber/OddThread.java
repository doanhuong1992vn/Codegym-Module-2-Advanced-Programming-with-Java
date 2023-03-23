package lesson_18_threading.exercise.print_oddnumber_evennumber;

public class OddThread extends Thread{
    @Override
    public void run() {
        try {
            for (int i = 1; i < 10; i+=2) {
                sleep(500);
                System.out.println("Print the odd number: " + i);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
