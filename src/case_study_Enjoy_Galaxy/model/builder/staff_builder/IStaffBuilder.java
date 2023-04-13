package case_study_Enjoy_Galaxy.model.builder.staff_builder;

import case_study_Enjoy_Galaxy.model.entity.users.Staff;
import case_study_Enjoy_Galaxy.model.entity.users.abstraction.User;

import java.text.ParseException;

public interface IStaffBuilder {
    IStaffBuilder setId(long id);
    IStaffBuilder setFullName(String fullName);
    IStaffBuilder setPhoneNumber(String phoneNumber);
    IStaffBuilder setEmail(String email);
    IStaffBuilder setPassword(String password);
    IStaffBuilder setEducation(String education);
    IStaffBuilder setJobTitle(String jobTitle);
    IStaffBuilder setSalary(double salary);
    IStaffBuilder setBirthDay(String strBirthDay) throws ParseException;
    IStaffBuilder setAddress(String address);
    IStaffBuilder setWallet(double wallet);
    User build() throws ParseException;
    Staff buildFullInformation() throws ParseException;
}
