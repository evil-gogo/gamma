package graph.tree;

public class InOrderTraversal {
    public static void inOrderTraversal(Node node) {
        if (node == null)
            return;

        inOrderTraversal(node.left);

        System.out.print(node.data + " ");

        inOrderTraversal(node.right);
    }

    public static void main(String[] args) {
        int[] input = {20, 8, 22, 4, 12, 10, 14};

        Tree bst = new Tree();

        for (int i = 0; i < input.length; i++) {
            bst.root = bst.insertInBST(bst.root, input[i]);
        }

        System.out.print("Inorder traversal of binary search tree is : ");
        inOrderTraversal(bst.root);
    }
}
