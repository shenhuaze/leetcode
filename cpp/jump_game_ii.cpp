#include <iostream>
#include <vector>

using namespace std;

int Jump(vector<int>& nums) {
    if (nums.empty() || nums.size() < 2) {
        return 0;
    }
    int i = 0;
    int current_max = 0;
    int level = 0;
    while (i <= current_max) {
        int furthest = current_max;
        for (int j = i; j <= current_max; j++) {
            furthest = max(furthest, j + nums[j]);
            if (furthest >= nums.size() - 1) {
                return level + 1;
            }
        }
        i = current_max + 1;
        current_max = furthest;
        level += 1;
    }
    return -1;
}

int main() {
    vector<int> nums = {2, 3, 1, 1, 4};
    cout << Jump(nums);
    return 0;
}