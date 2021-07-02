package Algorithms4e.chapter1.section1;

/*
   1.1.17 Criticize the following recursive function:
   Answer: The base case will never be reached. A call to exR2(3) will result in calls to exR2(0), exR2(-3), exR2(-6),
   and so forth until a StackOverflowError occurs.
 */
public class Exercise17 {
    public static String exR2(int n) {
        String s = exR2(n - 3) + n + exR2(n - 2) + n;
        if (n <= 0) return "";
        return s;
    }
}
// The function never stops because it keeps calling itself on the first line, until a StackOverflowError occurs.
