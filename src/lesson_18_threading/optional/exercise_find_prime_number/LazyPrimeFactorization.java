package lesson_18_threading.optional.exercise_find_prime_number;

public class LazyPrimeFactorization implements Runnable{
    @Override
    public void run() {
        for (int i = 2; i < Integer.MAX_VALUE; i++) {
            if (isPrimeNumber(i)) {
                System.out.println("LazyPrimeFactorization: " + i);
            }
        }
    }

    private static boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        } else if (number == 2) {
            return true;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
