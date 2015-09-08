package com.chengong.algorithm;

/**
 * Created by chengong on 9/7/15.
 */
public class FactorialTrailingZeroes extends Base{

    public int trailingZeroes(int n) {
        if(n < 0) return -1;

        int count = 0;

        /**
         * use long here to avoid overflow
         */
        for(long i = 5; n >= i; i *= 5) {
            count += n/i;
        }

        return count;
    }

    public static void main(String[] args) {
        logger.info(new FactorialTrailingZeroes().trailingZeroes(2147483647));
    }

}
