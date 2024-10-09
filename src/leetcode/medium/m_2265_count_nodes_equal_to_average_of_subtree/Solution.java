package leetcode.medium.m_2265_count_nodes_equal_to_average_of_subtree;

import graph.tree.Tree;
import graph.tree.TreeNode;

import java.util.Arrays;


class Solution {
    static int count = 0;
    public static int averageOfSubtree(TreeNode root) {
        findAverage(root);
        return count;
    }

    private static int[] findAverage(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = findAverage(node.left);
        int[] right = findAverage(node.right);
        int totalSum = node.val + left[0] + right[0];
        int totalNodes = 1 + left[1] + right[1];
        int average = totalSum / totalNodes;

        if (node.val == average) {
            count++;
        }
        return new int[]{node.val + left[0] + right[0], 1 + left[1] + right[1]};
    }

    public static void main(String[] args) {
        Integer[] input = {1,8,5,0,1,null,6};

        TreeNode root = new TreeNode(input[0]);

//        root.left = new TreeNode(input[1]);
//        root.right = new TreeNode(input[2]);
//        root.left.left = new TreeNode(input[3]);
//        root.left.right = new TreeNode(input[4]);
//
//        root.right.right = new TreeNode(input[6]);

        System.out.println(averageOfSubtree(root));
    }
}
