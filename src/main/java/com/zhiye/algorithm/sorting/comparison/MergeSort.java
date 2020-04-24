package com.zhiye.algorithm.sorting.comparison;

import com.zhiye.algorithm.sorting.ISort;

import java.util.Arrays;

public class MergeSort implements ISort {
    @Override
    public int[] sort(int[] array, int start, int end) {
        if (start >= end) {
            return array;
        }
        int middle = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle, array.length);
        return merge(sort(left, 0, array.length - 1), sort(right, 0, array.length - 1));
    }

    private int[] merge(int[] left, int[] right) {
        int[] temp = new int[left.length + right.length];
        int leftPre = 0, rightPre = 0;
        for (int index = 0; index < temp.length; index++) {
            if (leftPre >= left.length) {
                temp[index] = right[rightPre++];
            } else if (rightPre >= right.length) {
                temp[index] = left[leftPre++];
            } else if (left[leftPre] > right[rightPre]) {
                temp[index] = right[rightPre++];
            } else {
                temp[index] = left[leftPre++];
            }
        }
        return temp;
    }
}
