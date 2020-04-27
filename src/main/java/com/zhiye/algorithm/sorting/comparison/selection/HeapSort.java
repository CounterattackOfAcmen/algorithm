package com.zhiye.algorithm.sorting.comparison.selection;

import com.zhiye.algorithm.sorting.ISort;

public class HeapSort implements ISort {
    @Override
    public int[] sort(int[] array, int start, int end) {
        if (start >= end) {
            return array;
        }
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
        int swap;
        for (int i = n - 1; i >= 0; i--) {
            swap = array[i];
            array[i] = array[0];
            array[0] = swap;
            heapify(array, i, 0);
        }
        return array;
    }

    /**
     * 堆化
     * @param array 树堆
     * @param n 节点总数
     * @param i 节点索引
     */
    private void heapify(int[] array, int n, int i) {
        if (i >= n) {
            return;
        }
        int cl = 2 * i + 1;
        int cr = 2 * i + 2;
        int max = i;
        int swap;
        if (cl < n && array[cl] > array[max]) {
            max = cl;
        }
        if (cr < n && array[cr] > array[max]) {
            max = cr;
        }
        if (max != i) {
            swap = array[i];
            array[i] = array[max];
            array[max] = swap;
            heapify(array, n, max);
        }
    }
}
