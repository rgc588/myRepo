package com.chengong.algorithm.leetcode;

/**
 * Created by chengong on 6/21/17.
 */
public class _188_H_BestTimetoBuyandSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (k > prices.length/2) {
            int sum = 0;
            for (int i = 1; i < prices.length; i++) {
                sum += Math.max(0, prices[i]-prices[i-1]);
            }
            return sum;
        }
        int[] g = new int[prices.length];
        int[] l = new int[prices.length];
        for (int i = 1; i <= k; i++) {
            int[] newg = new int[g.length];
            for (int j = 1; j < prices.length; j++) {
                l[j] = Math.max(l[j-1], g[j-1]) + prices[j] - prices[j-1];
                newg[j] = Math.max(newg[j-1], l[j]);
            }
            g = newg;
        }
        return g[prices.length-1];
    }

    public static void main(String[] args) {
        int k = 1;
        int[] prices = new int[] {1,2};
        _188_H_BestTimetoBuyandSellStockIV sol = new _188_H_BestTimetoBuyandSellStockIV();
        System.out.print(sol.maxProfit(k, prices));
    }
}
