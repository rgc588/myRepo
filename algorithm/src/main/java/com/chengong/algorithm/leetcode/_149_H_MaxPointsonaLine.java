package com.chengong.algorithm.leetcode;

import com.chengong.algorithm.leetcode.BaseClasses.Point;

import java.util.HashMap;
import java.util.Map;


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

    public int maxPoints2(Point[] points) {
        if(points == null || points.length == 0) return 0;
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            Point p = points[i];
            Map<String, Integer> map = new HashMap<>();
            int count = 0;
            int self = 1;
            for (int j = i+1; j < points.length; j++) {
                Point q = points[j];
                int x = p.x-q.x;
                int y = p.y-q.y;
                String key = "";
                if (x == 0 && y == 0) {
                    self++;
                    continue;
                } else if (x == 0) {
                    key = "0";
                } else {
                    int gcd = getGCD(x, y);
                    key = String.valueOf(x/gcd)+"/"+String.valueOf(y/gcd);
                }
                map.put(key, map.getOrDefault(key, 0)+1);
                count = Math.max(count, map.get(key));
            }
            max = Math.max(max, count+self);
        }
        return max;
    }

    private int getGCD(int x, int y) {
        if (y == 0) return x;
        return getGCD(y, x%y);
    }

    public static void main(String[] args) {
        Point[] input = new Point[] {new Point(-4,-4), new Point(-8,-582), new Point(-3,-3), new Point(-9, -651), new Point(9, 591)};
        _149_H_MaxPointsonaLine sol = new _149_H_MaxPointsonaLine();
        System.out.println(sol.maxPoints(input));
    }
}
