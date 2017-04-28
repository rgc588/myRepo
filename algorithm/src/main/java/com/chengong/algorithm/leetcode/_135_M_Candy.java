package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/27/2017.
 */
public class _135_M_Candy {
    public int candy(int[] ratings) {
        if (ratings == null) return 0;
        int m = ratings.length;
        if (m==0) return 0;
        int[] rst = new int[m];
        for (int i = 1; i < m; i++) {
            if (ratings[i] > ratings[i-1]) {
                rst[i] = rst[i-1]+1;
            }
        }
        for (int i = m-2; i >=0; i--) {
            if (ratings[i] > ratings[i+1]) {
                rst[i] = Math.max(rst[i],rst[i+1]+1);
            }
        }
        int sum = 0;
        for (int i = 0; i<m; i++) {
            sum+=rst[i];
        }
        return sum+m;
    }
}
