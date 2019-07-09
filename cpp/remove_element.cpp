#include <iostream>
#include <vector>

using namespace std;

int RemoveElement(vector<int>& nums, int val) {
    if (nums.empty()) {
        return 0;
    }
    int len = 0;
    for (int i = 0; i < nums.size(); i++) {
        if (nums[i] == val) {
            continue;
        }
        nums[len] = nums[i];
        len += 1;
    }
    return len;
}

int main() {
    vector<int> nums = {0, 1, 2, 2, 3, 0, 4, 2};
    int val = 2;
    int len = RemoveElement(nums, val);
    for (int i = 0; i < len; i++) {
        cout << nums[i] << " ";
    }
    return 0;
}