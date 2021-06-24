package Algorithms4e.chapter1.section3;

public class Node<Item> {

    public Item item;
    public Node<Item> next;

    public Node(Item item) {
        this.item = item;
    }
}
