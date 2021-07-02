package Algorithms4e.chapter1.section3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
   1.3.1 为FixedCapacityStackOfStrings添加一个方法isFull()
 */
public class Exercise01<Item> {
    private final Item[] a;  // stack entries
    private int n;       // size

    public Exercise01(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        a[n++] = item;
    }

    public Item pop() {
        return a[--n];
    }

    public boolean isFull() {
        return n == a.length;
    }

    public static void test1() {
        Exercise01 fixedCapacityStackOfStrings = new Exercise01(2);
        StdOut.println("Is Full 1: " + fixedCapacityStackOfStrings.isFull() + " Expected: false");

        fixedCapacityStackOfStrings.push("a");
        fixedCapacityStackOfStrings.push("b");
        StdOut.println("Is Full 2: " + fixedCapacityStackOfStrings.isFull() + " Expected: true");
    }

    public static void main(String[] args) throws FileNotFoundException {
        Exercise01 s = new Exercise01(100);

        // FileInputStream fis = new FileInputStream("/Users/jun/Documents/Learn/LeetCode/src/Algorithms4e/chapter1/section3/tobe.txt");
        // System.setIn(fis);

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
