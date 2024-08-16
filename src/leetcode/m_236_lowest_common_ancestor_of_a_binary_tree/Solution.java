package leetcode.m_236_lowest_common_ancestor_of_a_binary_tree;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

import graph.tree.Tree;
import graph.tree.TreeNode;

class Solution {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode leftTreeNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTreeNode = lowestCommonAncestor(root.right, p, q);
        if (leftTreeNode != null && rightTreeNode != null) {
            return root;
        }
        return leftTreeNode != null ? leftTreeNode : rightTreeNode;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8};

        Tree bt = new Tree();
        bt.root = bt.insertInBT(bt.root, input);
        TreeNode lcaTreeNode = lowestCommonAncestor(bt.root, new TreeNode(5), new TreeNode(8));
        System.out.println(lcaTreeNode.val);
    }
}
