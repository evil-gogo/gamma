package graph.tree;

public class KthLargestElementInBST {
    static int count = 0;

    public static void printKthLargestElement(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        printKthLargestElement(root.right, k);

        count++;
        if (count == k) {
            System.out.println("Kth = " + k + " | Largest element in BST is : " + root.val);
        }

        printKthLargestElement(root.left, k);
    }

    public static void main(String[] args) {
        int[] input = {20, 8, 22, 4, 12, 10, 14};

        Tree bst = new Tree();

        for (int i = 0; i < input.length; i++) {
            bst.root = bst.insertInBST(bst.root, input[i]);
        }

        int k = 7;
        printKthLargestElement(bst.root, k);
    }
}