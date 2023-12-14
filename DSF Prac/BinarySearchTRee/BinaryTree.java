package BinarySearchTRee;

import java.util.Stack;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public Node insertRec(Node root, int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    public Node deleteRec(Node root, int data) {
        if (root == null) {
            return root;
        }
        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    public void delete(int data) {
        root = deleteRec(root, data);
    }

    int minValue(Node root) {
        int min = root.data;
        while (root != null) {
            min = root.left.data;
            root = root.left;

        }
        return min;

    }

    public void nonrecInorder(Node root) {
        if (root == null) {
            System.out.println("tree is empty");
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.println(current.data);
            current = current.right;

        }
    }

    void inorderRev(Node root) {
        if (root != null) {
            inorderRev(root.left);
            System.out.println(root.data);
            inorderRev(root.right);

        }
    }

    void inorder() {
        nonrecInorder(root);
    }
}
