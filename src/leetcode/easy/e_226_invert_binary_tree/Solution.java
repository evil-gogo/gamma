package leetcode.easy.e_226_invert_binary_tree;

//https://leetcode.com/problems/invert-binary-tree/description/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public static TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private static void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        TreeNode tempNode = node.left;
        node.left = node.right;
        node.right = tempNode;
        dfs(node.left);
        dfs(node.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(9);
        System.out.println(invertTree(treeNode));
    }
}
