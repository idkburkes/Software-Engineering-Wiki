package Solutions.Arrays;



public class MaxSubarray {

    public static void main(String[] args) {
        int[] arr = new int[]{-2 , -5, -7, -1, -100};
        System.out.print(maxSubArray(arr));

        
    }


    public static int maxSubArray(int[] A) {
        int maxSoFar=A[0], maxEndingHere=A[0];
        for (int i=1;i<A.length;++i){
            maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);	
        }
        return maxSoFar;
    
}

}