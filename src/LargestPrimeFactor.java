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
        long largestPrimeFactor = 0;
        for(long l = 2; l * l < num ; l++){
            if(num % l == 0){
                //Possible prime number
                //Check if this is a prime
                if(isPrime(l)){
                    largestPrimeFactor = Math.max(largestPrimeFactor,l);
                }
                if(isPrime(num/l)){
                    largestPrimeFactor = Math.max(largestPrimeFactor,num/l);
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

    // Prime factorization
    public static long findLargestPrimeFactorImproved(long num){
        long divisor = 2;
        long newNumber = num;
        long largestCandidate = 2;
        while(divisor * divisor <= newNumber){
            if(newNumber % divisor == 0){
                newNumber /= divisor;
                largestCandidate = divisor;
            }else{
                divisor++;
            }
        }
        return Math.max(largestCandidate, newNumber);
    }

    public static void main(String[] args) {
        System.out.println(findLargestPrimeFactor(600851475143L));
        System.out.println(findLargestPrimeFactorImproved(600851475143L));
    }
}
