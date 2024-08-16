package leetcode.e_100_same_tree;

//https://leetcode.com/problems/same-tree/description/

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
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    private static boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return dfs(p.left, q.left) && dfs(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(2);
        treeNode1.left.left = new TreeNode(3);
        treeNode1.left.right = new TreeNode(4);
        treeNode1.right.left = new TreeNode(4);
        treeNode1.right.right = new TreeNode(3);

        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(2);
        treeNode2.right = new TreeNode(2);
        treeNode2.left.left = new TreeNode(3);
        treeNode2.left.right = new TreeNode(4);
        treeNode2.right.left = new TreeNode(4);
        treeNode2.right.right = new TreeNode(3);

        System.out.println(isSameTree(treeNode1, treeNode2));
    }
}
