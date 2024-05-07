package leetcode.p_2130_maximum_twin_sum_of_a_linked_list;

//https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/

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
        //return pairSum1(head);
        return pairSum2(head);
    }
    public static int pairSum1(ListNode head) {
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

    public static int pairSum2(ListNode head) {
        ListNode slowPtr, fastPtr;

        slowPtr = fastPtr = head;

        while (fastPtr != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        slowPtr = reverseList1(slowPtr);
        int maxSum = Integer.MIN_VALUE;
        int currentSum;

        while (slowPtr != null && head != null) {
            currentSum = slowPtr.val + head.val;
            if (maxSum < currentSum) {
                maxSum = currentSum;
            }
            slowPtr = slowPtr.next;
            head = head.next;
        }
        return maxSum;
    }

    public static ListNode reverseList1(ListNode head) {
        ListNode reversedLinkedListHead = null;
        ListNode currentNode;
        while (head != null) {
            currentNode = head;
            head = head.next;
            currentNode.next = reversedLinkedListHead;
            reversedLinkedListHead = currentNode;
        }
        return reversedLinkedListHead;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reversedLinkedListHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return reversedLinkedListHead;
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(head);

        System.out.println(pairSum(head));
    }
}
