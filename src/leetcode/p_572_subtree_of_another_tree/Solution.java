package leetcode.p_572_subtree_of_another_tree;

//https://leetcode.com/problems/subtree-of-another-tree/description/

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
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return subRoot == null;
        }
        if (isIdentical(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean isIdentical(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        treeNode1.left = new TreeNode(4);
        treeNode1.right = new TreeNode(5);
        treeNode1.left.left = new TreeNode(1);
        treeNode1.left.right = new TreeNode(2);

        TreeNode treeNode2 = new TreeNode(4);
        treeNode2.left = new TreeNode(1);
        treeNode2.right = new TreeNode(2);
        System.out.println(isSubtree(treeNode1, treeNode2));
    }
}
