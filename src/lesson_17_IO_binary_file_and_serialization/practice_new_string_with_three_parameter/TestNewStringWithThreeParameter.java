package lesson_17_IO_binary_file_and_serialization.practice_new_string_with_three_parameter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestNewStringWithThreeParameter {
    public static void main(String[] args) throws IOException {

        // Tạo một luồng đầu vào bằng cách đọc một file
        // File CodeGym.txt có chứa từ khóa: Hello InputStream
        InputStream in = new FileInputStream("CodeGym.txt");

        // Mảng để mỗi lần đọc các byte từ luồng thì tạm thời để lên đó
        // Ta dùng mảng 10 byte

        byte[] bytes = new byte[20];
        int i = -1;

        // Đọc các byte trong luồng và gán lên các phần tử của mảng.
        // Giá trị i là số đọc được của 1 lần. (i sẽ <= 10).
        // Khi không còn phần tử trong luồng i sẽ = -1
        while ((i = in.read(bytes)) != -1) {
            // Tạo String từ các byte đọc được
            String s = new String(bytes, 0, i);
            System.out.println(s);
        }
        in.close();
    }
}
