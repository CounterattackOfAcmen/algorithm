package com.zhiye.algorithm.leetcode;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = ListNode.arr(new int[]{6, 9, 9});
        ListNode l2 = ListNode.arr(new int[]{5, 5, 9});
        ListNode result = addTwoNumbers(l1, l2);
        System.out.println("[" + result.print() + "]");
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 预先指针指向下一个元素
        ListNode pre = new ListNode(0);
        // 当前元素
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 == null ? 0 : l1.val);
            int y = (l2 == null ? 0 : l2.val);
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

}

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