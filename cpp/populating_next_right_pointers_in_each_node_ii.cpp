#include <iostream>

using namespace std;

class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
            : val(_val), left(_left), right(_right), next(_next) {}
};

Node* Connect(Node* root) {
    if (!root) {
        return root;
    }
    auto p = root->next;
    while (p) {
        if (p->left) {
            p = p->left;
            break;
        }
        if (p->right) {
            p = p->right;
            break;
        }
        p = p->next;
    }
    if (root->right) {
        root->right->next = p;
    }
    if (root->left) {
        if (root->right) {
            root->left->next = root->right;
        } else {
            root->left->next = p;
        }
    }
    Connect(root->right);
    Connect(root->left);
    return root;
}

int main() {
    auto root = new Node(1);
    root->left = new Node(2);
    root->right = new Node(3);
    root->left->left = new Node(4);
    root->left->right = new Node(5);
    root->right->right = new Node(7);
    auto root_ = Connect(root);
    return 0;
}