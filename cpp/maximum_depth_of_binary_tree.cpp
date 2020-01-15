#include <iostream>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

int MaxDepth(TreeNode* root) {
    if (!root) {
        return 0;
    }
    return max(MaxDepth(root->left), MaxDepth(root->right)) + 1;
}

int main() {
    auto root = new TreeNode(3);
    root->left = new TreeNode(9);
    root->right = new TreeNode(20);
    root->right->left = new TreeNode(15);
    root->right->right = new TreeNode(7);
    cout << MaxDepth(root);
    return 0;
}