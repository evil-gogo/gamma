package leetcode.p_1448_count_good_nodes_in_binary_tree;

//https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/

import graph.tree.Tree;
import graph.tree.TreeNode;
class Counter {
    int counter;
}
class Solution {
    public static int goodNodes(TreeNode root) {
        Counter counter = new Counter();
        preOrderTraversal(root, root.val, counter);
        return counter.counter;
    }

    private static void preOrderTraversal(TreeNode node, int maxValue, Counter counter) {
        if (node == null) {
            return;
        }
        if (node.val >= maxValue) {
            maxValue = node.val;
            counter.counter++;
        }
        preOrderTraversal(node.left, maxValue, counter);
        preOrderTraversal(node.right, maxValue, counter);
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8};

        Tree bt = new Tree();
        bt.root = bt.insertInBT(bt.root, input);

        System.out.println(goodNodes(bt.root));
    }
}
