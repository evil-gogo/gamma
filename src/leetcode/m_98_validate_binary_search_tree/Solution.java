package leetcode.m_98_validate_binary_search_tree;

//https://leetcode.com/problems/validate-binary-search-tree/
//https://www.enjoyalgorithms.com/blog/validate-binary-search-tree

import java.util.ArrayList;

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
    public static boolean isValidBST(TreeNode root) {
        //return isValidBST_2(root);
        return isValidBST_1(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST_1(TreeNode root, long rangeMin, long rangeMax) {
        if (root == null) {
            return true;
        }

        if (root.val <= rangeMin || root.val >= rangeMax) {
            return false;
        }
        boolean left = isValidBST_1(root.left, rangeMin, root.val);
        boolean right = isValidBST_1(root.right, root.val, rangeMax);
        return left && right;
    }

    private static boolean isValidBST_2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        return isSorted(list);
    }

    private static void inOrderTraversal(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
    }

    private static boolean isSorted(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        System.out.println(isValidBST(treeNode));
    }
}
