package Solutions.Arrays;

/**
 * 
 * 
 * 
 * Pattern here is to keep track of a max and a min since if we
 * have a negative value as current min and we encounter another negative number
 * then the product of those two numbers will be the new max 
 * 
 */
public class MaximumProductSubarray {
    
    public static void main(String[] args) {

        
        // 2, 3, 4, -2, 3,   4,   -2,   0,   90  9
        // 2  6  24  24 24   24   96   96    
        // 2  2  2  -48 -48  -48  -48  -48
        int[] arr = new int[]{2,3,4,-2,3,4,-2,0,90,9};

        System.out.print(maxProduct(arr));

    }

    
    public static int maxProduct(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0], min = A[0], result = A[0];
        for (int i = 1; i < A.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }



}
