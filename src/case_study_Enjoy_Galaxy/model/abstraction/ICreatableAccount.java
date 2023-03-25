package case_study_Enjoy_Galaxy.model.abstraction;

import case_study_Enjoy_Galaxy.model.entity.users.User;
import com.sun.source.tree.StatementTree;

public interface ICreatableAccount {
    boolean createAccount(String fullName, String phoneNumber, String email, String password);
}
