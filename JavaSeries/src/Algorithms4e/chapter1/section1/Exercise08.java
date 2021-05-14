package Algorithms4e.chapter1.section1;

/*
   1.1.8 What do each of the following print?
 */
public class Exercise08 {
    public static void main(String[] args) {
        System.out.println('b');
        // a) b -> converts the char "b" to String and prints it
        System.out.println('b' + 'c');
        // b) 197 -> sums the char codes of "b" and "c", converts to String and prints it
        System.out.println((char) ('a' + 4));
        // c) e -> sums the char code of "a" with 4, converts it to char and prints it
    }
}
