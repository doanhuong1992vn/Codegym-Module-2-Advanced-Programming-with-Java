package lesson_18_threading.practice.build_number_counting_application;

public class Count implements Runnable {
    private Thread myThread;

    public Count() {
        myThread = new Thread(this, "My runnable thread");
        System.out.println("My thread created " + myThread);
        myThread.start();
    }
    public Thread getMyThread() {
        return myThread;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i ++) {
                System.out.println("Printing the count " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("My thread run is over");
    }
}
