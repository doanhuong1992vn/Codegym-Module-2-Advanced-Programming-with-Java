/*
package case_study_demo.model.service;

import case_study_demo.model.utils.FileReadingUtils;
import case_study_demo.model.entity.users.Customer;
import case_study_demo.model.entity.users.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static final List<User> userList = new ArrayList<>();
    static {
        List<Customer> dataList = FileReadingUtils.readCustomerData(
                "src\\case_study_Enjoy_Galaxy\\model\\data\\customer.csv");
        userList.addAll(dataList);
    }
    private String notification;
    private User currentUser;

    public boolean createCustomerAccount(String fullName, String phoneNumber, String email, String password) {
        if (checkEmailAndPhoneNumber(email, phoneNumber)) {
            notification = "Phone number or email is already registered";
            return false;
        } else {
            currentUser = new Customer(fullName, phoneNumber, email, password);
            userList.add(currentUser);
            notification = "Successful registration. Welcome " + fullName + " to Enjoy Galaxy!";
            return true;
        }
    }

    public boolean checkEmailAndPhoneNumber(String email, String phoneNumber) {
        for (User user: userList) {
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
*/
