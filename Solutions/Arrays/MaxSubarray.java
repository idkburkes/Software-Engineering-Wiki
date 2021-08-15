package Solutions.Arrays;
/**
 * 
 * 
 * 
 * Optimal solution below ----
 * 
 * public static int maxSubArray(int[] A) {
    int maxSoFar=A[0], maxEndingHere=A[0];
    for (int i=1;i<A.length;++i){
    	maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
    	maxSoFar=Math.max(maxSoFar, maxEndingHere);	
    }
    return maxSoFar;
}
 */
public class MaxSubarray {

    public static void main(String[] args) {
        int[] arr = new int[]{-2 , -5, -7, -1, -100};
        System.out.print(maxSubArray(arr));

        
    }


    public static int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
         if(nums.length == 1) return nums[0];
         
         int max = nums[0];
         int currentSum = max;
         for(int i = 1; i < nums.length; i++){
            if(max < 0) { //Find first positive number
                if(nums[i] > max) {
                    max = nums[i];
                    currentSum = max;
                    continue;
                }
            }
             //Negative number doesn't make current sum negative
             if(nums[i] + currentSum > 0) {
                 currentSum += nums[i];
                if(currentSum > max){ //new max
                 max = currentSum;
                }
             } else { //Found negative number bigger than current sum.
                 currentSum = 0;
             }
         }
         return max;
     }
    
}
