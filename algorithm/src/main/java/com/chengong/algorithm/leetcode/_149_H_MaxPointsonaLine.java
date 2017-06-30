package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.Point;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cheng on 5/30/2017.
 */
public class _149_H_MaxPointsonaLine {
    public int maxPoints(Point[] points) {
        int rst = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> map = new HashMap<>();
            int max = 0;
            int dup = 0;
            for (int j = i+1; j < points.length; j++) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    dup++;
                    continue;
                }
                Double slop = Double.MAX_VALUE;
                if (points[j].x != points[i].x) slop = ((double)points[j].y-(double)points[i].y)/((double)points[j].x-(double)points[i].x)+0.0;
                if (!map.containsKey(slop)){
                    map.put(slop, 1);
                } else {
                    map.put(slop, map.get(slop)+1);
                }
                max = Math.max(max, map.get(slop));
            }
            rst = Math.max(rst, max+dup+1);
        }
        return rst;
    }

    public static void main(String[] args) {
        Point p1 = new Point(0,0);
        Point p2 = new Point(94911151,94911150);
        Point p3 = new Point(94911152,94911151);
        Point[] input = new Point[] {p1, p2, p3};
        _149_H_MaxPointsonaLine sol = new _149_H_MaxPointsonaLine();
        System.out.print(sol.maxPoints(input));
    }
}
