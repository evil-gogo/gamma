package leetcode.e_94_binary_tree_inorder_traversal;

//https://leetcode.com/problems/binary-tree-inorder-traversal/description/

import graph.tree.Tree;
import graph.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }

    private static void inOrderTraversal(TreeNode node, List<Integer> result) {
        if (node == null)
            return;

        inOrderTraversal(node.left, result);

        result.add(node.val);

        inOrderTraversal(node.right, result);
    }

    public static void main(String[] args) {
        int[] input = {20, 8, 22, 4, 12, 10, 14};

        Tree bst = new Tree();

        for (int i = 0; i < input.length; i++) {
            bst.root = bst.insertInBST(bst.root, input[i]);
        }

        System.out.println(inorderTraversal(bst.root));
    }
}

