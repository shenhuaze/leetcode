#include <iostream>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

int Depth(TreeNode* root) {
    if (!root) {
        return 0;
    }
    return max(Depth(root->left), Depth(root->right)) + 1;
}

bool IsBalanced(TreeNode* root) {
    if (!root) {
        return true;
    }
    return IsBalanced(root->left) && IsBalanced(root->right) && abs(Depth(root->left) - Depth(root->right)) <= 1;
}

int main() {
    auto root = new TreeNode(3);
    root->left = new TreeNode(9);
    root->right = new TreeNode(20);
    root->right->left = new TreeNode(15);
    root->right->right = new TreeNode(7);
    cout << IsBalanced(root);
    return 0;
}