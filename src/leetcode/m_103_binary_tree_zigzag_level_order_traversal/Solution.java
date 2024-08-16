package leetcode.m_103_binary_tree_zigzag_level_order_traversal;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                TreeNode currentNode = queue.poll();
                assert currentNode != null;
                tempList.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            if (!leftToRight) {
                Collections.reverse(tempList);
            }
            result.add(tempList);
            leftToRight = !leftToRight;
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println(zigzagLevelOrder(treeNode));
    }
}
