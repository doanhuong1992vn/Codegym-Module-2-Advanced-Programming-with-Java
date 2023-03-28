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

    static {
        List<Customer> dataList = FileReadingUtils.readCustomerData(
                "src\\case_study_Enjoy_Galaxy\\model\\data\\customer.csv");
        USER_LIST.addAll(dataList);
    }

    private UserService() {
    }

    public static UserService getInstance() {
        return userService;
    }

    private String notification;
    private User currentUser;

    public boolean createAccount(String fullName, String phoneNumber, String email, String password, String typeUser) {
        if (checkEmailAndPhoneNumber(email, phoneNumber)) {
            notification = "Phone number or email is already registered";
            return false;
        } else {
            UserFactory userFactory = UserFactory.getInstance();
            currentUser = userFactory.getUser(fullName, phoneNumber, email, password, typeUser);
            USER_LIST.add(currentUser);
            notification = "Successful registration. Welcome " + fullName + " to Enjoy Galaxy!";
            return true;
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

    public String getNotification() {
        return notification;
    }
}
