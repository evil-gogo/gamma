package leetcode.p_366_find_leaves_of_binary_tree;

//https://leetcode.com/problems/find-leaves-of-binary-tree/description/

import java.util.ArrayList;
import java.util.List;

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
    public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        while (root != null) {
            List<Integer> leaves = new ArrayList<>();
            root = findLeaves(root, leaves);
            result.add(leaves);
        }
        return result;
    }

    private static TreeNode findLeaves(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return null;
        }

        root.left = findLeaves(root.left, leaves);
        root.right = findLeaves(root.right, leaves);

        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        System.out.println(findLeaves(treeNode));
    }
}
