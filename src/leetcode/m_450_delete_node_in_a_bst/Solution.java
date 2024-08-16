package leetcode.m_450_delete_node_in_a_bst;

//https://leetcode.com/problems/delete-node-in-a-bst/description/

import graph.tree.Tree;
import graph.tree.TreeNode;

class Solution {
    public static TreeNode deleteNode(TreeNode root, int key) {
        //return deleteNode1(root, key);
        return deleteNode2(root, key);
    }
    public static TreeNode deleteNode1(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null ) { // Leaf node case
                return null; // This is delete operation
            }
            if (root.left == null) { // 1 Child node case
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            TreeNode inOrderSuccessor = findInOrderSuccessor(root.right);

            root.val = inOrderSuccessor.val;
            root.right = deleteNode(root.right, inOrderSuccessor.val); // Delete this node in subsequent calls
        } else {
            if (key < root.val) {
                root.left = deleteNode(root.left, key);
            } else {
                root.right = deleteNode(root.right, key);
            }
        }
        return root;
    }

    public static TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null ) { // Leaf node case
                return null; // This is delete operation
            }
            if (root.left == null) { // 1 Child node case
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            TreeNode inOrderPredecessor = findInOrderPredecessor(root.left);

            root.val = inOrderPredecessor.val;
            root.left = deleteNode(root.left, inOrderPredecessor.val); // Delete this node in subsequent calls
        } else {
            if (key < root.val) {
                root.left = deleteNode(root.left, key);
            } else {
                root.right = deleteNode(root.right, key);
            }
        }
        return root;
    }
    public static TreeNode findInOrderSuccessor(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static TreeNode findInOrderPredecessor(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public static void main(String[] args) {
        //int[] input = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] input = {4, 2, 7, 1, 3};

        Tree bst = new Tree();
        for (int i = 0; i <input.length ; i++) {
            bst.root = bst.insertInBST(bst.root, input[i]);
        }
        TreeNode node = deleteNode(bst.root, 2);
        System.out.println(node);
    }
}

