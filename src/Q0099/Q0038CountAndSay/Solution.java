package Q0099.Q0038CountAndSay;

public class Solution {
    public String countAndSay(int n) {
        String prevLine = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder nextLine = new StringBuilder();
            char num = prevLine.charAt(0);
            int count = 1;
            for (int j = 1; j < prevLine.length(); j++) {
                if (prevLine.charAt(j) == num) count++;
                else {
                    nextLine.append(count).append(num);
                    num = prevLine.charAt(j);
                    count = 1;
                }
            }
            nextLine.append(count).append(num);
            prevLine = nextLine.toString();
        }
        return prevLine;
    }
}
