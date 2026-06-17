package Hard;
// Merge overlapping subintervals.

import java.util.*;

public class _7 {
    public static int[][] merge(int[][] intervals) {
        int n=intervals.length;
        List<int []> merge= new ArrayList<>();

        int start=intervals[0][0];
        int end=intervals[0][1];

        for(int i=1; i<n; i++){
            // Overlap exists
            if(intervals[i][0]<=end){
                end=Math.max(end, intervals[i][1]);
            }
            // No overlapping
            else {
                merge.add(new int[]{start, end});

                // update start and end
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        // Add the last interval
        merge.add(new int[]{start, end});

        return merge.toArray(new int[merge.size()][]);
    }

    static void main(String[] args) {
        int[][] result= merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        System.out.println(Arrays.deepToString(result));
    }
}
