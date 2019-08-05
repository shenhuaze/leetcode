#include <iostream>
#include <vector>

using namespace std;

/**
 * @author Huaze Shen
 * @date 2019-08-03
 */
bool CanJump(vector<int>& nums) {
    if (nums.empty()) {
        return false;
    }
    int size = (int)nums.size();
    int left_most_good_index = size - 1;
    for (int i = size - 2; i >= 0; i--) {
        if (i + nums[i] >= left_most_good_index) {
            left_most_good_index = i;
        }
    }
    return left_most_good_index == 0;
}

int main() {
    vector<int> nums = {3, 2, 1, 0, 4};
    cout << CanJump(nums);
    return 0;
}