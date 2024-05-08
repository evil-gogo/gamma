package graph.tree;

public class PreOrderTraversal {
    public static void preOrderTraversal(TreeNode node) {
        if (node == null)
            return;

        System.out.print(node.val + " ");

        preOrderTraversal(node.left);

        preOrderTraversal(node.right);
    }

    public static void main(String[] args) {
        int[] input = {20, 8, 22, 4, 12, 10, 14};

        Tree bst = new Tree();

        for (int i = 0; i < input.length; i++) {
            bst.root = bst.insertInBST(bst.root, input[i]);
        }

        System.out.println("Preorder traversal of binary search tree is: ");
        preOrderTraversal(bst.root);
    }
}
