package leetcode.p_23_merge_k_sorted_lists;

//https://leetcode.com/problems/merge-k-sorted-lists/description/

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int value) {
        this.val = value;
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
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);

        for (ListNode head : lists) {
            if (head != null) {
                priorityQueue.offer(head);
            }
        }

        ListNode mergedListDummyHead = new ListNode();
        ListNode current = mergedListDummyHead;

        while (!priorityQueue.isEmpty()) {
            ListNode smallestNode = priorityQueue.poll();

            if (smallestNode.next != null) {
                priorityQueue.offer(smallestNode.next);
            }

            current.next = smallestNode;
            current = current.next;
        }

        return mergedListDummyHead.next;
    }

    public static void main(String[] args) {
        int[][] inputLists = {{1, 4, 5}, {1, 3, 4}, {2, 6}};
        ListNode[] lists = new ListNode[inputLists.length];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ListNode(inputLists[i][0]);
            ListNode temp = lists[i];
            for (int j = 1; j < inputLists[i].length; j++) {
                temp.next = new ListNode(inputLists[i][j]);
                temp = temp.next;
            }
        }
        System.out.println(mergeKLists(lists));
    }
}
