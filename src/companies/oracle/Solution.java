package companies.oracle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DoublyListNode {
    DoublyListNode random;
    DoublyListNode next;
    int data;

    DoublyListNode() {

    }

    DoublyListNode(int data) {
        this.data = data;
    }
}

class MyDoublyList {
    public DoublyListNode head;

    MyDoublyList(DoublyListNode node) {
        this.head = node;
    }

    public static DoublyListNode getDeepCopy(DoublyListNode head) {
        DoublyListNode dummyListHead = new DoublyListNode();

        //Random Nodes To Source Nodes
        Map<DoublyListNode, List<DoublyListNode>> mapRandomToSourceNodes = new HashMap<>();

        // Old Node To New Nodes
        Map<DoublyListNode, DoublyListNode> mapOldToNewNode = new HashMap<>();

        DoublyListNode temp = head;
        while (temp != null) {
            DoublyListNode prevNode = temp.random;
            if (mapRandomToSourceNodes.containsKey(prevNode)) {
                mapRandomToSourceNodes.get(prevNode).add(temp);
            } else {
                mapRandomToSourceNodes.put(prevNode, new ArrayList<>());
                mapRandomToSourceNodes.get(prevNode).add(temp);
            }
            temp = temp.next;
        }

        temp = head;
        DoublyListNode tempDummyNode = dummyListHead;
        while (temp != null) {
            DoublyListNode newNode = new DoublyListNode(temp.data);
            tempDummyNode.next = newNode;

            mapOldToNewNode.put(temp, newNode);

            tempDummyNode = tempDummyNode.next;
            temp = temp.next;
        }

        temp = head;
        tempDummyNode = dummyListHead.next;
        while (temp != null && tempDummyNode != null) {
            List<DoublyListNode> randomNodesList = mapRandomToSourceNodes.get(temp);

            if (randomNodesList != null) {
                for (DoublyListNode sourceNode : randomNodesList) {
                    if (sourceNode != null) {
                        DoublyListNode newNodeSource = mapOldToNewNode.get(sourceNode);
                        newNodeSource.random = tempDummyNode;
                    }
                }
            }
            tempDummyNode = tempDummyNode.next;
            temp = temp.next;
        }

        return dummyListHead.next;
    }

    public static void printList(DoublyListNode head) {
        DoublyListNode temp = head;
        while (temp != null) {
            if (temp.random != null) {
                System.out.print(temp.data + " " + temp.random.data + " | ");
            } else {
                System.out.print(temp.data + " | ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}

public class Solution {
    public static void main(String[] args) {
        MyDoublyList myDoublyList = new MyDoublyList(new DoublyListNode(1));

        myDoublyList.head.next = new DoublyListNode(2);
        myDoublyList.head.next.next = new DoublyListNode(3);
        myDoublyList.head.next.next.next = new DoublyListNode(4);
        myDoublyList.head.next.next.random = myDoublyList.head.next;
        myDoublyList.head.next.next.next.next = new DoublyListNode(5);
        myDoublyList.head.random = myDoublyList.head.next.next.next;

        MyDoublyList.printList(myDoublyList.head);

        DoublyListNode deepCopyHead = MyDoublyList.getDeepCopy(myDoublyList.head);
        MyDoublyList.printList(deepCopyHead);
    }
}


//Doubly Linked List

//Prev  // Can point to any node
//Next

//Make a deep copy of the list
//        Constraints
//Not unique node
//Source list is immutable

