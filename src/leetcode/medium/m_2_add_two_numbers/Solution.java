package leetcode.medium.m_2_add_two_numbers;

//https://leetcode.com/problems/add-two-numbers/description/

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        ListNode temp = this;
        String str = "";
        while (temp != null) {
            str = str + temp.val + " ";
            temp = temp.next;
        }
        return (str);
    }
}

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode result = dummyHead.next;
        dummyHead.next = null;
        return result;
    }

    public static void main(String[] args) {
        int[] l1 = {9, 9, 9, 9, 9, 9, 9}, l2 = {9, 9, 9, 9};
        ListNode temp;
        ListNode list1 = new ListNode(l1[0]);
        temp = list1;
        for (int i = 1; i < l1.length; i++) {
            temp.next = new ListNode(l1[i]);
            temp = temp.next;
        }

        ListNode list2 = new ListNode(l2[0]);
        temp = list2;
        for (int i = 1; i < l2.length; i++) {
            temp.next = new ListNode(l2[i]);
            temp = temp.next;
        }

        System.out.println(addTwoNumbers(list1, list2));
    }
}
