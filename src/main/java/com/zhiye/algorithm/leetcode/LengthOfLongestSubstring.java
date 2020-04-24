package com.zhiye.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        int max = count;
        Set<Character> set = new HashSet<>((int) ((float) chars.length / 0.75F + 1.0F));
        for (char c : chars) {
            if (set.contains(c)) {
                if (count > max) {
                    max = count;
                }
                count = 0;
                set.clear();
            }
            count++;
            set.add(c);
        }
        if (count > max) {
            max = count;
        }
        return max;
    }
}
