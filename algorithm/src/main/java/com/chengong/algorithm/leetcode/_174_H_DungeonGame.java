package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 5/6/2017.
 */
public class _174_H_DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[] mem = new int[n];
        mem[n-1] = Math.min(dungeon[m-1][n-1],0);
        for (int i = n-2; i>=0; i--) {
            mem[i] = Math.min(dungeon[m-1][i]+mem[i+1],0);
        }
        for (int i = m-2; i >= 0; i--) {
            mem[n-1] = Math.min(dungeon[i][n-1]+mem[n-1],0);
            for (int j = n-2; j >= 0; j--) {
                mem[j] = Math.min(Math.max(mem[j+1], mem[j])+dungeon[i][j],0);
            }
        }
        return 1-mem[0];
    }
}
