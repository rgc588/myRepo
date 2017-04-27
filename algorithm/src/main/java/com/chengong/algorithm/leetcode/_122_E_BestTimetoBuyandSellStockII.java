package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/26/2017.
 */
public class _122_E_BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int max = 0;
        int index = 0;
        while(index < prices.length) {
            int start = index;
            while(index+1 < prices.length && prices[index+1] >= prices[index]) {
                index++;
            }
            if (index > start) {
                max += prices[index] - prices[start];
            }
            index++;
        }
        return max;
    }
}
