package com.chengong.algorithm.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by cheng on 6/14/2017.
 */
public class _317_H_ShortestDistancefromAllBuildings {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        int[][] mem = new int[m][n];
        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    total++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    Queue<String> q = new LinkedList<>();
                    Set<String> visited = new HashSet<>();
                    visited.add(i+","+j);
                    q.add(i+","+j);
                    int count = 0;
                    int level = 0;
                    while(!q.isEmpty()) {
                        int size = q.size();
                        while(size > 0) {
                            String key = q.remove();
                            int k = Integer.valueOf(key.split(",")[0]);
                            int l = Integer.valueOf(key.split(",")[1]);
                            if (count == 0 || grid[k][l] == 0) {
                                mem[k][l] += level;
                                //go arround
                                //up
                                String tmp = (k-1)+","+l;
                                if (k-1 >= 0 && !visited.contains(tmp)) {
                                    q.add(tmp);
                                    visited.add(tmp);
                                }
                                //down
                                tmp = (k+1)+","+l;
                                if (k+1 < m && !visited.contains(tmp)) {
                                    q.add(tmp);
                                    visited.add(tmp);
                                }
                                //right
                                tmp = k+","+(l+1);
                                if (l+1 < n && !visited.contains(tmp)) {
                                    q.add(tmp);
                                    visited.add(tmp);
                                }
                                //left
                                tmp = k+","+(l-1);
                                if (l-1 >= 0 && !visited.contains(tmp)) {
                                    q.add(tmp);
                                    visited.add(tmp);
                                }
                            }
                            if (grid[k][l] == 1) count++;
                            size--;
                        }
                        level++;
                    }
                    if (count < total) return -1;
                }
            }
        }
        int rst = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && mem[i][j] < rst) {
                    rst = mem[i][j];
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        _317_H_ShortestDistancefromAllBuildings sol = new _317_H_ShortestDistancefromAllBuildings();
        System.out.print(sol.shortestDistance(grid));
    }
}
