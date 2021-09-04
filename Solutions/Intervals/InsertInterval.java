package Solutions.Intervals;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        //If intervals array is empty return the new interval 
        if(intervals == null || intervals.length == 0) {
            int[][] result = new int[1][2];
            result[0][0] = newInterval[0];
            result[0][1] = newInterval[1];
            return result;
        }
        List<List<Integer>> merged = new ArrayList<>();
        List<Integer> interval = new ArrayList<>(2);

        //Add all intervals before new interval
        int i = 0;
        while(i < intervals.length && intervals[i][0] < newInterval[0] && newInterval[0] > intervals[i][1]) {
            interval = Arrays.asList(intervals[i][0], intervals[i][1]);
            merged.add(interval);
            i++;
        }
         
        //Merge new interval with overlapping intervals
        while(i < intervals.length 
              && (intervals[i][0] <= newInterval[1] && intervals[i][1] >= newInterval[0]))          {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                  i++;
        }
       merged.add(Arrays.asList(newInterval[0], newInterval[1]));
        
        //Add all intervals after the merge
        while(i < intervals.length) {
            merged.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            i++;
        }
        
        //Convert 2D List to 2D int array
        int[][] result = new int[merged.size()][];
        for(int j = 0; j < merged.size(); j++){
              int[] resultInterval = new int[2];
            resultInterval[0] = merged.get(j).get(0);
            resultInterval[1] = merged.get(j).get(1);
            result[j] = resultInterval;
           
        }
        
   return result;     
    }

}