package leetcode.p_700_search_in_a_binary_search_tree;

//https://leetcode.com/problems/search-in-a-binary-search-tree/description/

import graph.tree.Tree;
import graph.tree.TreeNode;

class Solution {
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public static void main(String[] args) {
        //int[] input = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] input = {4, 2, 7, 1, 3};

        Tree bst = new Tree();
        for (int i = 0; i < input.length; i++) {
            bst.root = bst.insertInBST(bst.root, input[i]);
        }
        TreeNode node = searchBST(bst.root, 2);
        System.out.println(node);
    }
}
