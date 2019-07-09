#include <iostream>
#include <vector>

using namespace std;

int RemoveDuplicates(vector<int>& nums) {
    if (nums.empty()) {
        return 0;
    }
    int len = 1;
    for (int i = 1; i < nums.size(); i++) {
        if (nums[i] == nums[i - 1]) {
            continue;
        }
        len += 1;
        nums[len - 1] = nums[i];
    }
    return len;
}

int main() {
    vector<int> nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    int len = RemoveDuplicates(nums);
    for (int i = 0; i < len; i++) {
        cout << nums[i] << " ";
    }
    return 0;
}