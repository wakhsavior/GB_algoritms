package Seminar_03;

public class MyList {
    private Node head;

    private class Node {
        private int value;
        private Node next;
    }

    public void addFirst(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    public int remove() {
        if (head != null) {
            int value = head.value;
            head = head.next;
            return value;
        } else return -1;

    }

    public boolean search(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return true;
            }
            currentNode = currentNode.next;

        }
        return false;
    }

    public void addLast(int value) {
        Node newNode = new Node();
        newNode.value = value;

        if (head == null) {
            head = newNode;
            return;
        }
        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;

    }

    public int removeLast() {
        Node currentNode = head;
        if (currentNode == null) {
            return -1;
        } else {
            while (currentNode.next != null) {
                if (currentNode.next.next == null) {
                    int value = currentNode.next.value;
                    currentNode.next = null;
                    return value;
                }
                currentNode = currentNode.next;
            }
            int value = head.value;
            head = null;
            return value;
        }
    }

    public void rotateList() {
        if (head != null && head.next != null) {
            Node previousNode = head;
            Node currentNode = head.next;
            while (currentNode != null) {
                Node nextNode = currentNode.next;
                currentNode.next = previousNode;
                previousNode = currentNode;
                currentNode = nextNode;
            }
            head = previousNode;
        }
    }

    public void sort() {
        boolean sorted;
        do {
            sorted = true;
            Node currentNode = head;
            while (currentNode.next != null) {
                if (currentNode.value > currentNode.next.value) {
                    int tmp = currentNode.value;
                    currentNode.value = currentNode.next.value;
                    currentNode.next.value = tmp;
                    sorted = false;
                }
                currentNode = currentNode.next;
            }
        } while (!sorted);
    }

    public void sort_v2() {
        boolean sorted;
        do {
            sorted = true;
            Node currentNode = head;
            Node previousNode;
            if (currentNode.value > currentNode.next.value) {
                head = currentNode.next;
                currentNode.next = currentNode.next.next;
                head.next.next = currentNode;
                sorted = false;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;

            while (currentNode.next != null) {
                {
                    if (currentNode.value > currentNode.next.value) {
                        previousNode.next = currentNode.next;
                        currentNode.next = currentNode.next.next;
                        previousNode.next.next = currentNode;
                        sorted = false;
                    }

                }
                currentNode = currentNode.next;
            }
        } while (!sorted);
    }
}