package companies.microsoft.interview.lowest_common_ancestor_n_ary_tree;

import java.util.ArrayList;
import java.util.List;

class Node {
    int val;
    List<Node> children;

    public Node(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}

class Solution {
    public static Node lowestCommonAncestor(Node root, Node node1, Node node2) {
        if (root == null || root == node1 || root == node2) {
            return root;
        }

        int count = 0;
        Node temp = null;

        for (Node childNode : root.children) {
            Node node = lowestCommonAncestor(childNode, node1, node2);
            if (node != null) {
                count++;
                temp = node;
            }
        }

        if (count == 2) {
            return root;
        }

        return temp;
    }

    public static void main(String[] args) {
        // Construct the N-ary tree
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        root.children.add(node2);
        root.children.add(node3);
        root.children.add(node4);
        node2.children.add(node5);
        node2.children.add(node6);
        node3.children.add(node7);
        node4.children.add(node8);

        Node lca = lowestCommonAncestor(root, node5, node7);

        if (lca != null) {
            System.out.println("LCA of node 5 and node 7 is: " + lca.val);
        } else {
            System.out.println("LCA not found.");
        }
    }
}
