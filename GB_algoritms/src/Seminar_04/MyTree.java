package Seminar_04;

public class MyTree<V extends Comparable<V>> {
    private Node root;

    private class Node {
        private V value;
        private Node left;
        private Node right;
        private Color color;
    }

    public boolean add(V value) {
        if (root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }

    private boolean addNode(Node node, V value) {
        if (node.value.compareTo(value) == 0) {
            return false;
        } else {
            if (node.value.compareTo(value) > 0) {
                if (node.left != null) {
                    boolean result = addNode(node.left, value);
                    node.left = rebalance(node.left);
                    return result;
                } else {
                    node.left = new Node();
                    node.left.color = Color.RED;
                    node.left.value = value;
                    return true;
                }
            } else {
                if (node.right != null) {
                    boolean result = addNode(node.right, value);
                    node.right = rebalance(node.right);
                    return result;
                } else {
                    node.right = new Node();
                    node.right.color = Color.RED;
                    node.right.value = value;
                    return true;
                }
            }
        }
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.right != null && result.right.color == Color.RED && (result.left == null || result.left.color == Color.BLACK)) {
                needRebalance = true;
                result = rotateRight(result);
            }
            if (result.left != null && result.left.color == Color.RED && (result.left.left != null && result.left.left.color == Color.RED)) {
                needRebalance = true;
                result = rotateLeft(result);
            }
            if (result.left != null && result.left.color == Color.RED && result.right != null && result.right.color == Color.RED) {
                needRebalance = true;
                swipeColor(result);
            }
        } while (needRebalance);
        return result;
    }


    private Node rotateLeft(Node node) {
        Node leftChild = node.left;
        Node tmpNode = leftChild.right;
        leftChild.right = node;
        node.left = tmpNode;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

    private Node rotateRight(Node node) {
        Node rightChild = node.right;
        Node tmpNode = rightChild.left;
        rightChild.left = node;
        node.right = tmpNode;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    private void swipeColor(Node node) {
        node.color = Color.RED;
        node.left.color = Color.BLACK;
        node.right.color = Color.BLACK;

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

    private enum Color {
        RED, BLACK
    }
}
