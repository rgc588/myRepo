package com.chengong.algorithm;

/**
 * Created by chengong on 3/6/14.
 */
public class Sorting {

    public static int[] quickSort(int[] input){
        if(input == null) return null;
        sorting(input, 0, input.length - 1);
        return input;
    }

    private static void sorting(int[] array, int start, int end){
        if(start < end){
            int pivot = start + (end - start)/2;
            pivot = partition(array, start, end, pivot);
            sorting(array, start, pivot - 1);
            sorting(array, pivot + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end, int pivot){
        int pivotValue = array[pivot];
        int pivotPoint = start;
        swap(array, pivot, end);
        for(int i = start; i <= end; i++){
            if(array[i] <= pivotValue){
                swap(array, i, pivotPoint);
                pivotPoint ++;
            }
        }
        swap(array, pivotPoint, end);
        return pivotPoint;
    }

    private static void swap(int[] array, int indexA, int indexB) {
        if(indexA != indexB){
            array[indexA] = array[indexA]^array[indexB];
            array[indexB] = array[indexA]^array[indexB];
            array[indexA] = array[indexA]^array[indexB];
        }
    }
}
