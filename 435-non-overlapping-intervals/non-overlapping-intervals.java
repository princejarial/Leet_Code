import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0; 
        int prevEnd = Integer.MIN_VALUE;

        
        for (int[] interval : intervals) {
            if (interval[0] >= prevEnd) {
                count++; // take interval
                prevEnd = interval[1];
            }
        }

        
        return intervals.length - count;
    }
}