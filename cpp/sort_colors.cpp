#include <iostream>
#include <vector>

using namespace std;

void SortColors(vector<int>& nums) {
    int red = 0;
    int blue = int(nums.size()) - 1;
    for (int i = 0; i <= blue; i++) {
        if (nums[i] == 0) {
            swap(nums[i], nums[red]);
            red += 1;
        } else if (nums[i] == 2) {
            swap(nums[i], nums[blue]);
            i -= 1;
            blue -= 1;
        }
    }
}

int main() {
    vector<int> nums = {2, 0, 2, 1, 1, 0};
    SortColors(nums);
    for (int i: nums) {
        cout << i << " ";
    }
    return 0;
}