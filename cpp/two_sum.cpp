#include <iostream>
#include <vector>
#include <map>

using namespace std;

vector<int> TwoSum(vector<int> &nums, int target) {
    map<int, int> dic;
    vector<int> result;
    for (int i = 0; i < nums.size(); i++) {
        if (dic.count(nums[i])) {
            return {dic[nums[i]], i};
        }
        dic[target - nums[i]] = i;
    }
    return {};
}

int main() {
    vector<int> nums = {2, 7, 11, 15};
    int target = 9;
    vector<int> result = TwoSum(nums, target);
    for (int i : result) {
        cout << i << "\n";
    }
    return 0;
}