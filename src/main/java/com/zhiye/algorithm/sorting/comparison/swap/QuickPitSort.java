package com.zhiye.algorithm.sorting.comparison.swap;

import com.zhiye.algorithm.sorting.ISort;

/**
 * 填坑法快速排序
 */
public class QuickPitSort implements ISort {
    @Override
    public int[] sort(int[] array, int start, int end) {
        if (start >= end) {
            return array;
        }
        int pivot = array[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i< j && array[j] >= pivot) {
                j--;
            }
            if (i < j) {
                array[i] = array[j];
                i++;
            }
            while (i < j && array[i] <= pivot) {
                i++;
            }
            if (i < j) {
                array[j] = array[i];
            }
        }
        array[j] = pivot;

        sort(array, 0, j - 1);
        sort(array, j + 1, end);
        return array;
    }

}
