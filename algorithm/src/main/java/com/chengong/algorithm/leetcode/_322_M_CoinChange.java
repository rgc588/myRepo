package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 6/4/2017.
 */
public class _322_M_CoinChange {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] mem = new int[m][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                mem[i][j] = -1;
            }
        }
        int v = coins[0];
        int count = 1;
        while (v <= n) {
            mem[0][v] = count;
            count++;
            v += coins[0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <=n; j++) {
                if (mem[i-1][j] != -1) {
                    count = 0;
                    int sum = 0;
                    while(j + sum <= n) {
                        if (mem[i][j+sum] == -1){
                            mem[i][j+sum] = mem[i-1][j]+count;
                        } else {
                            mem[i][j+sum] = Math.min(mem[i][j+sum], mem[i-1][j]+count);
                        }
                        count++;
                        sum += coins[i];
                    }
                }
            }
        }
        return mem[m-1][n];
    }

    public static void main(String[] args) {
        int[] input = new int[] {1,3,7,9};
        int amount = 10;
        _322_M_CoinChange sol = new _322_M_CoinChange();
        System.out.print(sol.coinChange(input, amount));
    }
}
