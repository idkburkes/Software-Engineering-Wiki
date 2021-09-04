package Solutions.Intervals;

import java.util.Arrays;


public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
       
        //Sort intervals by start
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0])); 
         int overlaps = 0;
         int i = 0;
         
        //Start with the lowest start number
         int[] interval = new int[]{ intervals[0][0], intervals[0][1]};
         while(i < intervals.length - 1) {
         int[] next = new int[]{intervals[++i][0], intervals[i][1]};
            //If overlap increment counter and set new interval to intersection
             if(next[0] < interval[1]){
                 overlaps++;
                 interval[0] = Math.max(interval[0], next[0]);
                 interval[1] = Math.min(interval[1], next[1]);
             } else {
                 //Evaluate next interval
                 interval[0] = next[0];
                 interval[1] = next[1];
             }  
         }
         
         
        return overlaps; 
     }


}