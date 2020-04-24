package com.zhiye.algorithm.sorting.comparison;

import com.zhiye.algorithm.sorting.ISort;

public class MergeSort3 extends MergeSort2 {
    @Override
    public int[] sort(int[] array, int start, int end) {
        int n = array.length;
        // 子数组的大小分别为1，2，4，8...
        // 刚开始合并的数组大小是1，接着是2，接着4....
        for (int i = 1; i < n; i += i) {
            //进行数组进行划分
            int left = 0;
            int mid = left + i - 1;
            int right = mid + i;
            //进行合并，对数组大小为 i 的数组进行两两合并
            while (right < n) {
                // 合并函数和递归式的合并函数一样
                merge(array, left, mid, right);
                left = right + 1;
                mid = left + i - 1;
                right = mid + i;
            }
            // 还有一些被遗漏的数组没合并，千万别忘了
            // 因为不可能每个字数组的大小都刚好为 i
            if (left < n && mid < n) {
                merge(array, left, mid, n - 1);
            }
        }
        return array;
    }
}
