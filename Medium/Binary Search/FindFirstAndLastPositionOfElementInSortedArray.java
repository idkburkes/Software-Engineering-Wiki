class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
            int[] input = {5,7,7,8,8,10};
            int[] output = searchRange(input,8);
            System.out.print(output[0] + " ," + output[1]);
    }


    public static int[] searchRange(int[] nums, int target) {
        int[] range = new int[2];
        range[0] = findFirstIndex(nums, target);
        range[1] = findLastIndex(nums,target);
        return range;
        }
    
    //Binary search to find index of first occurence 
    public static int findFirstIndex(int[] nums, int target) {
        int index = -1;
        int end = nums.length - 1;
        int start = 0;
      
        while(start <= end) {
            //Find new middle value
              int mid = ( (end + start) / 2 );
        if(nums[mid] < target) {
            //Search right side
            start = mid + 1;
        } else {
            //Search left side
            end = mid - 1;
        }
            if(nums[mid] == target){
                index = mid;
            }
        }   
        return index;
    }
    
    //Binary search to find index of last occurence
    public static int findLastIndex(int[] nums, int target) {
        int index = -1;
        int end = nums.length - 1;
        int start = 0;
      
        while(start <= end) {
            //Find new middle value
              int mid = ( (end + start) / 2 );
        if(nums[mid] > target) {
            //Search left side
            end = mid - 1;
        } else {
            //Search right side
            start = mid + 1;
        }
            if(nums[mid] == target){
                index = mid;
            }
        }   
        return index;
    }
}
