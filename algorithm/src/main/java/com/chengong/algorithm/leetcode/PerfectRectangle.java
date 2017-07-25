package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 7/9/2017.
 */
public class PerfectRectangle {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0) return false;
        int[] rect = new int[4];
        rect[0] = rectangles[0][0];
        rect[1] = rectangles[0][1];
        for (int i = 0; i < rectangles.length; i++) {
            rect[0] = Math.min(rectangles[i][0], rect[0]);
            rect[1] = Math.min(rectangles[i][1], rect[1]);
            rect[2] = Math.max(rectangles[i][2], rect[2]);
            rect[3] = Math.max(rectangles[i][3], rect[3]);
        }
        int[][] mem = new int[rect[2]-rect[0]][rect[3]-rect[1]];
        int area = (rect[2]-rect[0])*(rect[3]-rect[1]);
        for (int i = 0; i < rectangles.length; i++) {
            for (int x = rectangles[i][0]-rect[0]; x < rectangles[i][2]-rect[0]; x++) {
                for (int y = rectangles[i][1]-rect[1]; y < rectangles[i][3]-rect[1]; y++) {
                    mem[x][y]++;
                    area--;
                    if (mem[x][y] > 1) return false;
                }
            }
        }
        return area == 0;
    }

    public static void main(String[] args) {
        int[][] input = {{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
        PerfectRectangle sol = new PerfectRectangle();
        System.out.print(sol.isRectangleCover(input));
    }
}
