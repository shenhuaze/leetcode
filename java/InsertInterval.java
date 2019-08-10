package com.huaze.shen;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Huaze Shen
 * @date 2019-08-07
 */
public class InsertInterval {
    /**
     * T(n) = O(n), S(n) = O(n)
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0) {
            return new int[][]{newInterval};
        }
        if (newInterval == null || newInterval.length == 0) {
            return intervals;
        }
        List<int[]> resultList = new ArrayList<>();
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int index = 0;
        int size = intervals.length;
        while (index < size && intervals[index][0] < newStart) {
            resultList.add(intervals[index]);
            index += 1;
        }
        if (resultList.isEmpty() || resultList.get(resultList.size() - 1)[1] < newStart) {
            resultList.add(newInterval);
        } else {
            int lastIndex = resultList.size() - 1;
            int lastEnd = resultList.get(lastIndex)[1];
            resultList.get(lastIndex)[1] = Math.max(lastEnd, newEnd);
        }
        while (index < size) {
            int[] interval = intervals[index];
            int lastIndex = resultList.size() - 1;
            int lastEnd = resultList.get(lastIndex)[1];
            if (lastEnd < interval[0]) {
                resultList.add(interval);
            } else {
                resultList.get(lastIndex)[1] = Math.max(lastEnd, interval[1]);
            }
            index += 1;
        }
        return resultList.toArray(new int[resultList.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        //int[][] intervals = {{1, 5}};
        //int[] newInterval = {0, 3};
        //int[][] intervals = {{1, 5}};
        //int[] newInterval = {2, 3};
        //int[][] intervals = {{1, 5}};
        //int[] newInterval = {6, 8};
        //int[][] intervals = {{1, 5}};
        //int[] newInterval = {0, 6};
        int[][] results = new InsertInterval().insert(intervals, newInterval);
        for (int[] interval : results) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}
