package graph.tree;


public class KthSmallestElementInBST {

    static int count = 0;
    public static void printKthSmallest(Node root, int k) {
        if (root == null) {
            return;
        }

        printKthSmallest(root.left, k);

        count++;
        if (count == k) {
            System.out.println("Kth = " + k + " | Smallest element in BST is : " + root.data);
        }

        printKthSmallest(root.right, k);
    }

    public static void main(String[] args) {
        int input[] = { 20, 8, 22, 4, 12, 10, 14 };

        Tree tree = new Tree();
        tree.root = new Node(input[0]);

        for (int i = 1; i < input.length; i++) {
            tree.insertInBST(tree.root, input[i]);
        }

        int k = 4;
        printKthSmallest(tree.root, k);
    }
}