package case_study_demo.model.abstraction;

public interface ICreatableAccount {
    boolean createAccount(String fullName, String phoneNumber, String email, String password);
}
