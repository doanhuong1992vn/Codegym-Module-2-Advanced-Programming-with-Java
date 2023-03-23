package lesson_18_threading.practice.create_thread_by_runable;

public class Main {
    public static void main(String[] args) {
        System.out.println("TestNumberGenerator thread running... ");
        RunnableDemo runnableDemo1 = new RunnableDemo("Thread-1-HR-Database");
        runnableDemo1.start();
        RunnableDemo runnableDemo2 = new RunnableDemo("Thread-2-Send-Email");
        runnableDemo2.start();
        System.out.println("TestNumberGenerator thread stopped!!! ");
    }
}
