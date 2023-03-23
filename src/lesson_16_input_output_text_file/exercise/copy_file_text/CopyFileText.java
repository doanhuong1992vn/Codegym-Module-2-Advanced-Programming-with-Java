package lesson_16_input_output_text_file.exercise.copy_file_text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CopyFileText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File srcFile;
        do {
            System.out.println("Enter name of the source file: ");
            String srcFilePath = scanner.nextLine();
            srcFile = new File(srcFilePath);
            if(!srcFile.exists()) {
                System.err.println("Source file not found!!!");
            }
        } while (!srcFile.exists());
        File targetFile;
        do {
            System.out.println("Enter name of the target file: ");
            String targetFilePath = scanner.nextLine();
            targetFile = new File(targetFilePath);
            if (targetFile.exists()) {
                System.err.println("The target file already exists");
            }
        } while (targetFile.exists());

        copyFileText(srcFile, targetFile);
    }
    public static void copyFileText(File srcFile, File targetFile) {
        try (FileReader fileReader = new FileReader(srcFile);
             FileWriter fileWriter = new FileWriter(targetFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            int c;
            List<Integer> characters = new ArrayList<>();
//            List<Character> testCharList = new ArrayList<>();
            while ((c = bufferedReader.read()) != -1) {//mỗi chỗ xuống dòng được tính thành 1 cái \r và 1 cái \n
//                testCharList.add((char) c);
                characters.add(c);
                bufferedWriter.write(c);
            }
//            System.out.println(testCharList.toString());
//            System.out.println(characters.toString());
            System.out.println("Tổng số ký tự trong file: " + characters.size());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
