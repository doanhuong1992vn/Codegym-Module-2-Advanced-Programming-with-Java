package lesson_18_threading.practice.priority_of_thread;

class TestMultiPriority extends Thread {
    public void run() {
        System.out.println("running thread name is:"
                + Thread.currentThread().getName());
        System.out.println("running thread priority is:"
                + Thread.currentThread().getPriority());
    }

    public static void main(String args[]) {
        TestMultiPriority m0 = new TestMultiPriority();
        TestMultiPriority m1 = new TestMultiPriority();
        m0.setPriority(Thread.MIN_PRIORITY);
        m1.setPriority(Thread.MAX_PRIORITY);
        m0.start();
        m1.start();
    }
}
