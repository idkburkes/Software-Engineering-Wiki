package Solutions.Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers
 * such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may not use
 * the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * 
 */
public class TwoSum {
    
    public int[] twoSum(int[] nums, int target) {
       
     Map<Integer, Integer> map = new HashMap<>();   
     for(int i = 0; i < nums.length; i++) {
         //If the complement already exists in the map then return
         //Index of current value and index of complement.
         int complement = target - nums[i]; 
            if(map.containsKey(complement)) { 
                return new int[] { map.get(complement), i};
            } else {
                //Store this value in map
                 map.put(nums[i], i); }
            }
     return null;   
    }


}
