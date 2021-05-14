package Algorithms4e.chapter1.section1;

/*
   1.1.12 What does the following code fragment print?
 */
public class Exercise12 {
    public static void main(String[] args) {
        int[] a = new int[10];

        for (int i = 0; i < 10; i++) a[i] = 9 - i;
        // index:   0 1 2 3 4 5 6 7 8 9
        // content: 9 8 7 6 5 4 3 2 1 0

        for (int i = 0; i < 10; i++) a[i] = a[a[i]];
        // a[0] = a[9] = 0
        // a[1] = a[8] = 1
        // a[2] = a[7] = 2
        // a[3] = a[6] = 3
        // a[4] = a[5] = 4
        // a[5] = a[4] = 4
        // a[6] = a[3] = 3
        // a[7] = a[2] = 2
        // a[8] = a[1] = 1
        // a[9] = a[0] = 0

        for (int i = 0; i < 10; i++) System.out.println(i);
    }
}
