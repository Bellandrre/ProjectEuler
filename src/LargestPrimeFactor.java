/**
 *
 * Finding the largest prime factor of a given number
 * Naive approach -
 * Check if number is divisible by any number less than sqrt(givenNumber) and then check if that number is prime
 * O(sqrt(n))
 *
 * Better approach -
 * All natural numbers can be expressed as a product of unique prime numbers.
 *
 */

public class LargestPrimeFactor {


    public static long findLargestPrimeFactor(long num){

        long root = (long)Math.sqrt(num);
        long largestPrimeFactor = 0;
        for(long l = root; l >=1 ; l--){
            if(num % l == 0){
                //Possible prime number
                //Check if this is a prime
                if(isPrime(l)){
                    largestPrimeFactor = Math.max(largestPrimeFactor,l);
                }
            }
        }
        return largestPrimeFactor;
    }

    public static boolean isPrime(long candidate){
        int factors = 2; // one and itself
        for(long l = 2; l < Math.sqrt(candidate); l++){
            if(candidate % l == 0) {
                factors++;
            }
        }
        return factors == 2;
    }




    public static void main(String[] args) {
        System.out.println(findLargestPrimeFactor(15));
    }
}
