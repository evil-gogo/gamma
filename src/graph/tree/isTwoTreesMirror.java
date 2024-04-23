package graph.tree;

public class isTwoTreesMirror {
    public static void main(String[] args) {
        int[] input1 = {20, 8, 22, 4, 12, 10, 14};

        Tree bst1 = new Tree();

        for (int i = 0; i < input1.length; i++) {
            bst1.root = bst1.insertInBST(bst1.root, input1[i]);
        }

        int[] input2 = {10, 8, 22, 4, 12, 10, 14};

        Tree bst2 = new Tree();

//        for (int i = 0; i < input2.length; i++) {
//            bst2.root = bst2.insertInBSTMirror(bst2.root, input2[i]);
//        }

        if (areMirror(bst1.root, bst2.root) == true) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean areMirror(Node node1, Node node2) {
        if (node1 != null && node2 != null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return (node1.data == node2.data) && areMirror(node1.left, node2.right) && areMirror(node1.right, node2.left);
    }
}
