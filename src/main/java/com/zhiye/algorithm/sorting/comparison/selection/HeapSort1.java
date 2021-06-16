package com.zhiye.algorithm.sorting.comparison.selection;

import java.util.Arrays;

public class HeapSort1 {

    public static void main(String[] args) {
        int[] test = new int[]{3, 8, 5, 7, 2, 4, 6, 1, 1, 1, 2, 3, 6, 2, 8, 9, 8};
        System.out.println(Arrays.toString(test));
        HeapSort1 heapSort1 = new HeapSort1();
        heapSort1.heapSort(test);
        System.out.println(Arrays.toString(test));
    }

    public void heapSort(int[] arr) {

        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapAdjust(arr, i, len);
        }
        for (int i = len - 1; i > 0; i--) {
            // 交换最后一个节点和顶点
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            // 从订单重复调整堆
            heapAdjust(arr, 0, i);
        }
    }


    /**
     * 调整堆
     *
     * @param arr 堆
     * @param i   节点索引
     * @param len 堆节点数量
     */
    public void heapAdjust(int[] arr, int i, int len) {
        if (i >= len) {
            return;
        }
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if (left < len && arr[left] > arr[max]) {
            max = left;
        }
        if (right < len && arr[right] > arr[max]) {
            max = right;
        }
        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            // max节点值有变更，可能对子节点进行调整
            heapAdjust(arr, max, len);
        }
    }
}
