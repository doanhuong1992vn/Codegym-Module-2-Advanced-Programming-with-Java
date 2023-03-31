package case_study_Enjoy_Galaxy.model.entity.users;

import case_study_Enjoy_Galaxy.model.entity.users.abstraction.User;

public class Admin extends User {
    private static final Admin ADMIN = new Admin(
            "Đoàn Hưởng",
            "0888442448",
            "huong@gmail.com",
            "123");

    private Admin(String fullName, String phoneNumber, String email, String password) {
        super(fullName, phoneNumber, email, password);
    }
    public static Admin getInstance() {
        return ADMIN;
    }
    @Override
    public String toString() {
        return "Admin Đoàn Hưởng";
    }
}
