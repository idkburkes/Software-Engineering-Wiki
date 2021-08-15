package Solutions.Arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 * 
 * Simple solution that makes use of O(1) find function in Set that stores only unique values
 * 
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length < 2){
            return true;
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            } else {
                return false;
            }
            
        }
        
        return true;
    }
}
