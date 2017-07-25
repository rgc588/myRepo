package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 4/17/2017.
 */
public class _38_E_CountandSay {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append('1');
        if (n == 1) return sb.toString();
        while(n>1){
            StringBuilder tmp = new StringBuilder();
            int count = 0;
            for (int i = 0; i < sb.length(); i++) {
                if (count == 0) {
                    count++;
                } else if (sb.charAt(i) == sb.charAt(i-1)) {
                    count++;
                } else {
                    tmp.append(String.valueOf(count));
                    tmp.append(sb.charAt(i-1));
                    count=1;
                }
            }
            if (count > 0) {
                tmp.append(String.valueOf(count));
                tmp.append(sb.charAt(sb.length()-1));
            }
            sb = tmp;
            n--;
        }
        return sb.toString();
    }

    public String countAndSay2(int n) {
        if (n <= 0) return "";
        String s = "1";
        while(n > 1) {
            int count = 1;
            int index = 0;
            String tmp = "";
            while(index < s.length()) {
                while(index+1<s.length() && s.charAt(index+1) == s.charAt(index)) {
                    count++;
                    index++;
                }
                tmp = tmp + count + s.charAt(index);
                index++;
                count = 1;
            }
            s = tmp;
            n--;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.print(new _38_E_CountandSay().countAndSay2(5));
    }
}
