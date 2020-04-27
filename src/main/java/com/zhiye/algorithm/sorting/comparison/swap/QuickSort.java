package com.zhiye.algorithm.sorting.comparison.swap;

import com.zhiye.algorithm.sorting.ISort;

/**
 * 快速排序<br>
 * 前后指针法
 */
public class QuickSort implements ISort {

    @Override
    public int[] sort(int[] array, int start, int end) {
        if (start >= end) {
            return array;
        }
        int pivot = array[start];
        int i = start;
        int j = end;
        int temp;
        while (i < j) {
            while ((i < j) && (array[j] >= pivot)) {
                j--;
            }
            while ((i < j) && (array[i] <= pivot)) {
                i++;
            }
            if (i < j) {
                temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        if (start < j) {
            array[start] = array[j];
            array[j] = pivot;
        }
        /*array[start] = array[j];
        array[j] = pivot;*/

        sort(array, start, j - 1);
        sort(array, j + 1, end);
        return array;
    }

}
