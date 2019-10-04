#include <iostream>
#include <vector>

using namespace std;

int RemoveDuplicates(vector<int>& nums) {
    int index = 0;
    for (int num: nums) {
        if (index < 2 || num > nums[index - 2]) {
            nums[index] = num;
            index += 1;
        }
    }
    return index;
}

int main() {
    vector<int> nums = {1, 1, 1, 2, 2, 3};
    cout << RemoveDuplicates(nums);
    return 0;
}