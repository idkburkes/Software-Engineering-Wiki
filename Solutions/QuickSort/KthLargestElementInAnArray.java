

public class KthLargestElementInAnArray {


    public static void main(String[] args) {
        int[] input = {3,2,1,5,6,4};
        int k = 2;
        System.out.print(findKthLargest(input, k));
    }

  //Using Quicksort implementation
    public static int findKthLargest(int[] nums, int k) {
        //Use normal partition process then use length - k to find largest  
        return QuickSelect(nums, 0, nums.length - 1, nums.length - k);
    }


    /**
     * Method to swap two integers in an array
     * @param nums
     * @param a
     * @param b
     */
    public static void swap(int[] nums,int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static int QuickSelect(int[] nums, int start, int end, int k) {
        if(nums.length == 0 || start > end) {
            return -1;
        }

        //Use last index for pivot
        //Note (Can use random index or median-of-three for faster average time)
        int pivotIndex = end;
    
        //Place partition value at end of array
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, end);
        int left = start;
        for(int i = start; i < end; i++) {
            //All values less than pivot go to left
            if(nums[i] <= pivot) {
                swap(nums, left++, i);  
            }
        }
        //Swap pivot into correct position
        swap(nums, left, end);

        //Found correct value or use recursion on either side 
        if(left == k) {
            return nums[left];
        } else if(left < k) { //Partition is too big, search right side
            return QuickSelect(nums, left + 1, end, k); 
        } else { //Partition value is too small, search left side
            return QuickSelect(nums, start, left - 1, k);

        }
    }




}