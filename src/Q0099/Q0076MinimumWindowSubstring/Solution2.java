package Q0099.Q0076MinimumWindowSubstring;

public class Solution2 {
    public String minWindow(String s, String t) {
        int counts[] = new int[256];
        int missingChars = t.length();
        for (int i = 0; i < missingChars; i++) {
            counts[t.charAt(i)]++;
        }

        int winstart = 0;
        int winend = 0;
        int bestwinstart = 0;
        int bestwinlen = s.length() + 1;
        char schars[] = s.toCharArray();
        while (true) {
            if (missingChars == 0) {
                if (++counts[schars[winstart++]] > 0) {
                    missingChars++;
                }
            } else {
                if (winend >= schars.length) {
                    break;
                }
                if (--counts[schars[winend++]] >= 0) {
                    missingChars--;
                }
            }
            if (missingChars == 0 && bestwinlen > winend - winstart) {
                bestwinstart = winstart;
                bestwinlen = winend - winstart;
            }
        }

        return bestwinlen > s.length() ? "" : s.substring(bestwinstart, bestwinstart + bestwinlen);
    }
}