package Q0099.Q0030SubstringWithConcatenationOfAllWords;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
    @Test
    public void test() {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(findSubstring(s, words));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (words.length == 0 || s.length() < words.length * words[0].length()) {
            return list;
        }
        char[] arr = s.toCharArray();
        Map<MyString, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            MyString word = new MyString(words[i]);
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int listLen = words.length;
        int wordLen = words[0].length();

        // 从 0 到 wordLen-1 依次遍历，保证能遍历所有情况。
        for (int i = 0; i < wordLen; i++) {
            for (int j = i; j <= s.length() - wordLen * listLen; j += wordLen) {
                Map<MyString, Integer> map2 = new HashMap<>();
                // 从尾往头遍历，判断往后第 k 个 len 位置的子串是否在 map 中
                for (int k = listLen - 1; k >= 0; k--) {
                    MyString temp = new MyString(arr, j + k * wordLen, wordLen);
                    int val = map2.getOrDefault(temp, 0) + 1;
                    // 如果从 j+k*wordLen, j 到 (k+1)*wordLen 位置的子串不在 map 中
                    // 代表可以从 j 到 j+(k+1)*wordLen 这一段都可以舍弃
                    // 这里只需把 j 移动 k*wordLen，剩余的一个 wordLen 在循环体中移动。
                    if (val > map.getOrDefault(temp, 0)) {
                        j += k * wordLen;
                        break;
                    }
                    // k 到 0 代表找到了符合的子串
                    if (k == 0) {
                        list.add(j);
                    } else {
                        map2.put(temp, val);
                    }
                }
            }
        }
        return list;
    }

    private static class MyString {
        private final char[] arr;
        private final int offset;
        private final int len;
        private final int hashCode;

        MyString(String s) {
            this(s.toCharArray(), 0, s.length());
        }

        MyString(char[] arr, int offset, int len) {
            this.arr = arr;
            this.offset = offset;
            this.len = len;
            int h = 0;
            for (int i = 0; i < len; ++i) {
                h = 31 * h + arr[offset + i];
            }
            this.hashCode = h;
        }

        public int hashCode() {
            return hashCode;
        }

        public boolean equals(Object o) {
            if (o instanceof MyString) {
                MyString other = (MyString) o;
                if (len != other.len) {
                    return false;
                }
                for (int i = offset, j = other.offset; i < len; ++i, ++j) {
                    if (arr[i] != other.arr[j]) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    }
}
