package com.zhiye.algorithm.sorting.noncomparison;

import com.zhiye.algorithm.sorting.ISort;

import java.util.*;

public class BucketSort implements ISort {
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

        int bucketsCount = (max - min) / 5 + 1;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(bucketsCount);
        for (int i = 0; i < bucketsCount; i++) {
            buckets.add(new ArrayList<>(5));
        }
        for (int item : array) {
            int bucketNum = (item - min) / 5;
            ArrayList<Integer>  bucket = buckets.get(bucketNum);
            int pre = -1;
            for (int i = 0; i < bucket.size(); i++) {
                if (item < bucket.get(i)) {
                    pre = i;
                    break;
                }
            }
            if (pre < 0) {
                bucket.add(item);
            }  else {
                bucket.add(pre, item);
            }
        }
        int index = 0;
        for (int i = 0; i < bucketsCount; i++) {
            for (Integer item : buckets.get(i)) {
                array[index++] = item;
            }
        }
        return array;
    }

}
