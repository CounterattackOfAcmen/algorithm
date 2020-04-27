package com.zhiye.algorithm.sorting.noncomparison;

import com.sun.jmx.remote.internal.ArrayQueue;
import com.zhiye.algorithm.sorting.ISort;

import java.util.ArrayList;

public class RadixSort implements ISort {
    @Override
    public int[] sort(int[] array, int start, int end) {
        if (start >= end) {
            return array;
        }

        int max = array[0];
        for (int item : array) {
            if (item > max) {
                max = item;
            }
        }
        int maxDigit = 1;
        while (max / 10 > 0) {
            maxDigit++;
            max /= 10;
        }

        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }

        int modRadix = 10;
        int digitRatio = 1;
        for (int i = 0; i < maxDigit; i++) {
            for (int item : array) {
                int bucketNum = (item % modRadix) / digitRatio;
                buckets.get(bucketNum).add(item);
            }
            int index = 0;
            for (ArrayList<Integer> bucket : buckets) {
                for (Integer value : bucket) {
                    array[index++] = value;
                }
                bucket.clear();
            }
            modRadix *= 10;
            digitRatio *= 10;
        }
        return array;
    }
}
