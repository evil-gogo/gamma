package leetcode.p_2095_delete_the_middle_node_of_a_linked_list;

//https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/

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
    public static ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        if (head.next.next == null) {
            head.next = null;
            return head;
        }

        ListNode slowPtr, fastPtr;
        slowPtr = fastPtr = head;

        while (fastPtr.next != null) {
            slowPtr = slowPtr.next;

            fastPtr = fastPtr.next;
            if (fastPtr.next != null) {
                fastPtr = fastPtr.next;
            }
        }

        ListNode nextNode = slowPtr.next;
        slowPtr.val = nextNode.val;
        slowPtr.next = nextNode.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);

        System.out.println(head);
        deleteMiddle(head);
        System.out.println(head);
    }
}
