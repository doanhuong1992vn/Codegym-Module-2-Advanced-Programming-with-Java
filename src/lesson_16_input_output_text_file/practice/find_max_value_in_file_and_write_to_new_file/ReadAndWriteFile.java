package lesson_16_input_output_text_file.practice.find_max_value_in_file_and_write_to_new_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("numbers.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("max-numbers.txt", maxValue);
    }

    public List<Integer> readFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return numbers;
    }

    public void writeFile(String filePath, int max) {
        try (FileWriter fileWriter = new FileWriter(filePath, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write("Giá trị lớn nhất là: " + max);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static int findMax(List<Integer> numbers) {
        int max = 0;
        try {
            max = numbers.get(0);
            for(Integer number: numbers) {
                if (max < number) {
                    max = number;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
        return max;
    }
}
