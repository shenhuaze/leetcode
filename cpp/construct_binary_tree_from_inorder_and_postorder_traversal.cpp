#include <iostream>
#include <vector>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

TreeNode* Helper(vector<int>& postorder, int post_start, int post_end, vector<int>& inorder, int in_start, int in_end) {
    if (post_start > post_end || in_start > in_end) {
        return nullptr;
    }
    auto root = new TreeNode(postorder[post_end]);
    int i = in_start;
    while (i <= in_end) {
        if (inorder[i] == postorder[post_end]) {
            break;
        }
        i += 1;
    }
    root->left = Helper(postorder, post_start, post_start + i - in_start - 1, inorder, in_start, i - 1);
    root->right = Helper(postorder, post_start + i - in_start, post_end - 1, inorder, i + 1, in_end);
    return root;
}

TreeNode* BuildTree(vector<int>& inorder, vector<int>& postorder) {
    if (inorder.empty()) {
        return nullptr;
    }
    return Helper(postorder, 0, (int)postorder.size() - 1, inorder, 0, (int)inorder.size() - 1);
}

int main() {
    vector<int> inorder = {9, 3, 15, 20, 7};
    vector<int> postorder = {9, 15, 7, 20, 3};
    auto root = BuildTree(inorder, postorder);
    return 0;
}