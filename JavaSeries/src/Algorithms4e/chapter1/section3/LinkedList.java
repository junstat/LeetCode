package Algorithms4e.chapter1.section3;

import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item> {

    private int size;
    private Node<Item> first;

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public Node<Item> getFirst() {
        return first;
    }

    public Item get(int index) {
        if (isEmpty()) return null;

        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Index must be between 0 and " + (size - 1));

        Node<Item> current = first;
        int currentIndex = 0;

        while (currentIndex < index) {
            currentIndex++;
            current = current.next;
        }

        return current.item;
    }

    public void insert(Item item) {
        if (first == null)
            first = new Node<>(item);
        else {
            Node<Item> current = first;

            while (current.next != null)
                current = current.next;

            current.next = new Node<Item>(item);
        }
        size++;
    }

    public void remove(int index) {
        if (isEmpty()) return;

        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Index must be between 0 and " + (size - 1));

        if (index == 0)
            first = first.next;
        else {
            Node<Item> current = first;
            int currentIndex = 0;

            while (currentIndex < index - 1) {
                currentIndex++;
                current = current.next;
            }

            current.next = current.next.next;
        }
        size--;
    }

    public void remove(Item item) {
        if (isEmpty()) return;

        if (item.equals(first.item)) {
            first = first.next;
            size--;
        } else {
            Node<Item> current = first;

            while (current.next != null && !current.next.item.equals(item)) {
                current = current.next;
            }

            if (current.next != null) {
                current.next = current.next.next;
                size--;
            }
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }

    public class LinkedListIterator implements Iterator<Item> {

        Node<Item> currentNode = first;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Item next() {
            Item item = currentNode.item;
            currentNode = currentNode.next;
            return item;
        }
    }
}
