package leetcode.hard.h_25_reverse_nodes_in_k_group;

//https://leetcode.com/problems/reverse-nodes-in-k-group/description/

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
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode nextHead = null;
        ListNode prevTail = null;

        ListNode currHead = head;
        ListNode currTail = head;

        while (currHead != null) {
            int count = 1;

            while (currTail.next != null && count < k) {
                currTail = currTail.next;
                count++;
            }

            if (count != k) {
                break;
            }

            nextHead = currTail.next;
            currTail.next = null;

            if (prevTail != null) {
                prevTail.next = null;
            }

            currTail = reverseList(currHead);

            if (prevTail != null) {
                prevTail.next = currTail;
            } else {
                head = currTail;
            }

            currHead.next = nextHead;

            prevTail = currHead;
            currHead = nextHead;
            currTail = nextHead;
        }
        return head;
    }

    public static ListNode reverseList(ListNode head) {
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
        System.out.println(reverseKGroup(head, k));
    }
}
