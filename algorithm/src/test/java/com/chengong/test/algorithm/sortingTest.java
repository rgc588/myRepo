package com.chengong.test.algorithm;

import com.chengong.algorithm.Sorting;
import org.junit.Test;

import java.util.logging.Logger;

/**
 * Created by chengong on 3/6/14.
 */
public class sortingTest {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Test
    public void test(){
        int[] input = new int[] {1,4,5,9,7,8,3,10,2,0,6};

        Sorting.quickSort(input);

        StringBuilder builder = new StringBuilder();
        for(int each: input){
            builder.append(each);
            builder.append(',');
        }

        logger.info(builder.toString());
    }
}
