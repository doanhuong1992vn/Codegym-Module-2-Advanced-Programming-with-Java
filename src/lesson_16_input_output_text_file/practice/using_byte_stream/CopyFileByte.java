package lesson_16_input_output_text_file.practice.using_byte_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileByte {
    public static void main(String[] args) throws IOException {
        try (FileInputStream inputStream = new FileInputStream("inStream.txt");
             FileOutputStream outputStream = new FileOutputStream("outStream.txt")) {

            int c;
            while ((c = inputStream.read()) != -1) {
                System.out.println((char) c);
                outputStream.write(c);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
