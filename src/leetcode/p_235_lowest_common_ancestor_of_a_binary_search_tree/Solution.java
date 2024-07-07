package leetcode.p_235_lowest_common_ancestor_of_a_binary_search_tree;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor((root.left), p, q);
        TreeNode right = lowestCommonAncestor((root.right), p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(6);
        TreeNode p = treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(0);
        TreeNode q = treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(7);
        treeNode.right.right = new TreeNode(9);
        treeNode.left.right.left = new TreeNode(3);
        treeNode.left.right.right = new TreeNode(5);

        System.out.println(lowestCommonAncestor(treeNode, p, q).val);
    }
}

