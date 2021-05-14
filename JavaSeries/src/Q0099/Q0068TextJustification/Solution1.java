package Q0099.Q0068TextJustification;

import java.util.ArrayList;
import java.util.List;

class Solution1 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        int size = 0;
        for (String word : words) {
            int incSize = size + word.length() + curr.size();
            if (incSize <= maxWidth) {
                curr.add(word);
                size = size + word.length();
            } else {
                int f = maxWidth - size;
                int d = curr.size() > 1 ? curr.size() - 1 : curr.size();
                int q = f / d;
                int r = f % d;
                StringBuilder filler = new StringBuilder();
                while (q != 0) {
                    filler.append(' ');
                    q--;
                }

                StringBuilder sb = new StringBuilder();
                for (String w : curr) {
                    if (sb.length() > 0) {
                        sb.append(filler);
                        if (r != 0) {
                            sb.append(' ');
                            r--;
                        }
                    }
                    sb.append(w);
                }
                while (sb.length() < maxWidth) {
                    sb.append(' ');
                }
                result.add(sb.toString());

                curr = new ArrayList<>();
                curr.add(word);
                size = word.length();
            }
        }

        if (curr.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (String s : curr) {
                if (sb.length() > 0)
                    sb.append(' ');
                sb.append(s);
            }
            while (sb.length() < maxWidth) {
                sb.append(' ');
            }
            result.add(sb.toString());
        }
        return result;
    }
}