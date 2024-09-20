package leetcode.easy.e_872_leaf_similar_trees;

//https://leetcode.com/problems/leaf-similar-trees/description/

import graph.tree.Tree;
import graph.tree.TreeNode;

import java.util.LinkedList;

class Solution {

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        LinkedList<Integer> leafNodes1 = new LinkedList<>();
        LinkedList<Integer> leafNodes2 = new LinkedList<>();
        inOrderTraversal(root1, leafNodes1);
        inOrderTraversal(root2, leafNodes2);

        if (leafNodes1.size() != leafNodes2.size()) {
            return false;
        } else {
            for (int i = 0; i < leafNodes1.size(); i++) {
                if (leafNodes1.get(i).intValue() != leafNodes2.get(i).intValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void inOrderTraversal(TreeNode node, LinkedList<Integer> listLeafNodes) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, listLeafNodes);
        if (node.left ==  null && node.right == null) {
            listLeafNodes.add(node.val);
        }
        inOrderTraversal(node.right, listLeafNodes);
    }

    public static void main(String[] args) {
        //int[] input = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] input1 = {1, 2, 200};

        Tree bt1 = new Tree();
        bt1.root = bt1.insertInBT(bt1.root, input1);

        int[] input2 = {1, 2, 200};

        Tree bt2 = new Tree();
        bt2.root = bt2.insertInBT(bt2.root, input2);
        System.out.println(leafSimilar(bt1.root, bt2.root));
    }
}
