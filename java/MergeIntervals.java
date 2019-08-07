package com.huaze.shen;

import java.util.*;

/**
 * @author Huaze Shen
 * @date 2019-08-06
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> resultLists = new ArrayList<>();
        resultLists.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int size = resultLists.size();
            if (intervals[i][0] > resultLists.get(size - 1)[1]) {
                resultLists.add(intervals[i]);
            } else {
                resultLists.get(size - 1)[1] = Math.max(resultLists.get(size - 1)[1], intervals[i][1]);
            }
        }
        int[][] results = new int[resultLists.size()][2];
        for (int i = 0; i < resultLists.size(); i++) {
            results[i][0] = resultLists.get(i)[0];
            results[i][1] = resultLists.get(i)[1];
        }
        return results;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] results = new MergeIntervals().merge(intervals);
        for (int[] interval : results) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}
