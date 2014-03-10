package com.chengong.test.algorithm;

import com.chengong.algorithm.PalindromeNumber;
import org.junit.Test;

/**
 * Created by chengong on 3/7/14.
 */
public class PalindromeNumberTest {

    @Test
    public void test(){
        assert !PalindromeNumber.isPalindrome(123456);
        assert PalindromeNumber.isPalindrome(12321);
    }
}
