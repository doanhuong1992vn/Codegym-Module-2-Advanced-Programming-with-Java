package case_study_Enjoy_Galaxy.model.factory;

import case_study_Enjoy_Galaxy.model.entity.users.Admin;
import case_study_Enjoy_Galaxy.model.entity.users.Customer;
import case_study_Enjoy_Galaxy.model.entity.users.Staff;
import case_study_Enjoy_Galaxy.model.entity.users.abstraction.User;

public class UserFactory {
    private static final UserFactory userFactory = new UserFactory();

    private UserFactory() {
    }

    public static UserFactory getInstance() {
        return userFactory;
    }

    public User getUser(String typeUser, String fullName, String phoneNumber, String email, String password) {
        String typeUserToUpperCase = typeUser.toUpperCase();
        switch (typeUserToUpperCase) {
            case "STAFF" -> {
                return new Staff(fullName, phoneNumber, email, password);
            }
            case "ADMIN" -> {
                return new Admin(fullName, phoneNumber, email, password);
            }
            default -> {
                return new Customer(fullName, phoneNumber, email, password);
            }
        }
    }
}
