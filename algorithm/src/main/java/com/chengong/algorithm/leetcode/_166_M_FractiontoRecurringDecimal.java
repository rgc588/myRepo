package com.chengong.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cheng on 5/4/2017.
 */
public class _166_M_FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        long n = numerator;
        long d = denominator;
        if (n == 0) return "0";
        int sign = 1;
        if (n < 0) {
            n = -n;
            sign = -sign;
        }
        if (d < 0) {
            d = -d;
            sign = -sign;
        }
        long before = n/d;
        StringBuilder after = new StringBuilder();
        n = n%d;
        Map<Long, Integer> map = new HashMap<>();
        int index = 0;
        map.put(n, index++);
        while(n != 0) {
            after.append(Long.toString(Math.floorDiv(n*10,d)));
            n = (n*10)%d;
            if (map.containsKey(n)) {
                after.insert(map.get(n), "(");
                after.append(')');
                break;
            }
            map.put(n,index++);
        }
        return (sign == -1 ? "-":"") + Long.toString(before) + ((after.length()==0) ? "":".") + after.toString();
    }

    public static void main(String[] args) {
        int n = 1;
        int d = 6;
        _166_M_FractiontoRecurringDecimal sol = new _166_M_FractiontoRecurringDecimal();
        System.out.print(sol.fractionToDecimal(n, d));
    }
}
