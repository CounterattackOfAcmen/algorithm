package com.zhiye.algorithm.sorting.noncomparison;

import com.zhiye.algorithm.sorting.ISort;

public class CountingSort implements ISort {

    @Override
    public int[] sort(int[] array, int start, int end) {
        if (start >= end) {
            return array;
        }
        int min = array[0];
        int max = array[0];
        for (int item : array) {
            if (item > max) {
                max = item;
            }
            if (item < min) {
                min = item;
            }
        }

        int[] temp = new int[max - min + 1];
        for (int value : array) {
            temp[value - min]++;
        }
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            int count = temp[i];
            while (count-- > 0 ) {
                array[index++] = i + min;
            }
        }
        return array;
    }
}
