public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int max = array[0];
        for (int i: array) {
            if (max < i) {
                max = i;
            }
        }
        System.out.println("Max element is " + max);
    }
}