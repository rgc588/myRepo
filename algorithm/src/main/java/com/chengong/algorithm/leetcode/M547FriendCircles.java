package com.chengong.algorithm.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by cheng on 4/3/2017.
 */
public class M547FriendCircles {
    public int findCircleNum(int[][] M) {
        Set<Integer> cache = new HashSet<>();
        int i = 0;
        int count = 0;
        while(i < M.length) {
            if (cache.contains(i)) {
                i++;
                continue;
            }
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            cache.add(i);
            while(!q.isEmpty()) {
                int v = q.poll();
                for (int j = 0; j < M[v].length; j++) {
                    if (cache.contains(j)) continue;
                    if(M[v][j] == 1) {
                        q.add(j);
                        cache.add(j);
                    }
                }
            }
            count++;
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] M = new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        M547FriendCircles sol = new M547FriendCircles();
        System.out.print(sol.findCircleNum(M));
    }
}
