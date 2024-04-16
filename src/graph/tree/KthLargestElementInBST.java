package graph.tree;

public class KthLargestElementInBST {
    static int count = 0;
    public static void printKthLargestElement(Node root, int k) {
        if (root == null) {
            return;
        }

        printKthLargestElement(root.right, k);

        count++;
        if (count == k) {
            System.out.println("Kth = " + k + " | Largest element in BST is : " + root.data);
        }

        printKthLargestElement(root.left, k);
    }

    public static void main(String[] args) {
        int input[] = { 20, 8, 22, 4, 12, 10, 14 };

        Tree tree = new Tree();
        tree.root = new Node(input[0]);

        for (int i = 1; i < input.length; i++) {
            tree.insertInBST(tree.root, input[i]);
        }

        int k = 7;
        printKthLargestElement(tree.root, k);
    }
}