package com.chengong.algorithm;

import java.util.Arrays;

/**
 * Created by cheng on 6/26/2017.
 */
public class Test {
    public static void main(String[] args) {
        int[] input = new int[] {1,3,4,7,10};
        int index = Arrays.binarySearch(input, 2,2,11);
        System.out.print(index);
    }
}
