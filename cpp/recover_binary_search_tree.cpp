#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

void Inorder(TreeNode* root, vector<TreeNode*>& node_list, vector<int>& value_list) {
    if (!root) {
        return;
    }
    Inorder(root->left, node_list, value_list);
    node_list.push_back(root);
    value_list.push_back(root->val);
    Inorder(root->right, node_list, value_list);
}

void RecoverTree(TreeNode* root) {
    vector<TreeNode*> node_list;
    vector<int> value_list;
    Inorder(root, node_list, value_list);
    sort(value_list.begin(), value_list.end());
    for (int i = 0; i < node_list.size(); i++) {
        node_list[i]->val = value_list[i];
    }
}

int main() {
    auto root = new TreeNode(1);
    root->left = new TreeNode(3);
    root->left->right = new TreeNode(2);
    RecoverTree(root);
    return 0;
}