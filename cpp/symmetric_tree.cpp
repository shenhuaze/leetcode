#include <iostream>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

bool IsEqual(TreeNode* left, TreeNode* right) {
    if (!left && !right) {
        return true;
    } else if(!left || !right) {
        return false;
    } else if (left->val != right->val) {
        return false;
    }
    return IsEqual(left->right, right->left) && IsEqual(left->left, right->right);
}

bool IsSymmetric(TreeNode* root) {
    if (!root) {
        return true;
    }
    return IsEqual(root->left, root->right);
}

int main() {
    auto root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(2);
    root->left->left = new TreeNode(3);
    root->right->right = new TreeNode(3);
    root->left->right = new TreeNode(4);
    root->right->left = new TreeNode(4);
    cout << IsSymmetric(root);
    return 0;
}