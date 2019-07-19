#include <iostream>
#include <vector>

using namespace std;

/**
 * @author Huaze Shen
 * @date 2019-07-19
 */
int FirstMissingPositive(vector<int>& nums) {
    if (nums.empty()) {
        return 1;
    }
    int size = nums.size();
    for (int i = 0; i < size; i++) {
        while (nums[i] > 0 && nums[i] <= size && nums[i] != nums[nums[i] - 1]) {
            swap(nums[i], nums[nums[i] - 1]);
        }
    }
    for (int i = 0; i < size; i++) {
        if (nums[i] != i + 1) {
            return i + 1;
        }
    }
    return size + 1;
}

int main() {
    vector<int> nums = {-1, 4, 2, 1, 9, 10};
    cout << FirstMissingPositive(nums);
    return 0;
}