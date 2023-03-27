package case_study_Enjoy_Galaxy.model.factory;

import case_study_Enjoy_Galaxy.model.entity.users.Admin;
import case_study_Enjoy_Galaxy.model.entity.users.Customer;
import case_study_Enjoy_Galaxy.model.entity.users.Staff;
import case_study_Enjoy_Galaxy.model.entity.users.User;

public class UserFactory {
    private static final UserFactory userFactory = new UserFactory();

    private UserFactory() {
    }

    public static UserFactory getInstance() {
        return userFactory;
    }

    public User getUser(String fullName, String phoneNumber, String email, String password, String typeUser) {
        switch (typeUser) {
            case "customer" -> {
                return new Customer(fullName, phoneNumber, email, password);
            }
            case "staff" -> {
                return new Staff(fullName, phoneNumber, email, password);
            }
            case "admin" -> {
                return new Admin(fullName, phoneNumber, email, password);
            }
            default -> {
                return null;
            }
        }
    }
}
