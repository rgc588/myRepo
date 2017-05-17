package com.chengong.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cheng on 5/14/2017.
 */
public class _220_M_ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0 || k <= 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                map.remove(((long)nums[i-k-1] - (long)Integer.MIN_VALUE)/((long)t+1));
            }
            long bucket = ((long)nums[i] - (long)Integer.MIN_VALUE)/((long)t+1);
            if (map.containsKey(bucket) ||
                    (map.containsKey(bucket-1) && (long)nums[i]-map.get(bucket-1)<=t) ||
                    (map.containsKey(bucket+1) && map.get(bucket+1)-(long)nums[i]<=t)) return true;
            map.put(bucket, (long)nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-1,Integer.MAX_VALUE};
        _220_M_ContainsDuplicateIII sol = new _220_M_ContainsDuplicateIII();
        System.out.print(sol.containsNearbyAlmostDuplicate(nums, 1, Integer.MAX_VALUE));
    }
}
