package Q0199.Q0126WordLadderII;

import java.util.*;

/*
   [Hard]
    The basic idea is:
    1). Use BFS to find the shortest distance between start and end, tracing the distance of crossing nodes from start node to end node, and store node's next level neighbors to HashMap;

    2). Use DFS to output paths with the same distance as the shortest distance from distance HashMap: compare if the distance of the next level node equals the distance of the current node + 1.
 */
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList.size() == 0) return res;
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return res;
        Map<String, List<String>> map = new HashMap<>();
        start.add(beginWord);
        end.add(endWord);
        bfs(map, start, end, dict, false);
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        dfs(map, res, list, beginWord, endWord);
        return res;
    }

    void bfs(Map<String, List<String>> map, Set<String> start, Set<String> end, Set<String> dict, boolean reverse) {
        if (start.isEmpty()) return;
        if (start.size() > end.size()) {
            bfs(map, end, start, dict, !reverse);
            return;
        }
        boolean finish = false;
        Set<String> tmp = new HashSet<>();
        dict.removeAll(start);
        for (String s : start) {
            char[] word = s.toCharArray();
            for (int i = 0; i < word.length; i++) {
                char old = word[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    word[i] = c;
                    String w = new String(word);
                    if (dict.contains(w)) {
                        if (end.contains(w)) finish = true;
                        else tmp.add(w);
                        String key = reverse ? w : s;
                        String val = reverse ? s : w;
                        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
                        map.get(key).add(val);
                    }
                }
                word[i] = old;
            }
        }
        if (!finish) bfs(map, tmp, end, dict, reverse);
    }

    void dfs(Map<String, List<String>> map, List<List<String>> res, List<String> list, String begin, String end) {
        if (begin.equals(end)) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (!map.containsKey(begin)) return;
        for (String s : map.get(begin)) {
            list.add(s);
            dfs(map, res, list, s, end);
            list.remove(list.size() - 1);
        }
    }
}
