package leetcode.medium.m_19_remove_nth_node_from_end_of_list;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

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
        String str = "";
        ListNode temp = this;
        while (temp != null) {
            str += temp.val + " ";
            temp = temp.next;
        }
        return str + "|";
    }
}

class Solution {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0, head);

        ListNode fastPointer = dummyNode;
        ListNode slowPointer = dummyNode;

        while (n-- > 0) {
            fastPointer = fastPointer.next;
        }

        while (fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        slowPointer.next = slowPointer.next.next;

        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        int k = 3;
        ListNode head = new ListNode(input[0]);
        ListNode temp = head;
        for (int i = 1; i < input.length; i++) {
            temp.next = new ListNode(input[i]);
            temp = temp.next;
        }
        System.out.println(head);
        System.out.println(removeNthFromEnd(head, k));
    }
}
