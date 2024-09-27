package leetcode.hard.h_124_binary_tree_maximum_path_sum;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

import graph.tree.Tree;
import graph.tree.TreeNode;

class MaxSum {
    int maxSum;
}

class Solution {
    static MaxSum maxSum = new MaxSum();

    public static int maxPathSum(TreeNode root) {
        maxSum.maxSum = Integer.MIN_VALUE;
        calculateMaxPathFromNode(root);
        return maxSum.maxSum;
    }

    private static int calculateMaxPathFromNode(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = calculateMaxPathFromNode(node.left);
        int right = calculateMaxPathFromNode(node.right);

        int case1 = left + right + node.val;

        int case2 = Math.max(left, right) + node.val;
        int case3 = node.val;

        maxSum.maxSum = Math.max(maxSum.maxSum, Math.max(Math.max(case1, case2), case3));

        return Math.max(case2, case3);
    }

    public static void main(String[] args) {
        int[] input = {-10, 9, 20, 0, 0, 15, 7};

        Tree bst = new Tree();

        for (int i = 0; i < input.length; i++) {
            bst.root = bst.insertInBST(bst.root, input[i]);
        }

        System.out.println(maxPathSum(bst.root));
    }
}

