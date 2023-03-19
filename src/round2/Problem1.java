package round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem1 {
    public static void main(String[] args) {
        int[][][] arr ={{{2,4},{1,3},{5,7},{6,8}},{{1,3},{3,6},{7,10},{8,12}},{{1,4},{2,3},{5,7},{6,8}},{{2,4},{1,5},
                {6,8},{7,9}},{{1,4},{4,5},{7,10},{10,12}}};
//        System.out.println(overlap(arr));
        for(int[][] que: arr) {
            for (int[] ans: overlap(que)) {
                System.out.print(Arrays.toString(ans) + ", ");
            }
            System.out.println();
        }
    }

    static List<int[]> overlap(int[][] intervals) {
//        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        List<int[]> ans = new ArrayList<>();
        int i;
        for (i = 0; i < intervals.length-1; i++) {
            int[] interval = intervals[i];
            int start = interval[0];
            int end = interval[1];
            if (i != interval.length-1 && end >= intervals[i+1][0]) {
                ans.add(new int[]{Math.min(start, intervals[i+1][0]),
                        Math.max(intervals[i+1][1], end)});
                i++;
            }
            else {
                ans.add(new int[]{start, end});
            }
        }
        if (i == intervals.length-1) {
            ans.add(intervals[i]);
        }
        return ans;
    }
}
