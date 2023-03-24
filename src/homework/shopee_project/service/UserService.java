package homework.shopee_project.service;

import homework.shopee_project.entity.User;

import java.util.HashMap;

public class UserService {
    private static final HashMap<String, User> userMap = new HashMap<>();
    private static User currentUser;

    static {
        userMap.put("admin", new User("admin", "123"));
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUserByNull() {
        currentUser = null;
    }

    public void createAccountAndSave(String userName, String password) {
        currentUser = new User(userName, password);
        userMap.put(currentUser.getUserName(), currentUser);
    }

    public boolean checkUserName(String userName) {
        if (userMap.isEmpty()) {
            return true;
        } else return !userMap.containsKey(userName);
    }

    public boolean checkSignIn(String userName, String password) {
        if (userMap.containsKey(userName)) {
            currentUser = userMap.get(userName);
            return password.equals(currentUser.getPassword());
        } else {
            return false;
        }
    }
}
