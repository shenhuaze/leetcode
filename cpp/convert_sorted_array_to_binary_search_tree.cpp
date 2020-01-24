#include <iostream>
#include <vector>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

TreeNode* Helper(vector<int>& nums, int left, int right) {
    if (left > right) {
        return nullptr;
    }
    int mid = left + (right - left) / 2;
    auto root = new TreeNode(nums[mid]);
    root->left = Helper(nums, left, mid - 1);
    root->right = Helper(nums, mid + 1, right);
    return root;
}

TreeNode* SortedArrayToBST(vector<int>& nums) {
    return Helper(nums, 0, nums.size() - 1);
}

int main() {
    vector<int> nums = {-10, -3, 0, 5, 9};
    auto root = SortedArrayToBST(nums);
    return 0;
}