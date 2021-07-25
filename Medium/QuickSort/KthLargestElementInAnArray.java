

public class KthLargestElementInAnArray {

  //Using Quicksort implementation
    public int findKthLargest(int[] nums, int k) {
        
    }

    public static int partition(int[] nums, int k) {
        //Use mid-of-three method to choose first partition value
        int first = nums[0];
        int mid = nums[nums.length / 2];
        int last = nums[nums.length - 1];
        int median = 0;
        if(first <= mid && mid <= last) {
            median = mid;
        } else if(mid <= first && first <= last) {
            median = first;
        } else {
            median = last;
        }




    }




}