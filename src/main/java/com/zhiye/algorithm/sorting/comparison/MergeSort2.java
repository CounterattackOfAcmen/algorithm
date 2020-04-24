package com.zhiye.algorithm.sorting.comparison;

import com.zhiye.algorithm.sorting.ISort;

public class MergeSort2 implements ISort {

    @Override
    public int[] sort(int[] array, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            array = sort(array, start, middle);
            array = sort(array, middle + 1, end);
            merge(array, start, middle, end);
        }
        return array;
    }

    protected void merge(int[] array, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];
        int leftPre = left;
        int rightPre = middle + 1;
        int index = 0;
        while (leftPre <= middle && rightPre <= right) {
            if (array[leftPre] > array[rightPre]) {
                temp[index++] = array[rightPre++];
            } else {
                temp[index++] = array[leftPre++];
            }
        }
        while (leftPre <= middle) {
            temp[index++] = array[leftPre++];
        }
        while (rightPre <= right) {
            temp[index++] = array[rightPre++];
        }
        if (index >= 0) {
            System.arraycopy(temp, 0, array, left, index);
        }
    }
}
