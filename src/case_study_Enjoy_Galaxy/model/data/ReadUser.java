package case_study_Enjoy_Galaxy.model.data;

import case_study_Enjoy_Galaxy.model.entity.users.Customer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ReadUser {
    public static List<Customer> readCustomerData() {
        List<Customer> customerList = new LinkedList<>();
        File file = new File("src\\case_study_Enjoy_Galaxy\\model\\data\\customer.csv");
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] properties = line.split(", ");
                customerList.add(new Customer(properties[0], properties[1], properties[2], properties[3]));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return customerList;
    }
}
