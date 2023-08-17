package Seminar_04;

import Lesson_03.List;

import java.util.ArrayList;

public class HashTable<K, V> {
    private int size = 0;
    private static final int INIT_BASKET_COUNT = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private Basket[] arrayBacket;

    public HashTable() {
        this(INIT_BASKET_COUNT);
    }


    public HashTable(int initSize) {
        arrayBacket = (Basket[]) new Object[initSize];
    }

    private void increseArray() {
        Basket[] oldArrayBasket = arrayBacket;
        arrayBacket = (Basket[]) new Object[arrayBacket.length * 2];
        size = 0;
        for (int i = 0; i < oldArrayBasket.length; i++) {
            Basket curBasket = oldArrayBasket[i];
            Basket.Node node = curBasket.head;
            while (node != null) {
                put(node.value.key, node.value.value);
                node = node.next;
            }
            oldArrayBasket[i] = null;
        }

    }

    private void checkHashSize() {
        if ((float) size / (float) arrayBacket.length > LOAD_FACTOR) {
            increseArray();
        }
    }

    private int calcIndex(K key) {
        return key.hashCode() % arrayBacket.length;
    }

    private class Entity {
        private K key;
        private V value;
    }

    private class Basket {
        private Node head;

        private class Node {
            private Node next;
            private Entity value;
        }

        private V get(K key) {
            Node curNode = head;
            while (curNode != null) {
                if (curNode.value.key.equals(key)) {
                    return curNode.value.value;
                }
            }
            return null;
        }

        private boolean remove(K key) {
            if (head != null) {
                Node curNode = head;
                if (curNode.value.key.equals(key)) {
                    head = head.next;
                    return true;
                }
                while (curNode.next != null) {
                    if (curNode.next.value.key.equals(key)) {
                        curNode.next = curNode.next.next;
                        return true;
                    }
                    curNode = curNode.next;
                }
            }
            return false;
        }

        private boolean add(Entity entity) {
            Node newNode = new Node();
            newNode.value = entity;
            if (head != null) {
                Node curNode = head;
                while (true) {
                    if (curNode.value.key.equals(entity.key)) {
                        return false;
                    }
                    if (curNode.next == null) {
                        curNode.next = newNode;
                        return true;
                    } else {
                        curNode = curNode.next;
                    }
                }
            } else {
                head = newNode;
                return true;
            }

        }
    }

    public boolean put(K key, V value) {
        int index = calcIndex(key);
        Basket basket = arrayBacket[index];
        if (basket == null) {
            basket = new Basket();
            arrayBacket[index] = basket;
        }
        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;
        boolean result = basket.add(entity);
        if (result) {
            size++;
            checkHashSize();
        }
        return result;
    }

    public boolean remove(K key) {
        int index = calcIndex(key);
        boolean result = arrayBacket[index].remove(key);
        if (result) {
            size--;
        }
        return result;
    }

    public V get(K key) {
        int index = calcIndex(key);
        Basket basket = arrayBacket[index];
        if (basket != null) {
            return basket.get(key);
        }
        return null;
    }

}
