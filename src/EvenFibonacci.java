/**
 *
 * Find the sum of even fibonacci numbers
 * Recurrence relation f(n) = f(n-1) + f(n-2)
 * This is a naive approach where we iterate through all the terms and see if the term is even or not.
 * A better way to do this is to look at the sequence  |0|, 1, 1, |2|, 3, 5, |8|, 13, 21, |34|
 * We see that every third term in the sequence is even so we can express the above recurrence relation w.r.t f(n-3) and f(n-6)
 * So, f(n) = f(n-1) + f(n-2)
 *          = f(n-2) + f(n-3) + f(n-3) + f(n-4)
 *          = f(n-3) + f(n-4) + f(n-3) + f(n-3) + f(n-4)
 *          = 3f(n-3) + 2f(n-4)
 *          = 3f(n-3) + f(n-4) + f(n-5) + f(n-6)
 *          = 4f(n-3) + f(n-6)
 */

public class EvenFibonacci {
    // O(terms)
    public static long fibonacciSum(int terms){
        long a = 0;
        long b = 1;
        long c = 0;
        long sum = 0;

        while(c < terms){
            c = a + b;
            a = b;
            b = c;
            if(c % 2 == 0) sum += c;
        }
        return sum;
    }

    // Little improvement calculating only the even terms  < O(terms)
    public static long fibonacciSumImproved(int terms){
        long fib_3 = 0;
        long fib_6 = 2;
        long c = 0;
        long sum = 0;

        while(c < terms){
            sum += c;
            c = (4 * fib_3) + fib_6;
            fib_6 = fib_3;
            fib_3 = c;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(fibonacciSum(4000000));
        System.out.println(fibonacciSumImproved(4000000));
    }
}
