package leetcode.p_2130_maximum_twin_sum_of_a_linked_list;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        ListNode temp = this;
        String str = "";
        while (temp != null) {
            str = str + temp.val + " ";
            temp = temp.next;
        }
        return(str);
    }
}
class Solution {
    public static int pairSum(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        ListNode slowPtr, fastPtr;

        slowPtr = fastPtr = head;

        while (fastPtr != null) {
            stack.push(slowPtr.val);
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        int maxSum = Integer.MIN_VALUE;
        int currentSum;

        while (slowPtr != null) {
            currentSum = slowPtr.val + stack.pop();
            if (maxSum < currentSum) {
                maxSum = currentSum;
            }
            slowPtr = slowPtr.next;
        }
        return maxSum;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.println(head);

        System.out.println(pairSum(head));
    }
}
