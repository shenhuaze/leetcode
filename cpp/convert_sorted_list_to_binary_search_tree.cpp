#include <iostream>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

TreeNode* SortedListToBST(ListNode* head) {
    if (!head) {
        return nullptr;
    }
    if (!head->next) {
        return new TreeNode(head->val);
    }
    auto last = head;
    auto slow = head;
    auto fast = head;
    while (fast && fast->next) {
        last = slow;
        slow = slow->next;
        fast = fast->next->next;
    }
    last->next = nullptr;
    auto right_head = slow->next;
    auto root = new TreeNode(slow->val);
    root->left = SortedListToBST(head);
    root->right = SortedListToBST(right_head);
    return root;
}

int main() {
    auto head = new ListNode(-10);
    head->next = new ListNode(-3);
    head->next->next = new ListNode(0);
    head->next->next->next = new ListNode(5);
    head->next->next->next->next = new ListNode(9);
    auto root = SortedListToBST(head);
    return 0;
}