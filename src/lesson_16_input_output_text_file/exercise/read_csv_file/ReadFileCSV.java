package lesson_16_input_output_text_file.exercise.read_csv_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCSV {
    public static void main(String[] args) throws IOException {
    readFileCSV("src\\exercise_read_csv_file\\new-file.csv");
    }
    public static void readFileCSV(String filePath) {
        File file = new File("src\\exercise_read_csv_file\\target.csv");
        try (FileReader fileReader = new FileReader(filePath);
             FileWriter fileWriter = new FileWriter(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            String line = "";
            List<String> countries = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line + "\n");
                String[] arrayOfLine = line.split(",");
                countries.add(arrayOfLine[2]);
            }
            System.out.println("Danh sách các quốc gia:");
            countries.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
