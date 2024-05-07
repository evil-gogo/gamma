package leetcode.p_328_odd_even_linked_list;

//https://leetcode.com/problems/odd-even-linked-list/description/

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
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode oddPtr = head;
        ListNode evenPtr = head.next;

        ListNode evenPtrHead = evenPtr;

        while (evenPtr != null && evenPtr.next != null && oddPtr != null  && oddPtr.next != null) {
            ListNode evenPtrNext = evenPtr.next;

            oddPtr.next = evenPtrNext;
            oddPtr = oddPtr.next;

            evenPtr.next = oddPtr.next;
            evenPtr = evenPtrNext.next;
        }

        oddPtr.next = evenPtrHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        System.out.println(head);
        oddEvenList(head);
        System.out.println(head);
    }
}
