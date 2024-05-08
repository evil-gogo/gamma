package leetcode.p_104_maximum_depth_of_binary_tree;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

import graph.tree.Tree;
import graph.tree.TreeNode;

class Solution {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8};

        Tree bt = new Tree();
        bt.root = bt.insertInBT(bt.root, input);
        System.out.println(maxDepth(bt.root));
    }
}
