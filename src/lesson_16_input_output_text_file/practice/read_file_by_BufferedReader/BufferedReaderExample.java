package lesson_16_input_output_text_file.practice.read_file_by_BufferedReader;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReaderExample {
    public static void main(String[] args) {
//        FileReader fileReader = null;
//        BufferedReader bufferedReader = null;
        try(FileReader fileReader = new FileReader("newa-file.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);) {
//            fileReader = new FileReader("new-file.txt");
//            bufferedReader = new BufferedReader(fileReader);
            int i = bufferedReader.read();
            while (i != -1) {
                System.out.print((char) i);
                i = bufferedReader.read();
            }
        } catch (Exception e) {
            System.out.println("Lỗi file!!!");
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }
        System.out.println("ok");
/*        } finally {
            assert fileReader != null;
            fileReader.close();
            assert bufferedReader != null;
            bufferedReader.close();
        }*/
    }
}
