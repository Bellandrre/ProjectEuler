/**
 *
 * Find sum of natural numbers less than 1000 where the numbers are divisible by 3 or 5.
 *
 * Naive Approach -
 * Check divisibility by both 3 or 5 and sum them up
 * Approach O(n)
 *
 * Better Approach -
 * Sum of natural numbers  - n(n+1)/2
 * Example - sum of 3, 6, 9, 12, 15, 18, 21 = 3 (1 + 2 + 3 + 4 .....) = 3 * (n(n+1)/2)
 * Inclusive Exclusive principle - |A| + |B| - ( A Intersection B )
 * Neglect common multiples - n(n+1)/2 + n(n+1)/2 - n(n+1)/2  = 1000/3(1000/3+1)/2 + 1000/5(1000/5+1)/2 - 1000/15(1000/15+1)/2
 * NOTE - For summation of a multiple - n is n/multiple, this can give erratic results, so n * (n/multiple) will give the required.
 * Approach O(1)
 */

import java.util.*;

public class MultipleOf3and5 {


    public static int findSum(int n, int N){
        return n * (N/n) *  ((N/n) + 1)/2 ;
    }

    public static void main(String[] args) {
        System.out.println( findSum(3,1000) + findSum(5,1000) - findSum(15,1000));
    }

}
