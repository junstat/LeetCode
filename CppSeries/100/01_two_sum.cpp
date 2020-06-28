//
// Created by jun on 2020/6/26.
//

#include <vector>
#include <map>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int> &nums, int target) {
        map<int, int> numsIndexMap;
        int otherPart;
        for (int i = 0; i < nums.size(); i++) {
            otherPart = target - nums[i];
            if (numsIndexMap.find(otherPart) != numsIndexMap.end())
                return vector<int>({numsIndexMap[otherPart], i});
            numsIndexMap[nums[i]] = i;
        }
        return vector<int>({});
    }
};