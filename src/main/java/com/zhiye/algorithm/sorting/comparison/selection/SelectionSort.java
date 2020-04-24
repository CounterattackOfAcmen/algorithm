package com.zhiye.algorithm.sorting.comparison.selection;

import com.zhiye.algorithm.sorting.ISort;

public class SelectionSort implements ISort {
    @Override
    public int[] sort(int[] array, int start, int end) {
        if (start >= end) {
            return array;
        }
        for (int i = 0; i < end; i++) {
            int min = i;
            int swap;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min > i) {
                swap = array[min];
                array[min] = array[i];
                array[i] = swap;
            }
        }
        return array;
    }
}
