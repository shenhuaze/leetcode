package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2020-02-01
 */
public class PopulatingNextRightPointersInEachNodeII {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        // 下面这段代码是找出与root同一层右边那个节点的子节点中最靠近左侧那个，
        // 如果右边的节点没有子节点，就再往右找同一层的节点，直到找到下一层的最靠近左侧的子节点，
        // 或者直到遍历完所有的同一层的节点。
        Node p = root.next;
        while (p != null) {
            if (p.left != null) {
                p = p.left;
                break;
            }
            if (p.right != null) {
                p = p.right;
                break;
            }
            p = p.next;
        }

        // 下面这段代码是将当前root节点的子节点往右连接，先右子节点往右连接，再左子节点往右连接，
        // 这里好像反过来应该也行。。
        if (root.right != null) {
            root.right.next = p;
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = p;
            }
        }

        // 下面这段代码先递归右节点，再递归左节点
        connect(root.right);
        connect(root.left);

        return root;
    }

    public void demo() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        Node root_ = connect(root);
        System.out.println();
    }

    public static void main(String[] args) {
        new PopulatingNextRightPointersInEachNodeII().demo();
    }
}
