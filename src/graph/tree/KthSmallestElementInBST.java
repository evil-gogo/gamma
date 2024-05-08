package graph.tree;


public class KthSmallestElementInBST {

    static int count = 0;

    public static void printKthSmallest(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        printKthSmallest(root.left, k);

        count++;
        if (count == k) {
            System.out.println("Kth = " + k + " | Smallest element in BST is : " + root.val);
        }

        printKthSmallest(root.right, k);
    }

    public static void main(String[] args) {
        int[] input = {20, 8, 22, 4, 12, 10, 14};

        Tree bst = new Tree();

        for (int i = 0; i < input.length; i++) {
            bst.root = bst.insertInBST(bst.root, input[i]);
        }

        int k = 4;
        printKthSmallest(bst.root, k);
    }
}