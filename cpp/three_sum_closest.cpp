#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int ThreeSumClosest(vector<int>& nums, int target) {
    int closest = nums[0] + nums[1] + nums[2];
    int diff = abs(closest - target);
    sort(nums.begin(), nums.end());
    for (int i = 0; i < nums.size() - 2; i++) {
        int left = i + 1;
        int right = nums.size() - 1;
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            int new_diff = abs(sum - target);
            if (new_diff < diff) {
                diff = new_diff;
                closest = sum;
            }
            if (sum < target) {
                left += 1;
            } else {
                right -= 1;
            }
        }
    }
    return closest;
}

int main() {
    vector<int> nums = {-3, -2, -5, 3, -4};
    int target = -1;
    cout << ThreeSumClosest(nums, target);
    return 0;
}