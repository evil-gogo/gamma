package leetcode.hard.h_968_binary_tree_cameras;

//https://leetcode.com/problems/binary-tree-cameras/description/
//https://www.youtube.com/watch?v=2Gh5WPjAgJk&ab_channel=AlgorithmsMadeEasy

import graph.tree.Tree;
import graph.tree.TreeNode;

enum STATE {
    CAMERA,
    COVERED_WITH_THE_CAMERA,
    NOT_COVERED_WITH_THE_CAMERA
}

class Counter {
    int counter;
}

class Solution {
    public static int minCameraCover(TreeNode root) {
        Counter counter = new Counter();
        return dfs(root, counter) == STATE.NOT_COVERED_WITH_THE_CAMERA ? counter.counter + 1 : counter.counter;
    }

    public static STATE dfs(TreeNode node, Counter counter) {
        if (node == null) {
            return STATE.COVERED_WITH_THE_CAMERA;
        }

        STATE LEFT_NODE_STATE = dfs(node.left, counter);
        STATE RIGHT_NODE_STATE = dfs(node.right, counter);

        if (LEFT_NODE_STATE == STATE.NOT_COVERED_WITH_THE_CAMERA || RIGHT_NODE_STATE == STATE.NOT_COVERED_WITH_THE_CAMERA) {
            counter.counter++;
            return STATE.CAMERA;
        } else if (LEFT_NODE_STATE == STATE.CAMERA || RIGHT_NODE_STATE == STATE.CAMERA) {
            return STATE.COVERED_WITH_THE_CAMERA;
        } else {
            return STATE.NOT_COVERED_WITH_THE_CAMERA;
        }
    }

    public static void main(String[] args) {
        int[] input = {20, 8, 22, 4, 12, 10, 14};

        Tree bst = new Tree();

        for (int i = 0; i < input.length; i++) {
            bst.root = bst.insertInBST(bst.root, input[i]);
        }

        System.out.println(minCameraCover(bst.root));
    }
}