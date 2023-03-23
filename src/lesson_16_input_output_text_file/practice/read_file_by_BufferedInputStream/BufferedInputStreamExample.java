package lesson_16_input_output_text_file.practice.read_file_by_BufferedInputStream;

import java.io.*;

public class BufferedInputStreamExample {
    public static void main(String[] args) {
        File file = new File("inStream.txt");
        try (FileInputStream fileInputStream = new FileInputStream(file);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
             DataInputStream dataInputStream = new DataInputStream(bufferedInputStream)) {

            while (dataInputStream.available() != 0) {
                System.out.println(dataInputStream.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
