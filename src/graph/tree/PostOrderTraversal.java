package graph.tree;

public class PostOrderTraversal {
    public static void preOrderTraversal(Node node) {
        if (node == null)
            return;

        preOrderTraversal(node.left);

        preOrderTraversal(node.right);

        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        int[] input = {20, 8, 22, 4, 12, 10, 14};

        Tree bst = new Tree();

        for (int i = 0; i < input.length; i++) {
            bst.root = bst.insertInBST(bst.root, input[i]);
        }

        System.out.println("Postorder traversal of binary search tree is: ");
        preOrderTraversal(bst.root);
    }
}
