package leetcode.p_199_binary_tree_right_side_view;

//https://leetcode.com/problems/binary-tree-right-side-view/description/

import graph.tree.Tree;
import graph.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class MaxLevel {
    int maxLevel;
}
class Solution {
    public static List<Integer> rightSideView(TreeNode root) {
        //return rightSideView1(root);
        return rightSideView2(root);
    }
    public static List<Integer> rightSideView1(TreeNode root) {
        List<Integer> listRightView = new LinkedList<>();
        if (root == null) {
            return listRightView;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                TreeNode temp = queue.poll();

                if (i == queueSize - 1) {
                    listRightView.add(temp.val);
                }

                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return listRightView;
    }

    public static List<Integer> rightSideView2(TreeNode root) {
        MaxLevel maxLevel = new MaxLevel();
        List<Integer> listRightView = new LinkedList<>();

        rightSideViewUtil(root, 1, maxLevel, listRightView);
        return listRightView;
    }

    public static void rightSideViewUtil(TreeNode node, int currentLevel, MaxLevel maxLevel, List<Integer> listRightView) {
        if (node ==  null) {
            return;
        }
        if (maxLevel.maxLevel < currentLevel) {
            maxLevel.maxLevel = currentLevel;
            listRightView.add(node.val);
        }
        rightSideViewUtil(node.right, currentLevel + 1, maxLevel, listRightView);
        rightSideViewUtil(node.left, currentLevel + 1, maxLevel, listRightView);
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8};

        Tree bt = new Tree();
        bt.root = bt.insertInBT(bt.root, input);
        System.out.println(rightSideView(bt.root));
    }
}
