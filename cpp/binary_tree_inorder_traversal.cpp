#include <iostream>
#include <vector>
#include <stack>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

vector<int> InorderTraversal(TreeNode* root) {
    vector<int> results;
    stack<TreeNode*> s;
    TreeNode* curr_node = root;
    while (curr_node || !s.empty()) {
        if (curr_node) {
            s.push(curr_node);
            curr_node = curr_node->left;
        } else {
            curr_node = s.top();
            s.pop();
            results.push_back(curr_node->val);
            curr_node = curr_node->right;
        }
    }
    return results;
}

int main() {
    auto root = new TreeNode(1);
    root->right = new TreeNode(2);
    root->right->left = new TreeNode(3);
    vector<int> results = InorderTraversal(root);
    for (int i: results) {
        cout << i << " ";
    }
    return 0;
}