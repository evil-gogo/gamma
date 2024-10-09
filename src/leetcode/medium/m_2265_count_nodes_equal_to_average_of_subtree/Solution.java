package leetcode.medium.m_2265_count_nodes_equal_to_average_of_subtree;

//https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/description/

import graph.tree.TreeNode;

class Solution {
    static int count = 0;

    public static int averageOfSubtree(TreeNode root) {
        findAverage(root);
        return count;
    }

    private static int[] findAverage(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] leftNode = findAverage(root.left);
        int[] rightNode = findAverage(root.right);

        int totalSum = root.val + leftNode[0] + rightNode[0];
        int totalNodes = 1 + leftNode[1] + rightNode[1];
        int average = totalSum / totalNodes;

        if (root.val == average) {
            count++;
        }
        return new int[]{totalSum, totalNodes};
    }

    public static void main(String[] args) {
        Integer[] input = {1, 8, 5, 0, 1, null, 6};

        TreeNode root = new TreeNode(input[0]);
        root.left = new TreeNode(input[1]);
        root.right = new TreeNode(input[2]);
        root.left.left = new TreeNode(input[3]);
        root.left.right = new TreeNode(input[4]);
        root.right.right = new TreeNode(input[6]);

        System.out.println(averageOfSubtree(root));
    }
}
