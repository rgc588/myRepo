package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by cheng on 4/18/2017.
 */
public class _56_M_MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> rst = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return rst;
        Collections.sort(intervals, (l, r)->l.start-r.start);
        rst.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval last = rst.get(rst.size()-1);
            Interval each = intervals.get(i);
            if (last.end < each.start) {
                rst.add(each);
            } else {
                last.end = Math.max(each.end, last.end);
            }
        }
        return rst;
    }
}
