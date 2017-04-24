package com.chengong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 4/21/2017.
 */
public class _93_M_RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> rst = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        helper(s, 0, cur, rst);
        return rst;
    }

    private void helper(String s, int index, List<String> cur, List<String> rst) {
        if (cur.size()==4 && index==s.length()) {
            StringBuilder sb = new StringBuilder();
            for (String each : cur) {
                sb.append(each);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length()-1);
            rst.add(sb.toString());
            return;
        }
        if (index>=s.length() || cur.size()>=4) return;
        int count = 0;
        if (s.charAt(index) == '0') {
            cur.add("0");
            helper(s, index+1, cur, rst);
            cur.remove(cur.size()-1);
            return;
        }
        while(index+count < s.length() && count < 3 && Integer.valueOf(s.substring(index,index+count+1)) < 256) {
            cur.add(s.substring(index,index+count+1));
            helper(s, index+count+1, cur, rst);
            cur.remove(cur.size()-1);
            count++;
        }
    }
}
