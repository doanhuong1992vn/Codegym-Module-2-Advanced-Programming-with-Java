package lesson_18_threading.homework;

public class User implements Runnable{
    private String email;
    private long replyTime;

    public User(String email, long replyTime) {
        this.email = email;
        this.replyTime = replyTime;
    }
    public void sendEmail() {
        try {
            System.out.println(email + " has send a email.");
            Thread.sleep(replyTime);
            System.out.println(email + " sent successfully!");
        }catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void run() {
        sendEmail();
    }
}
