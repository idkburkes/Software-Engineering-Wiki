
package Solutions.Intervals;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {


    public int[][] merge(int[][] intervals) {
        //Sort intervals by start
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        List<List<Integer>> merged = new ArrayList<>();
        
        int i = 0;
        int[] interval = new int[2];
        int[] next = new int[2];
        interval[0] = intervals[0][0];
        interval[1] = intervals[0][1];
     
        while(i < intervals.length - 1) {
             next[0] = intervals[++i][0];
             next[1] = intervals[i][1];
            if(next[0] <= interval[1] ) {
                //If intervals overlap, merge them
              interval[1] = Math.max(interval[1], next[1]);   
            } else {
                //If intervals don't overlap, add current interval and start checking next interval
                merged.add(Arrays.asList(new Integer[]{interval[0], interval[1]}));
                interval[0] = next[0];
                interval[1] = next[1];
            } 
        } //Add the last inerval
         merged.add(Arrays.asList(new Integer[]{interval[0], interval[1]}));
        
        //Convert 2D list to 2D array
        int[][] result = new int[merged.size()][];
        for(int j = 0; j < merged.size(); j++) {
            int[] mergedInterval = new int[2];
            mergedInterval[0] = merged.get(j).get(0);
            mergedInterval[1] = merged.get(j).get(1);
            result[j] = mergedInterval;
        }
        
        
      return result;       
    }



}