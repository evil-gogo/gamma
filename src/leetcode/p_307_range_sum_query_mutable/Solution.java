//package leetcode.p_307_range_sum_query_mutable;
//
//import graph.tree.TreeNode;
//
//class NumArray {
//    public NumArray(int[] nums) {
//
//    }
//
//    public void update(int index, int val) {
//
//    }
//
//    public int sumRange(int left, int right) {
//
//    }
//
//    public class SegmentTree {
//        private TreeNode root;
//
//        public SegmentTree(int[] array) {
//            this.root = buildTree(array, 0, array.length - 1);
//        }
//
//        private TreeNode buildTree(int[] array, int start, int end) {
//            if (start > end) {
//                return null;
//            }
//
//            TreeNode node = new TreeNode(start, end);
//            if (start == end) {
//                node.val = array[start];
//            } else {
//                int mid = (start + end) / 2;
//                node.left = buildTree(array, start, mid);
//                node.right = buildTree(array, mid + 1, end);
//                node.val = node.left.val + node.right.val;
//            }
//            return node;
//        }
//
//        public int rangeSum(int start, int end) {
//            return queryRange(this.root, start, end);
//        }
//
//        private int queryRange(TreeNode node, int start, int end) {
//            if (node == null || start > node.right.val || end < node.left.val) {
//                return 0;
//            }
//
//            if (start <= node.left.val && end >= node.right.val) {
//                return node.val;
//            }
//
//            return queryRange(node.left, start, end) + queryRange(node.right, start, end);
//        }
//    }
//
//    public static void main(String[] args) {
//        String[] sequence = {"NumArray", "sumRange", "update", "sumRange"};
//        int[][] input = {{1, 3, 5}, {0, 2}, {1, 2}, {0, 2}};
//        NumArray numArray = null;
//        int inputIndex = 0;
//        for (String s : sequence) {
//            switch (s) {
//                case "NumArray":
//                    numArray = new NumArray(input[0]);
//                    inputIndex++;
//                    break;
//                case "sumRange":
//                    assert numArray != null;
//                    numArray.sumRange(input[inputIndex][0], input[inputIndex][1]);
//                    inputIndex++;
//                    break;
//                case "update":
//                    assert numArray != null;
//                    numArray.update(input[inputIndex][0], input[inputIndex][1]);
//                    inputIndex++;
//                    break;
//            }
//        }
//    }
//}
