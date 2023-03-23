package lesson_18_threading.exercise.create_simple_thread;

public class TestNumberGenerator {
    public static void main(String[] args) {
        NumberGenerator numberGenerator1 = new NumberGenerator("First");
        NumberGenerator numberGenerator2 = new NumberGenerator("Second");

        Thread threadMaxPriority = new Thread(numberGenerator1, "Max Priority");
        Thread threadMinPriority = new Thread(numberGenerator2, "Min Priority");

        threadMaxPriority.setPriority(Thread.MAX_PRIORITY);
        threadMinPriority.setPriority(Thread.MIN_PRIORITY);

        threadMinPriority.start();
        threadMaxPriority.start();
    }
}
