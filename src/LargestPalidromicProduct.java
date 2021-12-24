public class LargestPalidromicProduct {

    /* Converting number to a string and then checking if the number isPal is no brainer.  Check this out B) -*/

    public static boolean isPalidrome(long inputNumber){
        long temp = inputNumber;
        long reversedNum = 0;
        // 114411
        while(temp > 0){
            reversedNum *= 10;
            int lastDigit = (int)(temp % 10); // 1144  1
            temp /= 10; // 1144
            reversedNum += lastDigit;

        }
        return reversedNum == inputNumber;
    }


    public static long nearestThreeDigitPalindrome(){
        long largestProduct = Long.MIN_VALUE;
        for(int i =999 ; i > 1; i--){
            for(int j = 999 ; j > 1; j--){
                long product = i*j;
                if(isPalidrome(product)) {
                    largestProduct = Math.max(largestProduct, product);
                }
            }
        }
        return largestProduct;
    }

    public static void main(String[] args) {
        System.out.println(nearestThreeDigitPalindrome());
    }

}
