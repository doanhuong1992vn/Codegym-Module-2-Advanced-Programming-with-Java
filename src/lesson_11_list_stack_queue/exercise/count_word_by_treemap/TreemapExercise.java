package lesson_11_list_stack_queue.exercise.count_word_by_treemap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreemapExercise {
    public static void main(String[] args) {
        //tạo treemap với key kiểu String, value kiểu Integer,
        //tham số Comparator.naturalOrder() trong constructor new TreeMap<>() để sắp xếp các phần tử trong treemap theo thứ tự alphabet
        TreeMap<String, Integer> myTreeMap = new TreeMap<>(Comparator.naturalOrder());
        String paragram = getString().toUpperCase();
        String[] wordArray = paragram.split(" ");
        for (int i = 0; i < wordArray.length; i++) {
            //xét xem key này đã có trong treemap hay chưa?
            if (myTreeMap.containsKey(wordArray[i])) {
                //dùng biến currentValue để hứng giá trị được trả về tại Node có key đó
                int currentValue = myTreeMap.get(wordArray[i]);
                //dùng repalce(key, newValue) để thay thế value cũ đang liên kết với key được chỉ định thành value mới
                myTreeMap.replace(wordArray[i], currentValue + 1);
            } else {
                myTreeMap.put(wordArray[i], 1);
            }
        }
        //Sử dụng Map.Entry interface - duyệt các phần tử của TreeMap
        //link hướng dẫn: https://viettuts.vn/java-collection/treemap-trong-java
        for (Map.Entry<String, Integer> node : myTreeMap.entrySet()) {
            System.out.println("The word " + node.getKey() + " appears " + node.getValue() + " times.");
        }

    }

    static String getString() {
        return "Java là một ngôn ngữ lập trình hướng đối tượng dựa trên lớp được thiết kế để có càng ít phụ thuộc " +
                "thực thi càng tốt Nó là ngôn ngữ lập trình có mục đích chung cho phép các nhà phát triển ứng dụng " +
                "viết một lần chạy ở mọi nơi nghĩa là mã Java đã biên dịch có thể chạy trên tất cả các nền tảng hỗ " +
                "trợ Java mà không cần biên dịch lại Các ứng dụng Java thường được biên dịch thành bytecode có thể " +
                "chạy trên bất kỳ máy ảo Java (JVM) nào bất kể kiến trúc máy tính bên dưới Cú pháp của Java tương tự " +
                "như C và C++ nhưng có ít cơ sở cấp thấp hơn các ngôn ngữ trên Java runtime cung cấp các khả năng " +
                "động chẳng hạn như phản ánh và sửa đổi mã thời gian chạy thường không có sẵn trong các ngôn ngữ biên " +
                "dịch truyền thống Tính đến năm 2019 Java là một trong những ngôn ngữ lập trình phổ biến nhất được " +
                "sử dụng theo GitHub đặc biệt cho các ứng dụng web máy khách-máy chủ với 9 triệu nhà phát triển " +
                "đã được báo cáo";
    }
}
