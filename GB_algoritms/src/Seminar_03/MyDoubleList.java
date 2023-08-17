package Seminar_03;

public class MyDoubleList {
    private Node head;
    private Node tail;

    private class Node {
        private int value;
        private Node next;
        private Node previous;
    }

    public void addFirst(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (head != null) {
            newNode.next = head;
            head.previous = newNode;
        } else {
            tail = newNode;
        }

        head = newNode;
    }

    public void addLast(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (tail != null) {
            newNode.previous = tail;
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
    }

    public int removeFirst() {
        if (head != null && head.next != null) {
            int value = head.value;
            head.next.previous = null;
            head = head.next;
            return value;
        } else {
            head = null;
            tail = null;
        }
        return -1;
    }

    public int removeLast() {
        if (tail != null && tail.previous != null) {
            int value = tail.value;
            tail.previous.next = null;
            tail = tail.previous;
            return value;
        } else {
            head = null;
            tail = null;
        }
        return -1;
    }

    public void rotateDoubleList() {
        if (head != null && head.next != null) {
            Node currentNode = head;
            while (currentNode != null) {
                Node nextNode = currentNode.next;
                Node previous = currentNode.previous;
                currentNode.previous = nextNode;
                currentNode.next = previous;
                currentNode = nextNode;
            }
            Node headTmp = head;
            head = tail;
            tail = headTmp;
        }
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
