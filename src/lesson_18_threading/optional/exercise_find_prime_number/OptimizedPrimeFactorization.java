package lesson_18_threading.optional.exercise_find_prime_number;

public class OptimizedPrimeFactorization implements Runnable {
    @Override
    public void run() {
        for (int i = 2; i < Integer.MAX_VALUE; i++) {
            if (isPrimeNumber(i)) {
                System.out.println("OptimizedPrimeFactorization: " + i);
            }
        }
    }

    private static boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        } else if (number == 2) {
            return true;
        } else if (number % 2 == 0) {
            return false;
        } else {
            for (int i = 3; i < Math.sqrt(number); i += 2) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
