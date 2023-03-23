package lesson_16_input_output_text_file.practice.get_sum_of_numbers_in_file_text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFileExample {
    public static void main(String[] args) {
        System.out.println("Nhập tên file: ");
        Scanner scanner = new Scanner(System.in);
        String filePatch = scanner.nextLine();
        ReadFileExample readFileExample = new ReadFileExample();
        readFileExample.readFileText(filePatch);
    }
    public void readFileText(String filePath) {
        try {
            File file = new File(filePath);
            if(!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            int sum = 0;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            bufferedReader.close();
            System.out.println("Tổng các số trong file: " + sum);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
