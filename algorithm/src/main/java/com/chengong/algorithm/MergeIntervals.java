package com.chengong.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by chengong on 10/5/15.
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalsComparator());

        List<Interval> rst = new ArrayList<>();

        Interval last = null;
        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (last != null && last.end >= cur.start) {
                last.end = last.end > cur.end ? last.end : cur.end;
            } else {
                rst.add(cur);
                last = cur;
            }
        }
        return rst;
    }

    class IntervalsComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval l, Interval r) {
            return l.start - r.start;
        }
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
