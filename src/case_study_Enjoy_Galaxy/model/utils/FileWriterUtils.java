package case_study_Enjoy_Galaxy.model.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class FileWriterUtils {
    public static void writeTicket(String ticketCode, String content) {
        String PATH = "src\\case_study_Enjoy_Galaxy\\model\\data\\tickets\\" + ticketCode + ".txt";
//        File file = new File(PATH);
        try (FileWriter fileWriter = new FileWriter(PATH);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(content);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
