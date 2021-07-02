package Q0099.Q0030SubstringWithConcatenationOfAllWords;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
   思路一: 因为单词长度固定，可以计算出截取字符串的单词个数是否和`words`里的各单词出现次数是否相等。count操作的结果保存在 map结构里。
   时间复杂度: O(n^2)
 */
public class Solution {

    @Test
    public void test() {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(findSubstring(s, words));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int oneWord = words[0].length();
        int wordNum = words.length;
        int allLen = oneWord * wordNum;
        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        for (int i = 0; i < s.length() - allLen + 1; i++) {
            String tmp = s.substring(i, i + allLen);
            HashMap<String, Integer> tmpMap = new HashMap<>();
            for (int j = 0; j < allLen; j += oneWord) {
                String w = tmp.substring(j, j + oneWord);
                tmpMap.put(w, tmpMap.getOrDefault(w, 0) + 1);
            }
            if (map.equals(tmpMap)) res.add(i);
        }
        return res;
    }
}
