package lesson_18_threading.exercise.print_oddnumber_evennumber;

public class EvenThread extends Thread{
    @Override
    public void run() {
        try {
            for (int i = 2; i <= 10; i+=2) {
                System.out.println("Print the even number: " + i);
                sleep(400);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
