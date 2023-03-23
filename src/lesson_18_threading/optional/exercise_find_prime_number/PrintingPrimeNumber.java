package lesson_18_threading.optional.exercise_find_prime_number;

public class PrintingPrimeNumber {
    public static void main(String[] args) {
        Thread lazyPrimeFactorization = new Thread(new LazyPrimeFactorization());
        Thread optimizedPrimeFactorization = new Thread(new OptimizedPrimeFactorization());
        lazyPrimeFactorization.start();
        optimizedPrimeFactorization.start();
    }
}

