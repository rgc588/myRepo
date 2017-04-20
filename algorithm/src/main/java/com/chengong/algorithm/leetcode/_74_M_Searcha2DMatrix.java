package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/19/2017.
 */
public class _74_M_Searcha2DMatrix {
    public boolean searchMatrix1(int[][] matrix, int target) {

        int row_num = matrix.length;
        int col_num = matrix[0].length;

        int begin = 0, end = row_num * col_num - 1;

        while(begin <= end){
            int mid = (begin + end) / 2;
            int mid_value = matrix[mid/col_num][mid%col_num];

            if( mid_value == target){
                return true;

            }else if(mid_value < target){
                //Should move a bit further, otherwise dead loop.
                begin = mid+1;
            }else{
                end = mid-1;
            }
        }

        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int rowStart = 0;
        int rowEnd = m-1;
        int row = -1;
        while(rowStart <= rowEnd) {
            int mid = rowStart + (rowEnd - rowStart)/2;
            if (matrix[mid][0] > target) {
                rowEnd = mid-1;
            } else if (matrix[mid][n-1] < target) {
                rowStart = mid+1;
            } else {
                row = mid;
                break;
            }
        }
        if (row == -1) return false;
        int start = 0;
        int end = n-1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if (matrix[row][mid] == target) return true;
            if (matrix[row][mid] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return false;
    }


}
