//
// Created by jun on 2020/6/27.
//


#include <iostream>
#include <string>
#include <map>
#include <algorithm>
#include <vector>

using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if (s.empty()) return 0;
        map<char, int> lastOccurred;
        int res = 0;
        for (int start = 0, end = 0; end < s.size(); end++) {
            if (lastOccurred.find(s[end]) != lastOccurred.end()) {
                start = max(start, lastOccurred[s[end]] + 1);
            }
            lastOccurred[s[end]] = end;
            res = max(res, end - start + 1);
        }
        return res;
    }

    /**
     * 使用数组做自定义哈希表
     * @param s
     * @return
     */
    int lengthOfLongestSubstring2(string s) {
        int lastOccurred[128] = {0};
        int res = 0;

        for (int start = 0, end = 0; end < s.size(); end++) {
            if (lastOccurred[s[end]] >= start) {
                start = lastOccurred[s[end]];
            }
            res = max(res, end - start + 1);
            lastOccurred[s[end]] = end + 1;
        }
        return res;
    }

};