package leetcode.m_82_remove_duplicates_from_sorted_list_II;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/

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
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        ListNode prevNode = dummyNode;
        ListNode tempNode = head;

        while (tempNode != null) {
            while (tempNode.next != null && tempNode.next.val == tempNode.val) {
                tempNode = tempNode.next;
            }

            if (prevNode.next == tempNode) {
                prevNode = tempNode;
            } else {
                prevNode.next = tempNode.next;
            }
            tempNode = tempNode.next;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 3, 4, 4, 5};
        ListNode head = new ListNode(input[0]);
        ListNode temp = head;
        for (int i = 1; i < input.length; i++) {
            temp.next = new ListNode(input[i]);
            temp = temp.next;
        }
        System.out.println(head);
        System.out.println(deleteDuplicates(head));
    }
}
