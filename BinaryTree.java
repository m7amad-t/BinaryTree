public class BinaryTree {
    // The root node of the binary tree
    private Node root;

    // A nested class that represents a node in the binary tree
    private static class Node {
        private int value;
        private Node left;
        private Node right;

        // Constructor for creating a new node
        public Node(int value) {
            this.value = value;
        }
    }

    // Adds a new value to the binary tree
    public void add(int value) {
        // Create a new node
        Node newNode = new Node(value);

        // If the tree is empty, set the new node as the root
        if (root == null) {
            root = newNode;
            return;
        }

        // Traverse the tree to find the correct position for the new node
        Node current = root;
        while (true) {
            if (value < current.value) {
                // If the new value is less than the current node's value, go left
                if (current.left == null) {
                    // If there is no left child, insert the new node here
                    current.left = newNode;
                    return;
                }
                current = current.left;
            } else {
                // If the new value is greater than or equal to the current node's value, go right
                if (current.right == null) {
                    // If there is no right child, insert the new node here
                    current.right = newNode;
                    return;
                }
                current = current.right;
            }
        }
    }

    // Returns true if the given value is present in the binary tree
    public boolean contains(int value) {
        // Start at the root node
        Node current = root;

        // Traverse the tree until the value is found or the end of the tree is reached
        while (current != null) {
            if (value == current.value) {
                // If the value is found, return true
                return true;
            } else if (value < current.value) {
                // If the value is less than the current node's value, go left
                current = current.left;
            } else {
                // If the value is greater than or equal to the current node's value, go right
                current = current.right;
            }
        }

        // If the value is not found, return false
        return false;
    }

    //this method print out all value inside of the tree from the smallest value to the greatest value
    public void traverse (){
        if (root == null){
            System.out.println("The tree is empty ! ");
            return ;
        }
        System.out.println("::::::  Head of the Tree :::::: ");
        System.out.println(root.value);

        System.out.println("::::::  Left of the Tree :::::: ");
        printBinaryTree(root.left);

        System.out.println("::::::  Right of the Tree :::::: ");
        printBinaryTree(root.right);
    }


    public void printBinaryTree(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value); // print the value of the root node
        printBinaryTree(root.left); // recursively print the left subtree
        printBinaryTree(root.right); // recursively print the right subtree
    }
