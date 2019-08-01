#include <iostream>
#include <vector>

using namespace std;


int Cross(vector<int>& nums, int left, int right, int p) {
    if (left == right) {
        return nums[left];
    }
    int left_max_sum = INT_MIN;
    int curr_sum = 0;
    for (int i = p; i >= left; i--) {
        curr_sum += nums[i];
        left_max_sum = max(left_max_sum, curr_sum);
    }
    int right_max_sum = INT_MIN;
    curr_sum = 0;
    for (int i = p + 1; i <= right; i++) {
        curr_sum += nums[i];
        right_max_sum = max(right_max_sum, curr_sum);
    }
    return left_max_sum + right_max_sum;
}

int Helper(vector<int>& nums, int left, int right) {
    if (left == right) {
        return nums[left];
    }
    int p = (left + right) / 2;
    int left_sum = Helper(nums, left, p);
    int right_sum = Helper(nums, p + 1, right);
    int cross_sum = Cross(nums, left, right, p);
    return max(max(left_sum, right_sum), cross_sum);
}

int MaxSubArray(vector<int>& nums) {
    return Helper(nums, 0, (int)nums.size() - 1);
}

int main() {
    vector<int> nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    cout << MaxSubArray(nums);
    return 0;
}