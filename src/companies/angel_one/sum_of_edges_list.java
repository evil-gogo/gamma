package companies.angel_one;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}

class MyLinkedList {
    Node head;

    public Node sumOfEdges(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalfStart = slow.next;
        Node reversedSecondHalfHead = reverseList(secondHalfStart);

        Node dummy = new Node(-1);
        Node tempDummyHead = dummy;
        Node currentNode = head;

        while (currentNode != secondHalfStart) {
            if (reversedSecondHalfHead != null) {
                tempDummyHead.next = new Node(currentNode.data + reversedSecondHalfHead.data);
                reversedSecondHalfHead = reversedSecondHalfHead.next;
            } else {
                tempDummyHead.next = new Node(currentNode.data);
            }
            tempDummyHead = tempDummyHead.next;
            currentNode = currentNode.next;
        }

        return dummy.next;
    }

    public static Node reverseList(Node head) {
        Node reversedLinkedListHead = null;
        Node currentNode;
        while (head != null) {
            currentNode = new Node(head.data);
            head = head.next;
            currentNode.next = reversedLinkedListHead;
            reversedLinkedListHead = currentNode;
        }
        return reversedLinkedListHead;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
        list.head.next.next.next.next.next.next = new Node(7);
        list.head.next.next.next.next.next.next.next = new Node(8);

        System.out.println("Original List: " + list);

        Node sumOfEdgesHead = list.sumOfEdges(list.head);
        MyLinkedList sumOfEdgesList = new MyLinkedList();
        sumOfEdgesList.head = sumOfEdgesHead;

        System.out.println("Resultant List: " + sumOfEdgesList);

        System.out.println("Original List: " + list);

    }
}
