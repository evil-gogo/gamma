package companies.jp_morgan.merge_k_sorted_list;

import java.util.*;

/*
Given a list containing heads of sorted singly linked list, merge all the lists and return the head of the list.
Example
L1 - {-1, 3, 6, 9} - O(L1)
L2 - {-10, 4, 7} - O (L2)
L3 - {5, 12, 56} - O (L3)

The sorted list would be - {-10, -1, 3, 4, 5, 6, 7, 9, 12, 56}
Return the head of this new lists
*/

// MinHeap/PQ - size (No.Of List)

// minElement O(1)

class Node {
    int val;
    Node next;

    Node() {

    }

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {

    public static void main(String[] args) {

        List<Node> inputList = new ArrayList<>();

        Node head1 = new Node(-1);
        head1.next = new Node(3);
        head1.next.next = new Node(6);
        head1.next.next.next = new Node(9);

        inputList.add(head1);

        Node head2 = new Node(-10);
        head2.next = new Node(4);
        head2.next.next = new Node(7);

        inputList.add(head2);

        Node head3 = new Node(5);
        head3.next = new Node(12);
        head3.next.next = new Node(56);

        inputList.add(head3);

        Node result = merge(inputList);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static Node merge(List<Node> lists) {
        Node sortedMergedListDummy = new Node();
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return Integer.compare(n1.val, n2.val);
            }
        });

        int noOfLists = lists.size();
        Node tempSortedMergedListDummy = sortedMergedListDummy;

        for (Node head : lists) {
            if (minHeap.size() < noOfLists) {
                minHeap.add(head);
            }
        }

        while (!minHeap.isEmpty()) {
            Node smallestNode = minHeap.poll();
            tempSortedMergedListDummy.next = smallestNode;
            tempSortedMergedListDummy = tempSortedMergedListDummy.next;
            if (smallestNode.next != null) {
                minHeap.add(smallestNode.next);
            }
        }

        return sortedMergedListDummy.next;
    }
}
