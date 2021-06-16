package com.zhiye.algorithm.leetcode;

class ListNode {

    int val;

    ListNode next;

    ListNode(int x) {
        this.val = x;
    }

    public static ListNode arr(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        for (int value : arr) {
            cur.next(new ListNode(value));
            cur = cur.next;
        }
        return pre.next;
    }

    public void next(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + (next == null ? null : next.toString()) +
                '}';
    }

    public String print() {
        return val + (next == null ? "" : ("," + next.print()));
    }
}
