#include <iostream>
#include <vector>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

void Helper(vector<vector<int>>& results, vector<int>& path, TreeNode* root, int sum) {
    if (!root) {
        return;
    }
    path.push_back(root->val);
    if (root->val == sum && !root->left && !root->right) {
        results.push_back(path);
    }
    Helper(results, path, root->left, sum - root->val);
    Helper(results, path, root->right, sum - root->val);
    path.pop_back();
}

vector<vector<int>> PathSum(TreeNode* root, int sum) {
    vector<vector<int>> results;
    vector<int> path;
    Helper(results, path, root, sum);
    return results;
}

int main() {
    auto root = new TreeNode(5);
    root->left = new TreeNode(4);
    root->left->left = new TreeNode(11);
    root->left->left->left = new TreeNode(7);
    root->left->left->right = new TreeNode(2);
    root->right = new TreeNode(8);
    root->right->left = new TreeNode(13);
    root->right->right = new TreeNode(4);
    root->right->right->left = new TreeNode(5);
    root->right->right->right = new TreeNode(1);
    auto results = PathSum(root, 22);
    for (vector<int> path: results) {
        for (int i: path) {
            cout << i << " ";
        }
        cout << "\n";
    }
    return 0;
}