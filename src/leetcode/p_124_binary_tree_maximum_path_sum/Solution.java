package leetcode.p_124_binary_tree_maximum_path_sum;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

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

class MaxSum {
    int maxSum = Integer.MIN_VALUE;
}

class Solution {
    public int maxPathSum(TreeNode root) {
        MaxSum maxSum = new MaxSum();
        calculateMaxPathFromNode(root, maxSum);
        return maxSum.maxSum;
    }

    private int calculateMaxPathFromNode(TreeNode node, MaxSum maxSum) {
        if (node == null) {
            return 0;
        }
        int leftMaxSum = Math.max(0,  calculateMaxPathFromNode(node.left, maxSum));
        int rightMaxSum = Math.max(0, calculateMaxPathFromNode(node.right, maxSum));
        maxSum.maxSum = Math.max(maxSum.maxSum, node.val + leftMaxSum + rightMaxSum);
        return node.val + Math.max(leftMaxSum, rightMaxSum);
    }
}

