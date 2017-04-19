package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 4/18/2017.
 */
public class _57_H_InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> rst = new ArrayList<>();
        int i = 0;
        while(i < intervals.size() && intervals.get(i).end < newInterval.start) {
            rst.add(intervals.get(i++));
        }
        int start = -1;
        int count = 0;
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            if (start == -1) start = i;
            count++;
            i++;
        }
        if (start != -1) newInterval.start = Math.min(newInterval.start, intervals.get(start).start);
        if (count != 0) {
            int end = start + count - 1;
            newInterval.end = Math.max(newInterval.end, intervals.get(end).end);
        }
        rst.add(newInterval);
        while(i < intervals.size()) {
            rst.add(intervals.get(i++));
        }
        return rst;
    }
}
