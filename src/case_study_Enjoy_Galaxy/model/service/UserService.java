package case_study_Enjoy_Galaxy.model.service;

import case_study_Enjoy_Galaxy.model.entity.users.Customer;
import case_study_Enjoy_Galaxy.model.entity.users.abstraction.User;
import case_study_Enjoy_Galaxy.model.factory.UserFactory;
import case_study_Enjoy_Galaxy.model.utils.FileReadingUtils;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static final UserService userService = new UserService();
    private static final List<User> USER_LIST = new ArrayList<>();
    private static final String PATH = "src\\case_study_Enjoy_Galaxy\\model\\data\\customer.csv";

    static {
        List<Customer> dataList = FileReadingUtils.readCustomerData(PATH);
        USER_LIST.addAll(dataList);
    }

    private UserService() {
    }

    public static UserService getInstance() {
        return userService;
    }

    private String notification;
    private User currentUser;

    public void createAccount(String typeUser, String fullName, String phoneNumber, String email, String password) {
        if (checkEmailAndPhoneNumber(email, phoneNumber)) {
            notification = "Phone number or email is already registered";
        } else {
            UserFactory userFactory = UserFactory.getInstance();
            currentUser = userFactory.getUser(typeUser, fullName, phoneNumber, email, password);
            USER_LIST.add(currentUser);
            notification = "Successful registration. Welcome " + fullName + " to Enjoy Galaxy!";
        }
    }

    public boolean checkEmailAndPhoneNumber(String email, String phoneNumber) {
        for (User user : USER_LIST) {
            if (email.equals(user.getEmail()) || phoneNumber.equals(user.getPhoneNumber())) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public String getNotification() {
        return notification;
    }
}
