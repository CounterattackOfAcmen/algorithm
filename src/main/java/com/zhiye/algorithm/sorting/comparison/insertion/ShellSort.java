package com.zhiye.algorithm.sorting.comparison.insertion;

import com.zhiye.algorithm.sorting.ISort;

public class ShellSort implements ISort {
    @Override
    public int[] sort(int[] array, int start, int end) {
        if (start >= end) {
            return array;
        }
        int gap = array.length / 2;
        int current;
        while (gap > 0) {
            for (int i = gap; i < array.length; i++) {
                current = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > current) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = current;
            }
            gap /= 2;
        }
        return array;
    }
}
