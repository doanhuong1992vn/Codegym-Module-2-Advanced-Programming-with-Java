package lesson_18_threading.exercise.create_simple_thread;

public class NumberGenerator implements Runnable{
    private String name;

    public NumberGenerator(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + ": Hashcode of " + name + " is " + this.hashCode());
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
