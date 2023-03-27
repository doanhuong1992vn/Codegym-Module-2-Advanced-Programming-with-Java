package case_study_Enjoy_Galaxy.model.entity.users;

import case_study_Enjoy_Galaxy.model.abstraction.User;

public class Admin extends User {
    public Admin(String phoneNumber, String email, String password) {
        super(phoneNumber, email, password);
    }

    public Admin(String fullName, String phoneNumber, String email, String password) {
        super(fullName, phoneNumber, email, password);
    }

    @Override
    public String toString() {
        return null;
    }
}
