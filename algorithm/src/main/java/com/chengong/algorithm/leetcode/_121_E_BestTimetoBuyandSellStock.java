package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/26/2017.
 */
public class _121_E_BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int max = 0;
        if (prices.length == 0) return max;
        int min = prices[0];
        for (int i = 1; i<prices.length; i++) {
            max = max > prices[i]-min ? max : prices[i]-min;
            min = min < prices[i] ? min : prices[i];
        }
        return max;
    }
}
