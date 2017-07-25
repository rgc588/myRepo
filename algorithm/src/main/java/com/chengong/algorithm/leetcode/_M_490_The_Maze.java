package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 6/22/2017.
 */
public class _M_490_The_Maze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) return false;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return helper(maze, start, destination, visited);
    }

    private boolean helper(int[][] maze, int[] start, int[] dest, boolean[][] visited) {
        if (visited[start[0]][start[1]]) return false;
        if (start[0] == dest[0] && start[1] == dest[1]) return true;
        visited[start[0]][start[1]] = true;
        int i = start[0];
        while(i-1 >= 0 && maze[i-1][start[1]] != 1) {
            i--;
        }
        if (helper(maze, new int[] {i, start[1]}, dest, visited)) return true;
        i = start[0];
        while(i+1 < maze.length && maze[i+1][start[1]] != 1) {
            i++;
        }
        if (helper(maze, new int[] {i, start[1]}, dest, visited)) return true;
        int j = start[1];
        while(j-1 >= 0 && maze[start[0]][j-1] != 1) {
            j--;
        }
        if (helper(maze, new int[] {start[0], j}, dest, visited)) return true;
        j = start[1];
        while(j+1 < maze[0].length && maze[start[0]][j+1] != 1) {
            j++;
        }
        if (helper(maze, new int[] {start[0], j}, dest, visited)) return true;
        return false;
    }

    public static void main(String[] args) {
        int[][] maze = new int[][] {{0,0,1,0,0},
                                    {0,0,0,0,0},
                                    {0,0,0,1,0},
                                    {1,1,0,1,1},
                                    {0,0,0,0,0}};
        _M_490_The_Maze sol = new _M_490_The_Maze();
        sol.hasPath(maze, new int[] {0,4}, new int[] {3,2});
    }
}
