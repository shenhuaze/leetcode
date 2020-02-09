#include <iostream>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

int Helper(TreeNode* root, int& result) {
    if (!root) {
        return 0;
    }
    int left = max(Helper(root->left, result), 0);
    int right = max(Helper(root->right, result), 0);
    result = max(result, left + right + root->val);
    return max(left, right) + root->val;
}

int MaxPathSum(TreeNode* root) {
    int result = INT_MIN;
    Helper(root, result);
    return result;
}

int main() {
    auto root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(3);
    cout << MaxPathSum(root);
    return 0;
}