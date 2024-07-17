package leetcode.p_101_symmetric_tree;

//https://leetcode.com/problems/symmetric-tree/description/

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
    public static boolean isSymmetric(TreeNode root) {
        return dfs(root, root);
    }

    private static boolean dfs(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }
        return dfs(node1.left, node2.right) && dfs(node1.right, node2.left);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(3);
        System.out.println(isSymmetric(treeNode));
    }
}
