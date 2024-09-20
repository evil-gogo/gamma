package leetcode.medium.m_230_kth_smallest_element_in_a_bst;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

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
    public static int kthSmallest(TreeNode root, int k) {
        int[] result = new int[2];
        result[0] = k;
        result[1] = -1;

        inOrderTraversal(root, result);
        return result[1];
    }

    private static void inOrderTraversal(TreeNode root, int[] result) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, result);
        result[0]--;
        if (result[0] == 0) {
            result[1] = root.val;
            return;
        }
        inOrderTraversal(root.right, result);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(6);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);
        treeNode.left.left.left = new TreeNode(1);
        int k = 3;
        System.out.println(kthSmallest(treeNode, k));
    }
}
