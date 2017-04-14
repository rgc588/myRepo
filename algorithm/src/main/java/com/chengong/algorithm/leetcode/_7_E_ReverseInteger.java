package com.chengong.algorithm.leetcode;

/**
 * Created by cheng on 2/16/2017.
 */
/** other solution 1
 public int reverse(int x)
 {
 int result = 0;

 while (x != 0)
 {
 int tail = x % 10;
 int newResult = result * 10 + tail;
 if ((newResult - tail) / 10 != result)
 { return 0; }
 result = newResult;
 x = x / 10;
 }

 return result;
 }
 */

/** other solution 2
 public int reverse(int x) {
 long rev= 0;
 while( x != 0){
 rev= rev*10 + x % 10;
 x= x/10;
 if( rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
 return 0;
 }
 return (int) rev;
 }
 */
public class _7_E_ReverseInteger {
    public int reverse(int x) {
        int rst = 0;
        while (x!=0) {
            int digit = x%10;
            if (digit > 0) {
                if (rst > (Integer.MAX_VALUE - digit)/10) return 0;
            } else {
                if (rst < (Integer.MIN_VALUE - digit)/10) return 0;
            }
            rst = rst*10 + digit;
            x/=10;
        }
        return rst;
    }
}
