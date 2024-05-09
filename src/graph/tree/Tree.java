package graph.tree;

public class Tree {
    public TreeNode root;
    public void Tree() {
    }

    public TreeNode insertInBST(TreeNode node, int data) {
        if (node == null) {
            node = new TreeNode(data);
            return node;
        } else {
            if (data < node.val) {
                node.left = insertInBST(node.left, data);
            } else if (data > node.val) {
                node.right = insertInBST(node.right, data);
            }
        }
        return node;
    }

    public TreeNode insertInBT(TreeNode node, int[] input) {
        node = new TreeNode(input[0]);
        node.left = new TreeNode(input[1]);
        node.right = new TreeNode(input[2]);
        node.left.left = new TreeNode(input[3]);
        node.left.right = new TreeNode(input[4]);
        node.right.left = new TreeNode(input[5]);
        node.right.right = new TreeNode(input[6]);
        node.left.left.left = new TreeNode(input[7]);
        return node;
    }
}
