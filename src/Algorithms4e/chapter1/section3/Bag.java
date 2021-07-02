package Algorithms4e.chapter1.section3;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;

        public Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node first;
    private int size;

    public int size() {
        return size;
    }

    public void add(Item item) {
        Node oldFirst = first;
        first = new Node(item, oldFirst);

        size++;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
