package leetcode.m_1372_longest_zigzag_path_in_a_binary_tree;

//https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/
//https://algo.monster/liteproblems/1372

import graph.tree.Tree;
import graph.tree.TreeNode;
class ZigZagLength {
    int zigZagLength;
}
class Solution {
    public static int longestZigZag(TreeNode root) {
        ZigZagLength maxZigZagLength = new ZigZagLength();
        preOrderTraversal(root, 0, 0, maxZigZagLength);
        return maxZigZagLength.zigZagLength;
    }
    private static void preOrderTraversal(TreeNode node, int leftLength, int rightLength, ZigZagLength maxZigZagLength) {
        if (node == null) {
            return;
        }
        maxZigZagLength.zigZagLength = Math.max(maxZigZagLength.zigZagLength, Math.max(leftLength, rightLength));

        preOrderTraversal(node.left, rightLength + 1, 0, maxZigZagLength);
        preOrderTraversal(node.right, 0, leftLength + 1, maxZigZagLength);
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 3, 7, 8};

        Tree bt = new Tree();
        bt.root = bt.insertInBT(bt.root, input);
        System.out.println(longestZigZag(bt.root));
    }
}
