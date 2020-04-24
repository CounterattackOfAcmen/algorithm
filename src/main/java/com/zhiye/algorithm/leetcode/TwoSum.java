package com.zhiye.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[] {2,7,15,7, 8};
        int target = 14;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>((int) ((float) nums.length / 0.75F + 1.0F));
        for(int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (hash.containsKey(another)) {
                return new int[]{hash.get(another), i};
            }
            hash.put(nums[i], i);
        }
        return null;
    }
}
