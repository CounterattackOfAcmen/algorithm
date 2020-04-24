package com.zhiye.algorithm.sorting.comparison.swap;

import com.zhiye.algorithm.sorting.ISort;

public class BubbleSort implements ISort {
    @Override
    public int[] sort(int[] array, int start, int end) {
        if (start >= end) {
            return array;
        }
        int swap;
        while (end > 0) {
            for (int i = 0; i < end; i++) {
                if (array[i] > array[i + 1]) {
                    swap = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = swap;
                }
            }
            end--;
        }
        return array;
    }
}
