package lesson_16_input_output_text_file.practice.using_character_stream;

import java.io.*;

public class CopyFileCharacter {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("new-file.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter("copy-by-character-stream.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            int c;
            while ((c = bufferedReader.read()) != -1) {
                bufferedWriter.write(c);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
