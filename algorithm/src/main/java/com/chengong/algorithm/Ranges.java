package com.chengong.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengong on 10/4/15.
 */
class Ranges
{
    List<Range> ranges = new ArrayList<>();

    public void AddRange(int lower, int upper)
    {
        Range newRange = new Range(lower, upper);
        if(ranges.isEmpty()) {
            ranges.add(newRange);
        } else {
            int i = 0;
            while(i < ranges.size()) {
                Range r = ranges.get(i);

                //skip lower ranges without overlap
                if(r.upper < newRange.lower) {
                    i++;
                    continue;
                }

                //find start point
                if(r.upper >= newRange.lower) {
                    if(r.lower >= newRange.lower) {
                        newRange.upper = newRange.upper > r.upper ? newRange.upper : r.upper;
                        ranges.remove(i);
                    } else {
                        newRange.lower = r.lower;
                    }
                }

                //remove fully overlap ranges
                while(i < ranges.size()) {
                    if(r.lower >= newRange.lower && r.upper <= newRange.upper){
                        ranges.remove(i);
                    }
                    i++;
                }
                break;
            }

            if(i == ranges.size()) {//last range removed
                ranges.add(newRange);
            } else {
                Range end = ranges.get(i);
                if(end.lower <= newRange.upper) {
                    newRange.upper = end.upper;
                }
                ranges.add(i, newRange);
            }

        }
    }

    public boolean QueryRange(int lower, int upper)
    {
        for(int i = 0; i < ranges.size(); i++) {
            Range r = ranges.get(i);
            if(r.lower <= lower && r.upper <= upper) return true;
            if(r.lower > upper) break;
        }
        return false;
    }

    public void DeleteRange(int lower, int upper)
    {
        for(int i = 0; i < ranges.size(); i++) {
            Range r = ranges.get(i);
            if(r.upper < lower || r.lower > upper) continue;//skip no overlap ranges
            if(r.upper <= upper && r.lower >= lower) {
                ranges.remove(i);//remove fully overlap ranges
            }
            if(lower >= r.lower && lower <= r.upper) {
                ranges.remove(i);
                if(lower > r.lower) {
                    ranges.add(i, new Range(r.lower, lower - 1));
                }
            }

            if(upper >= r.lower && upper <= r.upper) {
                ranges.remove(i);
                if(upper < r.upper) {
                    ranges.add(i, new Range(upper + 1, r.upper));
                }
            }
        }
    }

    class Range {
        int lower;
        int upper;
        Range(int lower, int upper){
            this.lower = lower;
            this.upper = upper;
        }
    }

    public static void main(String[] args) {
        Ranges r = new Ranges();

        r.AddRange(10, 50);
        r.AddRange(100, 200);
        r.AddRange(250, 500);
    }

}
