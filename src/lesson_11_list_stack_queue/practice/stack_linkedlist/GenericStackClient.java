package lesson_11_list_stack_queue.practice.stack_linkedlist;

public class GenericStackClient {
    public static void main(String[] args) {
        System.out.println("1. Stack of integers");
        stackOfInteger();
        System.out.println("\n2. Stack of Strings");
        stackOfStrings();
    }

    private static void stackOfStrings() {
        MyGenericStack<String> nameList = new MyGenericStack<>();
        nameList.push("Hưởng");
        nameList.push("Lâm");
        nameList.push("Thái");
        nameList.push("Minh");
        nameList.push("Khánh");
        nameList.push("Trình");
        System.out.println("Size of Name's List after push elements: " + nameList.size());
        System.out.println("Pop name from Name's List: ");
        nameList.pop();
        System.out.println("Size of Name's List after pop elements: " + nameList.size());
    }

    private static void stackOfInteger() {
        MyGenericStack<Integer> ageList = new MyGenericStack<>();
        ageList.push(18);
        ageList.push(19);
        ageList.push(20);
        ageList.push(21);
        ageList.push(22);
        ageList.push(23);
        System.out.println("Size of Age's List after push elements: " + ageList.size());
        System.out.println("Pop name from Age's List: ");
        ageList.pop();
        System.out.println("Size of Age's List after pop elements: " + ageList.size());
    }
}
