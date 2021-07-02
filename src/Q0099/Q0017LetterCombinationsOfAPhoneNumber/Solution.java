package Q0099.Q0017LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        dfs(digits, new StringBuilder(), 0);
        return result;
    }

    void dfs(String str, StringBuilder letter, int index) {
        if (index == str.length()) {
            result.add(letter.toString());
            return;
        }

        int f = str.charAt(index) - '2';
        String map_string = map[f];
        for (int i = 0; i < map_string.length(); i++) {
            letter.append(map_string.charAt(i));
            dfs(str, letter, index + 1);
            letter.deleteCharAt(letter.length() - 1);
        }
    }
}
