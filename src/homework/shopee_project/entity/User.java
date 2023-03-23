package homework.shopee_project.entity;

public class User {
    private final long id;
    private String userName;
    private String password;
    private static long count = 0;

    public User(String userName, String password) {
        this.id = ++count;
        this.userName = userName;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
