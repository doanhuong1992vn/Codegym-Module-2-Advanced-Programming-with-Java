package lesson_18_threading.homework;

public class TestSendEmail {
    public static void main(String[] args) {
        User minh = new User("minh@gmail.com", 3000);
        User khanh = new User("khanh@gmail.com", 1000);
        User thai = new User("thai@yahoo.com", 4000);
        User phuoc = new User("phuoc@yahoo.com", 5000);

        Thread threadMinh = new Thread(minh);
        Thread threadKhanh = new Thread(khanh);
        Thread threadThai = new Thread(thai);
        Thread threadPhuoc = new Thread(phuoc);
        threadKhanh.setPriority(Thread.MAX_PRIORITY);
        threadPhuoc.setPriority(Thread.MIN_PRIORITY);

        threadPhuoc.start();
        threadMinh.start();
        threadKhanh.start();
        threadThai.start();
    }
}
