#include <iostream>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

bool HasPathSum(TreeNode* root, int sum) {
    if (!root) {
        return false;
    }
    if (!root->left && !root->right && root->val == sum) {
        return true;
    }
    return HasPathSum(root->left, sum - root->val) || HasPathSum(root->right, sum - root->val);
}

int main() {
    auto root = new TreeNode(5);
    root->left = new TreeNode(4);
    root->left->left = new TreeNode(11);
    root->left->left->left = new TreeNode(7);
    root->left->left->right = new TreeNode(2);
    root->right = new TreeNode(8);
    root->right->left = new TreeNode(13);
    root->right->right = new TreeNode(4);
    root->right->right->right = new TreeNode(1);
    cout << HasPathSum(root, 22);
    return 0;
}