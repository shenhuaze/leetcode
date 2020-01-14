#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

vector<vector<int>> LevelOrder(TreeNode* root) {
    vector<vector<int>> results;
    if (!root) {
        return results;
    }
    queue<TreeNode*> q;
    q.push(root);
    while (!q.empty()) {
        int size = q.size();
        vector<int> level_list;
        for (int i = 0; i < size; i++) {
            TreeNode* node = q.front();
            if (!node) {
                continue;
            }
            level_list.push_back(node->val);
            if (node->left) {
                q.push(node->left);
            }
            if (node->right) {
                q.push(node->right);
            }
            q.pop();
        }
        results.push_back(level_list);
    }
    return results;
}

int main() {
    auto root = new TreeNode(3);
    root->left = new TreeNode(9);
    root->right = new TreeNode(20);
    root->right->left = new TreeNode(15);
    root->right->right = new TreeNode(7);
    vector<vector<int>> results = LevelOrder(root);
    for (vector<int> level: results) {
        for (int i: level) {
            cout << i << " ";
        }
        cout << "\n";
    }
    return 0;
}