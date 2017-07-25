package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 7/16/2017.
 */
public class _644_H_MaximumAverageSubarrayII {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < k || k < 1) return 0;
        long sum = 0;
        long maxSum = 0;
        int index = 0;
        double max = 0;
        int[] rst = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                sum += nums[i];
                maxSum += nums[i];
                if (i == k-1) max = sum/(double)k;
            } else {
                sum += nums[i];
                sum -= nums[i-k];
                maxSum = maxSum + nums[i];
                if ((double)maxSum/(double)(i-index+1) <= (double)sum/(double)k) {
                    index = i-k+1;
                    maxSum = sum;
                }
                double tmp = maxSum/(double)(i-index+1);
                if(max < tmp) {
                    max = tmp;
                    rst[0] = index;
                    rst[1] = i;
                }
            }
        }
        System.out.println("Start: " + rst[0] + "; End: " + rst[1]);
        return max;
    }

    public double findMaxAverage2(int[] nums, int k) {
        double res = Integer.MIN_VALUE;
        int[] rst = new int[2];
        for (int s = 0; s < nums.length - k + 1; s++) {
            long sum = 0;
            for (int i = s; i < nums.length; i++) {
                sum += nums[i];
                if (i - s + 1 >= k) {
                    double tmp = sum/(double)(i - s + 1);
                    if (res < tmp) {
                        res = tmp;
                        rst[0] = s;
                        rst[1] = i;
                    }
                }
            }
        }
        System.out.println("Start: " + rst[0] + "; End: " + rst[1]);
        return res;
    }

    public double findMaxAverage3(int[] nums, int k) {
        if (nums == null || nums.length < k || k < 1) return 0;
        int[] sum = new int[nums.length];
        int[] index = new int[nums.length];
        sum[0] = nums[0];
        index[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i];
            index[i] = i;
            if ((sum[i-1] + nums[i])/(double)(i-index[i-1]+1) > sum[i]) {
                sum[i] += sum[i-1];
                index[i] = index[i-1];
            }
        }
        int ksum = 0;
        double max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                ksum += nums[i];
                if (i == k-1) max = ksum/(double)k;
            } else {
                ksum += nums[i];
                ksum -= nums[i-k];
                double tmp = ksum/(double)k;
                tmp = Math.max(tmp, (ksum+sum[i-k])/(double)(i-index[i-k]+1));
                max = Math.max(max, tmp);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input2 = new int[] {65,91,27,13,3,39,78,76,0,60,27,63,36,36,47,75,38,93,35,53,71,51,5,17,72,57,90,14,20,62,53,37,6,80,2,9,71,80,38,24,40,65,39,77,53,87,4,44,32,40,49,4,43,6,73,15,63,15,81,35,78,34,24,84,67,26,45,90,6,83,66,99,1,6,76,6,45,32,50,29,72,99,33,15,5,6,82,21,74,15,56,52,50,81,88,69,7,85,59,66};
        int[] input1 = new int[] {8,0,1,7,8,6,5,5,6,7};
        _644_H_MaximumAverageSubarrayII sol = new _644_H_MaximumAverageSubarrayII();
        System.out.println(sol.findMaxAverage3(input1, 5));
    }
}
