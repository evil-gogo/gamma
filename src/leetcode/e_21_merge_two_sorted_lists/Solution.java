package leetcode.e_21_merge_two_sorted_lists;

//https://leetcode.com/problems/merge-two-sorted-lists/description/

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
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        current.next = (list1 == null) ? list2 : list1;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] l1 = {1, 2, 4}, l2 = {1, 3, 4};

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

        System.out.println(mergeTwoLists(list1, list2));
    }
}
