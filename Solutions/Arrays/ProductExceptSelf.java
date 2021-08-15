package Solutions.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the
 * product of all the elements of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division
 * operation.
 * 
 * Used an interesting version of Dynamic Programming that was in place.
 */
public class ProductExceptSelf {
    

    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length < 2) {
            return new int[0];
        }

        int[] solution = new int[nums.length];
        //Calculate product of all numbers on left
        solution[0] = 1; //First index has no numbers on left so product is 1
        for(int i = 1; i < nums.length; i++){
            solution[i] = nums[i - 1] * solution[i - 1];
        }

        int tmp = 1; //Last index has no numbers on right so product is 1
        for(int i = nums.length - 1; i > 0; i--) {
            solution[i] = solution[i] * tmp; //Index i is product of all numbers on left and all numbers on right
            tmp *= solution[i]; //Store new product of all numbers on right 
        }
        solution[0] = tmp; //First index is product of all numbers on right
        return solution;
    }



}
