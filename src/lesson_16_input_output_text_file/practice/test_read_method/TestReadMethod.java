package lesson_16_input_output_text_file.practice.test_read_method;

import java.io.IOException;

public class TestReadMethod {
    public static void main(String[] args) throws IOException {
//        System.out.println("simple message");
//        System.err.println("error message");
        System.out.println("Enter a string: ");
        int i=System.in.read();//tra ve ma ASCII cua ky tu dau tien
        System.out.println("ASCII of the first character: " + i);
        System.out.println("The first character in your string: " + (char) i);//in ky tu lay duoc ra man hinh
    }
}
