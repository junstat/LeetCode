package Algorithms4e.chapter1.section1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/*
   1.1.21 Write a program that reads in lines from standard input with each line containing a name and two integers and
   then uses prinf() to print a table with a column of the names, the integers, and the result of dividing the first by
   the second, accurate to three decimal places. You could use a program like this to tabulate batting averages for
   baseball players or grades for students.
 */
public class Exercise21 {
    // Parameters example:
    // Rene 2 1
    // Bacon 4 3
    // Abcdef 6 2
    public static void main(String[] args) {
        StdOut.printf("%8s %7s %7s %7s", "Names", "Number1", "Number2", "Result\n");

        In in = new In();
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] values = line.split(" ");
            formattedPrint(values);
        }
    }

    private static void formattedPrint(String[] values) {
        StdOut.printf("%8s", values[0]);
        StdOut.printf("%8s", values[1]);
        StdOut.printf("%8s", values[2]);

        double value1 = Double.parseDouble(values[1]);
        double value2 = Double.parseDouble(values[2]);
        double result = value1 / value2;
        StdOut.printf("%7.3f \n", result);
    }
}
