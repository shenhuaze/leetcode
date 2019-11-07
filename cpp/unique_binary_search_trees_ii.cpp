#include <iostream>
#include <vector>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

vector<TreeNode*> Helper(int start, int end) {
    vector<TreeNode*> results;
    if (start > end) {
        results.push_back(nullptr);
    }
    for (int i = start; i <= end; i++) {
        vector<TreeNode*> left_nodes = Helper(start, i - 1);
        vector<TreeNode*> right_nodes = Helper(i + 1, end);
        for (TreeNode* left_node: left_nodes) {
            for (TreeNode* right_node: right_nodes) {
                auto root = new TreeNode(i);
                root->left = left_node;
                root->right = right_node;
                results.push_back(root);
            }
        }
    }
    return results;
}

vector<TreeNode*> GenerateTrees(int n) {
    if (n == 0) {
        return {};
    }
    return Helper(1, n);
}


int main() {
    vector<TreeNode*> results = GenerateTrees(2);
    return 0;
}