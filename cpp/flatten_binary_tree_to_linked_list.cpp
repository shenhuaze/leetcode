#include <iostream>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

void Flatten(TreeNode* root) {
    if (!root) {
        return;
    }
    Flatten(root->left);
    Flatten(root->right);
    auto temp = root->right;
    root->right = root->left;
    root->left = nullptr;
    while (root->right) {
        root = root->right;
    }
    root->right = temp;
}

int main() {
    auto root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->left->left = new TreeNode(3);
    root->left->right = new TreeNode(4);
    root->right = new TreeNode(5);
    root->right->right = new TreeNode(6);
    Flatten(root);
    while (root) {
        cout << root->val << " ";
        root = root->right;
    }
    return 0;
}