package com.zhiye.algorithm.sorting;

import com.zhiye.algorithm.sorting.comparison.insertion.ShellSort;

import java.util.Arrays;

public class SortTest {

    public static void main(String[] args) {
        Sorter sorter = Sorter.getInstance();
        int[] arr = new int[(int) (Math.random() * 9) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        //arr = new int[] {13, 19, 25, 37, 40, 46, 47, 47};
        System.out.println(Arrays.toString(arr));
        arr = sorter.sort(ShellSort.class, arr);
        System.out.println(Arrays.toString(arr));

       /*QuickSort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));*/
    }
}
