package Q0099.Q0006ZigZagConversion;

public class Solution2 {
    public String convert(String s, int numRows) {
        int len = s.length();

        if (len < numRows || numRows <= 1)
            return s;

        char zigZag[] = new char[len];
        int interval = 2 * numRows - 2;
        int count = 0;

        for (int i = 0; i < numRows; i++) {
            int step = interval - 2 * i;

            for (int j = i; j < len; j = j + interval) {

                zigZag[count] = s.charAt(j);
                count++;
                if (step > 0 && step < interval && j + step < len) {
                    zigZag[count] = s.charAt(j + step);
                    count++;
                }
            }
        }

        return new String(zigZag);
    }
}
