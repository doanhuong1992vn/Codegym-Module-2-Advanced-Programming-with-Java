package case_study_Enjoy_Galaxy.model.builder.staff_builder;

import case_study_Enjoy_Galaxy.model.entity.users.Staff;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StaffConcreteBuilder implements IStaffBuilder{
    private String fullName;
    private String phoneNumber;
    private String email;
    private String password;
    private String education;
    private String jobTitle;
    private double salary;
    private Date birthDay;
    private String address;

    @Override
    public IStaffBuilder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @Override
    public IStaffBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public IStaffBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public IStaffBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public IStaffBuilder setEducation(String education) {
        this.education = education;
        return this;
    }

    @Override
    public IStaffBuilder setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    @Override
    public IStaffBuilder setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    @Override
    public IStaffBuilder setBirthDay(String strBirthDay) throws ParseException {
        this.birthDay = new SimpleDateFormat("dd/MM/yyyy").parse(strBirthDay);
        return this;
    }

    @Override
    public IStaffBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public Staff build() {
        return new Staff(fullName, phoneNumber, email, password, education, jobTitle, salary, birthDay, address);
    }
}
