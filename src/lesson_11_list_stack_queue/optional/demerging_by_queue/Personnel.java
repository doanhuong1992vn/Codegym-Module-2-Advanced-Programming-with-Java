package lesson_11_list_stack_queue.optional.demerging_by_queue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Personnel {
    private final String name;
    private final String gender;
    private final String stringBirthday;
    private final Date birthday;

    public Personnel(String name, String gender, String stringBirthday) throws ParseException {
        this.name = name;
        this.gender = gender;
        this.stringBirthday = stringBirthday;
        this.birthday = new SimpleDateFormat("dd/MM/yyyy").parse(stringBirthday);
    }

    public String getGender() {
        return gender;
    }

    public long getMillisOfBirthday() {
        return birthday.getTime();
    }

    @Override
    public String toString() {
        return name + ": " + gender + ", " + stringBirthday;
    }

}
