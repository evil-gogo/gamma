package leetcode.e_206_reverse_linked_list;

//https://leetcode.com/problems/reverse-linked-list/description/

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
    public static ListNode reverseList(ListNode head) {
        return reverseList1(head);
        //return reverseList2(head);
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
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.println(head);
        System.out.println(reverseList(head));
    }
}