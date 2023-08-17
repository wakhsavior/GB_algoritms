package Seminar_04;

public class MyTree<V extends Comparable<V>> {
    private Node root;

    private class Node {
        private V value;
        private Node left;
        private Node right;
    }

    public boolean contains(V value) {
        Node node = root;
        while (node != null) {
            if (node.value.equals(value)) {
                return true;
            }
            if (node.value.compareTo(value) > 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return false;
    }

    public boolean containsRec(Node node, V value) {
        if (node.value.equals(value)) {
            return true;
        } else {
            if (node.value.compareTo(value) > 0) {
                return containsRec(node.left, value);
            } else {
                return containsRec(node.right, value);
            }
        }

    }
    private enum Color{
        RED, BLACK
    }
}
