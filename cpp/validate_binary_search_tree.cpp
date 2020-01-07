#include <iostream>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

bool Helper(TreeNode* root, long low, long high) {
    if (!root) {
        return true;
    }
    if (root->val <= low || root->val >= high) {
        return false;
    }
    return Helper(root->left, low, root->val) && Helper(root->right, root->val, high);
}

bool IsValidBST(TreeNode* root) {
    return Helper(root, LONG_MIN, LONG_MAX);
}

int main() {
    auto root = new TreeNode(2);
    root->left = new TreeNode(1);
    root->right = new TreeNode(3);
    cout << IsValidBST(root);
    return 0;
}