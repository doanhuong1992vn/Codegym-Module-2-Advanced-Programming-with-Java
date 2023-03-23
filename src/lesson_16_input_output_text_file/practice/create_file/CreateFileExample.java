package lesson_16_input_output_text_file.practice.create_file;

import java.io.File;
import java.io.IOException;

public class CreateFileExample {
    public static void main(String[] args) {
        try {
            File file = new File("new-file.txt");
            if(file.createNewFile()) {
                System.out.println("File đã được tạo!");
            } else {
                System.out.println("File đã tồn tại!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
