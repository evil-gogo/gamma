package graph.tree;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class Tree {
    Node root;

    public void Tree() {
    }

    public Node insertInBST(Node node, int data) {
        if (node == null) {
            node = new Node(data);
            return node;
        } else {
            if (data < node.data) {
                node.left = insertInBST(node.left, data);
            } else if (data > node.data) {
                node.right = insertInBST(node.right, data);
            }
        }
        return node;
    }

//    public Node insertInBSTMirror(Node node1, Node node2) {
//        if (node1 == null) {
//            return;
//        }
//        node2.left = node1.left;
//
//    }
}
