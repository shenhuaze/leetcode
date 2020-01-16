#include <iostream>
#include <vector>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

TreeNode* Helper(vector<int>& preorder, int pre_start, int pre_end, vector<int>& inorder, int in_start, int in_end) {
    if (pre_start > pre_end || in_start > in_end) {
        return nullptr;
    }
    auto root = new TreeNode(preorder[pre_start]);
    int i = in_start;
    while (i <= in_end) {
        if (inorder[i] == preorder[pre_start]) {
            break;
        }
        i += 1;
    }
    root->left = Helper(preorder, pre_start + 1, pre_start + i - in_start, inorder, in_start, i - 1);
    root->right = Helper(preorder, pre_start + i - in_start + 1, pre_end, inorder, i + 1, in_end);
    return root;
}

TreeNode* BuildTree(vector<int>& preorder, vector<int>& inorder) {
    if (preorder.empty()) {
        return nullptr;
    }
    return Helper(preorder, 0, (int)preorder.size() - 1, inorder, 0, (int)inorder.size() - 1);
}

int main() {
    vector<int> preorder = {3, 9, 20, 15, 7};
    vector<int> inorder = {9, 3, 15, 20, 7};
    auto root = BuildTree(preorder, inorder);
    return 0;
}