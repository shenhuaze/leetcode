#include <iostream>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

bool IsSameTree(TreeNode* p, TreeNode* q) {
    if (!p && !q) {
        return true;
    } else if (!p) {
        return false;
    } else if (!q) {
        return false;
    }
    return p->val == q->val && IsSameTree(p->left, q->left) && IsSameTree(p->right, q->right);
}

int main() {
    auto root1 = new TreeNode(1);
    root1->left = new TreeNode(2);
    root1->right = new TreeNode(3);
    auto root2 = new TreeNode(1);
    root2->left = new TreeNode(2);
    root2->right = new TreeNode(3);
    cout << IsSameTree(root1, root2);
    return 0;
}