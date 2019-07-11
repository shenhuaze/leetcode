#include <iostream>
#include <vector>

using namespace std;

/**
 * @author Huaze Shen
 * @date 2019-07-11
 */
void swap(vector<int>& nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}

void reverse(vector<int>& nums, int i) {
    int left = i;
    int right = nums.size() - 1;
    while (left < right) {
        swap(nums, left, right);
        left += 1;
        right -= 1;
    }
}

void NextPermutation(vector<int>& nums) {
    int len = nums.size();
    int i = len - 2;
    while (i >= 0) {
        if (nums[i] < nums[i + 1]) {
            int j = len - 1;
            while (j > i) {
                if (nums[j] > nums[i]) {
                    break;
                }
                j -= 1;
            }
            swap(nums, i, j);
            reverse(nums, i + 1);
            return;
        }
        i -= 1;
    }
    reverse(nums, 0);
}

int main() {
    vector<int> nums = {3, 2, 1};
    NextPermutation(nums);
    for (int num : nums) {
        cout << num << " ";
    }
    return 0;
}